package ch09_tree;

// �����˻�Ʈ��Ŭ����BinTree<K,V>�� ��� ��

import java.util.Scanner;

class BinTreeTester {
    static Scanner stdIn = new Scanner(System.in);

    //--- ������(ȸ�� ��ȣ���̸�) ---//
    static class Data {
        public static final int NO   = 1;    // ��ȣ�� �о� ���ϱ��?
        public static final int NAME = 2;    // �̸��� �о� ���ϱ��?

        private Integer no;                // ȸ����ȣ(Ű��)
        private String  name;              // �̸�

        //--- Ű�� ---//
        Integer keyCode() {
            return no;
        }

        //--- ���ڿ� ǥ���� ��ȯ ---//
        public String toString() {
            return name;
        }

        //--- �����͸� �о� ���� ---//
        void scanData(String guide, int sw) {
            System.out.println(guide + "�� �����͸� �Է��ϼ���.");

            if ((sw & NO) == NO) {
                System.out.print("��ȣ  ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("�̸�  ");
                name = stdIn.next();
            }
        }
    }

    //--- �޴� ������ ---//
    enum Menu {
        ADD(      "����"),
        REMOVE(   "����"),
        SEARCH(   "�˻�"),
        PRINT(    "ǥ��"),
        TERMINATE("����");

        private final String message;        // ǥ���� ���ڿ�

        static Menu MenuAt(int idx) {        // ������ idx��°�� ���Ÿ� ��ȯ
            for (Menu m : Menu.values())
                if (m.ordinal() == idx)
                    return m;
            return null;
        }

        Menu(String string) {                // ������(constructor)
            message = string;
        }

        String getMessage() {                // ǥ���� ���ڿ��� ��ȯ
            return message;
        }
    }

    //--- �޴� ���� ---//
    static Menu SelectMenu() {
        int key;
        do {
            for (Menu m : Menu.values())
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
            System.out.print(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());

        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;                                // �޴� 
        Data data;                                // �߰��� ������ ����
        Data ptr;                                 // �˻��� ������ ����
        Data temp = new Data();                   // �Է¿� ������
        BinTree<Integer, Data> tree = new BinTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()) {
             case ADD :              // ��� ����
                    data = new Data();
                     data.scanData("����", Data.NO | Data.NAME);
                     tree.add(data.keyCode(), data);
                     break;

             case REMOVE :           // ��� ����
                    temp.scanData("����", Data.NO);
                     tree.remove(temp.keyCode());
                     break;

             case SEARCH :           // ��� �˻�
                    temp.scanData("�˻�", Data.NO);
                     ptr = tree.search(temp.keyCode());
                     if (ptr != null)
                        System.out.println("�� ��ȣ�� �̸��� " + ptr + "�Դϴ�.");
                    else
                         System.out.println("�ش� �����Ͱ� �����ϴ�.");
                     break;

             case PRINT :            // ��ü ��带 Ű���� ������������ ǥ��
                    tree.print();
                    break;
						default:
							break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
