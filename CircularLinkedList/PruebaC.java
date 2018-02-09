public class PruebaC{

	public static void main(String[] args) {
		CLinkedList<String> a = new CLinkedList<String>();

		a.addFirst("Hola");
		a.add(1,"Adios");

		System.out.println(a.toString());
		Iterador<String> b = a.iterador();
		while(b.hasNext()){
			System.out.println(b.next());
		}
	}

}
