public class Student extends Person {
    private int year;
    private double fee;

    public Student(String name, String addr, int year){
        super(name, addr);
        this.year = year;
    }

    public int getYear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    @Override
    public String toString(){
        return String.format("Name: %s | Address: %s | Year: %d", this.getName(), this.getAddress(), this.year);
    }
}