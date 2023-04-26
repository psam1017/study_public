package ch10_hash;

// ���� �ּҹ��� ���� �ؽ��� ��� ��

import java.util.Scanner;

public class OpenHashTester {

    static Scanner stdIn = new Scanner(System.in);

    //--- ������(ȸ����ȣ���̸�) ---//
    static class Data {
        static final int NO   = 1;        // ��ȣ�� �о� ���ϱ��?
        static final int NAME = 2;        // �̸��� �о� ���ϱ��?

        private Integer no;               // ȸ����ȣ(Ű��)
        private String  name;             // �̸�

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
                System.out.print("��ȣ: ");
                no = stdIn.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("�̸�: ");
                name = stdIn.next();
            }
        }
    }

    //--- �޴� ������ ---//
    enum Menu {
        ADD(      "�߰�"),
        REMOVE(   "����"),
        SEARCH(   "�˻�"),
        DUMP(     "ǥ��"),
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
        Data temp = new Data();                   // �о� ���� ������

        OpenHash<Integer, Data> hash = new OpenHash<Integer, Data>(13);
        do {
            switch (menu = SelectMenu()) {
             case ADD :                           // �߰�
                data = new Data();
                data.scanData("�߰�", Data.NO | Data.NAME);
                 int k = hash.add(data.keyCode(), data);
                 switch (k) {
                  case 1: System.out.println("�� Ű���� �̹� ��ϵǾ� �ֽ��ϴ�.");
                              break;
                  case 2: System.out.println("�ؽ� ���̺��� ���� á���ϴ�.");
                              break; 
                 }
                 break;

             case REMOVE :                               // ����
                 temp.scanData("����", Data.NO);
                 hash.remove(temp.keyCode());
                 break;

             case SEARCH :                               // �˻�
                temp.scanData("�˻�", Data.NO);
                 Data t = hash.search(temp.keyCode());
                 if (t != null)
                     System.out.println("�� Ű�� ���� �����ʹ� " + t + "�Դϴ�.");
                else
                     System.out.println("�ش� �����Ͱ� �����ϴ�.");
                 break;

             case DUMP :                                 // ǥ��
                 hash.dump();
                 break;
						default:
							break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
