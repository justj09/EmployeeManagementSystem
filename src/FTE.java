public class FTE extends EmployeeInfo {

    public double yearlySalary;
 
    public FTE(int employeeNumber, String firstName, String lastName, double yearlySalary) {
        super(employeeNumber, firstName, lastName);
        this.yearlySalary = yearlySalary;
    } 
    
    public FTE(String[] a){
        this(Integer.parseInt(a[0]), a[1], a[2], Double.parseDouble(a[3]));
    }
}
