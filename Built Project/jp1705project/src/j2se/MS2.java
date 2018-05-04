package j2se;

import java.util.*;

public interface MS2 extends EXE,SEARCH,STATISTIC{
    public ArrayList getPerson(String name);

    public ArrayList getPerson(Address addr);

    public int getCountPerson(Address addr);

    public int getCountPerson(ArrayList<Person> list);

    public int getCountPerson(Person similar);
}
