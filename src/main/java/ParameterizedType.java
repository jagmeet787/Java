import sun.net.www.content.text.Generic;

public class ParameterizedType {
    public static void main(String[] args) {
        GenericClass<Integer> genericClazz = new GenericClass<>();
        System.out.println(genericClazz.getClass());
    }
}

class GenericClass<T> {

}