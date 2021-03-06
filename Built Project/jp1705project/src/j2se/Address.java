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
public class Address {
    //Constances -1
    public static final String CITYNAME = "No city name";
    public static final String DISTRICTNAME = "No district name";
    public static final String STREETNAME = "No street name";

    //Object properties 0
    private String cityName;
    private String districtName;
    private String streetName;


    //Constructor method -2
    public Address() {
        this(Address.CITYNAME, Address.DISTRICTNAME, Address.STREETNAME);
    }

    public Address(String cityName, String districtName, String streetName) {
        this.cityName = cityName;
        this.districtName = districtName;
        this.streetName = streetName;
    }

    public Address(Address addr){
        //type three
        this(addr.getCityName(),addr.getDistrictName(),addr.getStreetName());
    }

    //Getter methods -3
    public String getCityName() {
        return this.cityName;
    }

    public String getDistrictName() {
        return this.districtName;
    }

    public String getStreetName() {
        return this.streetName;
    }


    //Setter methods -4
    public Address setCityName(String cityName) {
        this.cityName = cityName;
        return this;
    }

    public Address setDistrictName(String districtName) {
        this.districtName = districtName;
        return this;
    }

    public Address setStreetName(String streetName) {
        this.streetName = streetName;
        return this;
    }


    //Other method - 5
    public String toString() {
        return cityName + " " + districtName + " " + streetName;
    }

    protected void finalize() throws Throwable {
        //Giam doi tuong
        super.finalize();
    }

    public static void main(String[] args) {
        Address ad1 = new Address();
        ad1.setCityName("Ha noi").setDistrictName("Cat Que").setStreetName(
                "Khong co");
        Address ad2 = new Address();
        Address ad3 = new Address("Ha Noi", "Cat Que", "Khong co");
        System.out.println(ad1);
        System.out.println(ad2);
        System.out.println(ad3);
    }
}
