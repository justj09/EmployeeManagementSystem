public class PTE extends EmployeeInfo {
    
    public double hourlyWage;
    public int hoursPerWeek;
    public int weeksPerYear;
 
    public PTE(int employeeNumber, String firstName, String lastName, double deductRate, double hourlyWage, int hoursPerWeek, int weeksPerYear) {       
        super(employeeNumber, firstName, lastName, deductRate);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
        this.weeksPerYear = weeksPerYear;
    }
    
    public PTE(Object[] a){
        this((int)a[0], (String)a[1], (String)a[2], (double)a[3], (double)a[4], (int)a[5], (int)a[6]);
    }

    public double calcNetAnnualIncome(){
        return Math.round(hourlyWage * hoursPerWeek * weeksPerYear * (1 - super.deductRate) * 100)/100.0;
    }
}
