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
        this(Integer.parseInt(a[0]), a[1], a[2], Double.parseDouble(a[3]), Double.parseDouble(a[4]), Double.parseDouble(a[5]));
    }

    
}
