public class EmployeeInfo {
    
    public int employeeNumber;
    public String firstName;
    public String lastName;

    public EmployeeInfo(){
        this(-1, "First", "Last");
    }

    public EmployeeInfo(int employeeNumber, String firstName, String lastName) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
}