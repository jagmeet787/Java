class Test {
	public static void main(String[] args) {

System.out.println("==================================================================");
// java generics and type checking at compile and run time
		java.util.List list = new java.util.ArrayList();
		java.util.List<Object> listO = new java.util.ArrayList<Object>();
		list.add("Ramu");
		list.add(4);
		listO.add("Ramu");
		listO.add(4);
		System.out.println(list);
		System.out.println(listO);

System.out.println("==================================================================");
// final keyword with variables
		final int FINT = 5;
		// error: cannot assign a value to final variable FINT
		// FINT = 8;
		System.out.println("FINT: " + FINT);
		final int b;
		b = 10;
		// error: variable b might already have been assigned
		// b = 8;
		System.out.println("b : " + b);

// Arrays are objects so arr is refrence to object of type array
System.out.println("==================================================================");
		Integer[] arr = {1,2,3};
		System.out.println("arr.length : " + arr.length);
		arr = new Integer[5];
		System.out.println("arr.length : " + arr.length);
		System.out.println("== Array of Objects ==");
		for(Integer e : arr) System.out.print(e + ", ");
		System.out.println();

System.out.println("==================================================================");
		final int[] arr1 = {1,2,3};
		System.out.println("arr1.length : " + arr1.length);
		 // error: cannot assign a value to final variable arr1
		// intialize new object of type array of size 5 with type int
		// all are 0 intially
		// arr1 = new int[5]; 
		System.out.println("arr1.length : " + arr1.length);
		System.out.println("== Array of primitives ==");
		for(int e : arr1) System.out.print(e + ", ");
		System.out.println();
	}
}