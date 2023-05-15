public class PTE extends EmployeeInfo {
    
    public double hourlyWage;
    public double hoursPerWeek;
    public double weeksPerYear;
 
    public PTE(int employeeNumber, String firstName, String lastName, double hourlyWage, double hoursPerWeek, double weeksPerYear) {       
        super(employeeNumber, firstName, lastName);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        this.weeksPerYear = weeksPerYear;
    }
    
    public PTE(String[] a){
        super(Integer.valueOf(a[0]), a[1], a[2]);
        this.hourlyWage = Double.valueOf(a[3]);
        this.hoursPerWeek = Double.valueOf(a[4]);
        this.weeksPerYear = Double.valueOf(a[5]);
    }

    
}
