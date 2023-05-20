public class FTE extends EmployeeInfo {

    public double yearlySalary;
 
    public FTE(int employeeNumber, String firstName, String lastName, double deductRate, double yearlySalary) {
        super(employeeNumber, firstName, lastName, deductRate);
        this.yearlySalary = yearlySalary;
    } 
    
    public FTE(Object[] a){
        this((int)a[0], (String)a[1], (String)a[2], (double)a[3], (double)a[4]);
    }
}
