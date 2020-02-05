package Builder;

public class BuilderClient {
    public static void main(String[] args) {
        BuilderExample be = BuilderExample.builder().name("Jagmeet").age(25).build();
        System.out.println(be);
    }
}
