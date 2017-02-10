public class Implementacion{

    public static void main(String[] args) {
        SLinkedList<Libros> ll = new SLinkedList<Libros>();

        Libros l1 = new Libros(15,"Let us C","Yashwant Kanetkar","BPB",1);
        Libros l2 = new Libros(2,"Data Communications & Networking","Forouzan","Mc Graw Hill",4);
        Libros l3 = new Libros(5,"Operating System","Galvin","Wiley",8);

        ll.add(0,l1);
        ll.add(1,l2);
        ll.add(2,l3);

        System.out.println("Original contents of ll: " + "\n" + ll + "\n");
        ll.remove(1);
        System.out.println("Contents of ll after deletion: " + "\n" + ll + "\n");
        ll.addFirst(l2);
        System.out.println("Contents of ll after addFirst: " + "\n" + ll);
    }
}
