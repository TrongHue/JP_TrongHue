package j2se;

public class StudentManager extends Manager {
    public StudentManager() {
    }

    /**
     * getInfoPerson
     *
     * @param p Person
     * @return String
     * @todo Implement this j2se.Manager method
     */
    public String getInfoPerson(Person p) {
        return "Student " + p.toString();
    }

    public static void main(String[] args) {
        StudentManager studentmanager = new StudentManager();
    }
}
