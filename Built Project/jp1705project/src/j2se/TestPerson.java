package j2se;

/**
 * <p>Title: jp1705</p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2017</p>
 *
 * <p>Company: </p>
 *
 * @author Nguyen Trong Hue
 * @version 1.0
 */
public class TestPerson {
    public TestPerson() {
    }

    public static void main(String[] args) {
        // doi tuong dia chi
        Address addr = new Address("Ha Noi", "Cat Que", "ko biet");
        // tao doi tuong sinh vien
        Person s = new Student("Hue", "Nguyen Trong", (byte) 21, addr,
                               "0941360075", "KTPM"),
                em = new Employer("Huan", "Nguyen Trong", (byte) 21, addr,
                                  2000000000, "Programmer"); ;

        System.out.println(s);
        System.out.println(em);

    }
}
