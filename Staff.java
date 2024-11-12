public class Staff extends Person {
    private int yearsOfService;
    private double salary;

    public Staff(String name, String addr, int yearsOfService){
        super(name, addr);
        this.yearsOfService = yearsOfService;
        this.salary = calcSalary(yearsOfService);
    }

    public int getYearsOfService(){
        return this.yearsOfService;
    }

    public void setYearsOfService(int yearsOfService){
        this.yearsOfService = yearsOfService;
        setSalary(yearsOfService);
    }

    private void setSalary(int year){
        this.salary = calcSalary(yearsOfService);
    }

    public double getSalary(){
        return this.salary;
    }

    private double calcSalary(int years){
        return (years * 500) + 50000;
    }

    @Override
    public String toString(){
        return String.format("Name: %s | Address: %s | Years of Service: %d | Salary: $%.2f", this.getName(), this.getAddress(), this.yearsOfService, this.salary);
    }
}
