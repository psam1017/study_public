package ch10_hash;

// ü�ι��� ���� �ؽ�

public class ChainHash<K,V> {

    //--- �ؽø� �����ϴ� ��� ---//
    @SuppressWarnings("hiding")
		class Node<K,V> {
        private K key;                 // Ű��
        private V data;                // ������
        private Node<K,V> next;        // ���� ������(���� ��忡 ���� ����)

        //--- ������(constructor) ---//
        Node(K key, V data, Node<K,V> next) {
            this.key  = key;
            this.data = data;
            this.next = next;
        }

        //--- Ű���� ��ȯ ---//
        K getKey() {
            return key;
        }

        //--- �����͸� ��ȯ ---//
        V getValue() {
            return data;
        }

        //--- Ű�� �ؽð��� ��ȯ ---//
        public int hashCode() {
            return key.hashCode();
        }
    }

    private int    size;              // �ؽ� ���̺��� ũ��
    private Node<K,V>[] table;        // �ؽ� ���̺�

    //--- ������(constructor) ---//
    @SuppressWarnings("unchecked")
		public ChainHash(int capacity) {
        try {
            table = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {        // ���̺��� ������ �� ����
            this.size = 0;
        }
    }

    //--- �ؽð��� ���� ---//
    public int hashValue(Object key) {
        return key.hashCode() % size;
    }

    //--- Ű���� key�� ��Ҹ� �˻�(�����͸� ��ȯ) ---//
    public V search(K key) {
        int hash = hashValue(key);            // �˻��� �������� �ؽð�
        Node<K,V> p = table[hash];            // ���� ���

        while (p != null) {
            if (p.getKey().equals(key))
                return p.getValue();                // �˻� ����
            p = p.next;                             // ���� ��带 ����
        }
        return null;                                // �˻� ����
    }

    //--- Ű���� key�� �����͸� data�� ��ҷ� �߰� ---//
    public int add(K key, V data) {
        int hash = hashValue(key);            // �߰��� �������� �ؽð�
        Node<K,V> p = table[hash];            // ���� ���

        while (p != null) {
            if (p.getKey().equals(key))       // Ű���� �̹� ��ϵ�
                return 1;
            p = p.next;                       // ���� ��带 ����
        }
        Node<K,V> temp = new Node<K,V>(key, data, table[hash]);
        table[hash] = temp;                   // ��� ����
        return 0;
    }

    //--- Ű���� key�� ��Ҹ� ���� ---//
    public int remove(K key) {
        int hash = hashValue(key);            // ������ �������� �ؽð�
        Node<K,V> p = table[hash];            // ���� ���
        Node<K,V> pp = null;                  // �ٷ� ���� ���� ���

        while (p != null) {
            if (p.getKey().equals(key)) {    //ã����
                if (pp == null)
                    table[hash] = p.next;
                else
                    pp.next = p.next;
                return 0;
            }
            pp = p;
            p = p.next;                       // ���� ��带 ����
        }
        return 1;                             // ã�� Ű���� ����
    }

    //--- �ؽ� ���̺��� ����(dump) ---//
    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K,V> p = table[i];
            System.out.printf("%02d  ", i);
            while (p != null) {
                System.out.printf("�� %s (%s)  ", p.getKey(), p.getValue());
                p = p.next;
            }
            System.out.println();
        }
    }
}