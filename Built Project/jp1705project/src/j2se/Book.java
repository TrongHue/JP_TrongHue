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
public class Book {
    public static final short BOOK_ID = (short)1;
   public static final String BOOK_TITLE = "No book title";
   public static final String BOOK_PUBLISHER ="No book publisher";
   public static final Person BOOK_AUTHOR = new Person();
   public static short BOOK_PAGES = (short)1;
   public static final String BOOK_URL_LINK = "No book link";

    // Object's properties
    private short book_id;
    private String book_title;
    private String book_publisher;
    private Person book_author;
    private short book_pages;
    private String book_url_link;


    public Book() {
        this(Book.BOOK_ID, Book.BOOK_TITLE, Book.BOOK_TITLE, Book.BOOK_AUTHOR,Book.BOOK_PAGES, Book.BOOK_URL_LINK);
    }

    public Book(short  book_id, String book_title, String book_publisher, Person book_author,short book_pages, String book_url_link){
        this.book_id = book_id;
        this.book_title = book_title;
        this.book_publisher = book_publisher;
        this.book_author = new Person(book_author);
        this.book_pages = (short)book_pages;
        this.book_url_link = book_url_link;
    }

    public String getBook_title(){
        return this.book_title;
    }
    public short getBook_id(){
       return this.book_id;
   }
   public String getBook_publisher(){
       return this.book_publisher;
   }
   public Person getBook_author(){
       return this.book_author;
   }
   public short getBook_pages(){
       return this.book_pages;
   }
   public String getBook_url_link(){
       return this.book_url_link;
   }
// setter
   public Book setBook_title(String book_title){
        this.book_title = book_title;
        return this;
    }
    public Book setBook_id(short book_id){
       this.book_id = book_id;
       return this;
   }
   public Book setBook_publisher(String book_publisher){
      this.book_publisher = book_publisher;
      return this;
   }
   public Book setBook_author(Person p){
       this.book_author = new Person(p);
       return this;
   }
   public Book setBook_pages(short book_pages){
       this.book_pages = book_pages;
       return this;
   }
   public Book setBook_url_link(String book_url_link){
       this.book_url_link = book_url_link;
       return this;
   }

 public String toString(){
     return book_id +" "+ book_title +" "+ book_publisher +" "+ book_author.toString() +" "+ book_pages +" "+ book_url_link ;
 }

 protected void finalize() throws Throwable{
      super.finalize();
  }



    public static void main(String[] args) {
        Address adr = new Address("Ha Noi" ,"Cat Que","Khong co");
        Person p = new Person("Nguyen Trong" ,"Hue",(byte)21,adr);
        Book b = new Book((short)1,"Book title","Nguyen Trong Hue",p,(short)1,"www.sachhay.com");
        System.out.println(b.toString());
    }
}
