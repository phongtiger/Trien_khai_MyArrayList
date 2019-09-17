public class Test {
    public static <E> void main(String[] args) {
        MyList list = new MyList(100);
        list.addE("Xin chao the gioi");
        list.addE("hello");
        list.addE("co ni chi wa");
        list.addE("ni hao");
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getElement(i));
        }
        System.out.println("\n");
        list.add(5,"chen thanh cong");
        for (int i = 0; i < list.getSize(); i++) {
            if (list.getElement(i) != null) {
                System.out.println(list.getElement(i));
            }
        }
        System.out.println("\n");
        E[] e = (E[]) new Object[list.getSize()];
        e = (E[]) list.clone();
        for (E e1: e
             ) {
            System.out.println(e1 +"\n");
        }
        System.out.println("\n");
        if (list.contains("hell")) {
            System.out.println("contain hello");
        } else {
            System.out.println("not contain hello");
        }
        list.clear();
        if (list.getSize() == 0) {
            System.out.println("khong con phan tu nao");
        }
        for (int i = 0; i < list.getSize(); i++) {
            System.out.println(list.getElement(i));
        }

    }
}
