package j2se;

public class EmployeeManager extends Manager {
    public EmployeeManager() {
    }

    /**
     * getInfoPerson
     *
     * @param p Person
     * @return String
     * @todo Implement this j2se.Manager method
     */
    public String getInfoPerson(Person p) {
        return "Employee " + p.toString();
    }

    public static void main(String[] args) {
        EmployeeManager employeemanager = new EmployeeManager();
    }
}
