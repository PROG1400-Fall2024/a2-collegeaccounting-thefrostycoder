public class Student extends Person {
    private int year;
    private double fee;

    public Student(String name, String addr, int year){
        super(name, addr);
        this.year = year;
        this.fee = calcFee(year);
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
        //Update pay accordingly
        setFee(year);
    }

    private void setFee(int year){
        this.fee = calcFee(year);
    }

    public double calcFee(int year){
        return (year - 1) * 100 + 3000;
    }

    @Override
    public String toString(){
        return String.format("Name: %s | Address: %s | Year: %d | Fee: $%.2f", this.getName(), this.getAddress(), this.year, this.fee);
    }
}