public class Staff extends Person {
    private int yearsOfService;
    private double pay;

    public Staff(String name, String addr, int yearsOfService){
        super(name, addr);
        this.yearsOfService = yearsOfService;
    }

    public int getYearsOfService(){
        return this.yearsOfService;
    }

    public void setYearsOfService(int yearsOfService){
        this.yearsOfService = yearsOfService;
    }

    @Override
    public String toString(){
        return String.format("Name: %s | Address: %s | Years of Service: %d", this.getName(), this.getAddress(), this.yearsOfService);
    }
}
