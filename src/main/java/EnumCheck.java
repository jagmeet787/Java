import javax.xml.transform.Source;

public class EnumCheck {
    public static void main(String[] args) {
        System.out.println(Sort.asc);
        System.out.println(Sort.valueOf("asc"));
        System.out.println(Sort.desc);
        System.out.println(Sort.valueOf("desc").name().equals("desc"));
    }
}

enum Sort {
    asc,
    desc;

    private Sort() {
    }
}