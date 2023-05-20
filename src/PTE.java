public class PTE extends EmployeeInfo {
    
    public double hourlyWage;
    public double hoursPerWeek;
    public double weeksPerYear;
 
    public PTE(int employeeNumber, String firstName, String lastName, double deductRate, double hourlyWage, double hoursPerWeek, double weeksPerYear) {       
        super(employeeNumber, firstName, lastName, deductRate);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        this.weeksPerYear = weeksPerYear;
    }
    
    public PTE(Object[] a){
        this((int)a[0], (String)a[1], (String)a[2], (double)a[3], (double)a[4], (double)a[5], (double)a[6]);
    }
}
