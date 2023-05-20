public class EmployeeInfo {
    
    public int employeeNumber;
    public String firstName;
    public String lastName;
    public Double deductRate;

    public EmployeeInfo(int employeeNumber, String firstName, String lastName, double deductRate) {
        this.employeeNumber = employeeNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deductRate = deductRate;
    }

}