package j2se;

public class TestManager {
    public TestManager() {
    }

    public static void main(String[] args) {
        Address addr = new Address("Ha Noi", "Cat Que", "ko biet");
       // tao doi tuong sinh vien
       Person s = new Student("Hue", "Nguyen Trong", (byte) 21, addr,
                               "0941360075", "KTPM");
       Employer e = new Employer("Hue","Nguyen Trong",(byte)21,addr,2000000000,"Boss");

       Manager sm = new StudentManager();
       Manager em = new EmployeeManager();

       System.out.println(sm.getInfoPerson(s));
       System.out.println(em.getInfoPerson(e));
    }
}
