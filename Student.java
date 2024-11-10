public class Student extends Person {
    private int year;
    private double fee;

    public Student(String name, String addr, int year){
        super(name, addr);
        this.year = year;
        this.fee = (year - 1) * 100 + 3000;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("Name: %s | Address: %s | Year: %d | Fee: $%.2f", this.getName(), this.getAddress(), this.year, this.fee);
    }
}