public class FTE extends EmployeeInfo {

    public double yearlySalary;
 
    public FTE(int employeeNumber, String firstName, String lastName, double yearlySalary) {
        super(employeeNumber, firstName, lastName);
        this.yearlySalary = yearlySalary;
    } 
    
    public FTE(String[] a){
        super(Integer.parseInt(a[0]), a[1], a[2]);
        this.yearlySalary = Double.parseDouble(a[3]);
    }
}
