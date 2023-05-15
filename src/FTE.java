public class FTE extends EmployeeInfo {

    public double yearlySalary;
 
    public FTE(int employeeNumber, String firstName, String lastName, double yearlySalary) {
        super(employeeNumber, firstName, lastName);
        this.yearlySalary = yearlySalary;
    } 
    
    public FTE(String[] a){
        super(Integer.valueOf(a[0]), a[1], a[2]);
        this.yearlySalary = Double.valueOf(a[3]);
    }
}
