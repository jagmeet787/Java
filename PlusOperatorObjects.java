class PlusOperatorObjects {
	public static void main(String[] args) {
		Integer a = 5;
		Integer b = 8;
		Integer c = a + b;
    
		System.out.println(a + b);
		System.out.println(c);
		
    String sa = "Hello ";
		String sb = "Plus Operator!";
		String sc = sa + sb;
		
    System.out.println(sa + sb);
		System.out.println(sc);
	}
}

/* Decompiled Version
import java.io.PrintStream;

class PlusOperatorObjects { 
    PlusOperatorObjects() {} 
    
    public static void main(String[] paramArrayOfString) {
      Integer localInteger1 = Integer.valueOf(5);
      Integer localInteger2 = Integer.valueOf(8);
      Integer localInteger3 = Integer.valueOf(localInteger1.intValue() + localInteger2.intValue());
      
      System.out.println(localInteger1.intValue() + localInteger2.intValue());
      System.out.println(localInteger3);
      
      String str1 = "Hello ";
      String str2 = "Plus Operator!";
      // it uses stringbuilder? new StringBuilder().append(str1).append(str2).toString();
      String str3 = str1 + str2;
      
      System.out.println(str1 + str2);
      System.out.println(str3);
  }
}
*/
