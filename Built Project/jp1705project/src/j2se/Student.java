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
public class Student extends Person {
    public static final String ID = "20170011";
    public static final String SPECIALY = "CNTT";
    // students properties
    private String id;
    private String specialy;

    public Student() {
        this(Student.FIRSTNAME, Student.LASTNAME, Student.AGE, Student.ADDRESS,
             Student.ID, Student.SPECIALY);
    }

    public Student(String firstName, String lastName, byte age, Address address,
                   String id, String specialy) {
        // Khoi tao doi tuong cha (Person)
        super(firstName, lastName, age, address);

        // Xac dinh du lieu cho cac thuoc tinh cua con
        this.id = id;
        this.specialy = specialy;
    }

    //getter method
    public String getId() {
        return id;
    }

    public String getSpecialy() {
        return specialy;
    }

    //setter method
    public void setId(String id) {
        this.id = id;
    }

    public void setSpecialy(String specialy) {
        this.specialy = specialy;
    }

    //add method
    public String toString() {
        return super.toString() + " " + this.id + " " + this.specialy;
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
    }

    public static void main(String[] args) {
        // doi tuong dia chi
        Address addr = new Address("Ha Noi", "Cat Que", "ko biet");
        // tao doi tuong sinh vien
        Person s = new Student("Hue", "Nguyen Trong", (byte) 21, addr,
                                "0941360075", "KTPM");
        System.out.println(s);
    }
}
