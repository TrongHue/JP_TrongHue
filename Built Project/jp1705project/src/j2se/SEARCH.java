package j2se;
import java.util.*;
public interface SEARCH {
    public Person  searchPerson(String name);
    public Person  searchPerson(Address addr);
    public Person  searchPerson(byte max_age);
}
