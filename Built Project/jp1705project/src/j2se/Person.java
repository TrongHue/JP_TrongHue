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
public class Person {

    //Constants
    public static final String FIRSTNAME = "No first name";
    public static final String LASTNAME = "No last name";
    public static final byte AGE =21;
    public static final Address ADDRESS = new Address();

    // Class variables
    private static int countPerson = 0;

    // Object properties

    private String firstName;
    private String lastName;
    private byte age;
    private Address address;

    //Constructor menthods
    public Person() {
        // type one
        /*firstName = "No first name";
        lastName = "No last name";
        age = 0;*/
        this(Person.FIRSTNAME,Person.LASTNAME,Person.AGE,Person.ADDRESS);
    }

    public Person(byte age) {
        //type two
        /*firstName = "No first name";
        lastName = "No last name";
        this.age = age;*/
     this(Person.FIRSTNAME,Person.LASTNAME,(byte)age,Person.ADDRESS);
    }

    public Person(String firstName, String lastName, byte age,Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.address = new Address(address);
        //tang bien dem doi tuong countPerson
        Person.countPerson++;
    }

    public Person(Person p){
        this(p.getFirstName(),p.getLastName(),(byte)p.getAge(),p.getAddress());
    }

    //other methods
    public String toString() {
        return lastName + " " + firstName + " " + age + " ";
    }

    public static int getCountPerson(){
        return Person.countPerson;
    }

    //getter methods

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public byte getAge(){
        return this.age;
    }

    public Address getAddress(){
            return this.address;
    }

    //setter methods

    public Person setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public Person setLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public Person setAge(byte age){
        this.age = age;
        return this;
    }

    public Person setAddress(Address address){
        this.address = new Address(address);
        return this;
    }

    public Person setAddress(String cityName, String dicstrictName, String streetName){
        this.address = new Address(cityName,dicstrictName,streetName);
        return this;
    }


    protected void finalize() throws Throwable{
        //Giam doi tuong
        Person.countPerson-- ;
        super.finalize();
    }

    public static void main(String[] args) {
        // Khai bao cac doi tuong
        Person p;
        Person p1 = new Person();
        Person p2 = new Person((byte) 20);
        Address addr = new Address("Ha noi","Cat Que","Khong co");
        Person p3 = new Person("Hue", "Nguyen Trong", (byte) 21,addr);
        System.out.println(p3);
    }
}
