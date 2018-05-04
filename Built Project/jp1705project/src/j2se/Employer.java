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
public class Employer extends Person {

    public static final int NETWAGE = 0;
    public static final String POSITION = "Khong co gi het";

    private int netwage;
    private String position;
    public Employer(){
        this(Person.FIRSTNAME,Person.LASTNAME,Person.AGE,Person.ADDRESS,Employer.NETWAGE,Employer.POSITION);
    }

    public Employer(String firstName, String lastName, byte age, Address address, int netwage, String position) {
        super(firstName, lastName, age, address);
        this.netwage = netwage;
        this.position = position;
    }

    public String toString(){
        return super.toString()+ " " + this.netwage + " " + this.position;
    }


    public int getnetwage() {
        return netwage;
    }

    public String getPosition() {
        return position;
    }

    public void setnetwage(int netwage) {
        this.netwage = netwage;
    }

    public void setPosition(String position) {
        this.position = position;
    }



    public static void main(String[] args) {
        Address addr = new Address("Ha Noi","Cat Que","Ko co");
        Employer em = new Employer("Hue","Nguyen Trong",(byte)21,addr,2000000000,"Boss");
        System.out.println(em);
    }

}
