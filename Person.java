public abstract class Person {
    private String name;
    private String address;

    public Person(String name, String addr){
        this.name = name;
        this.address = addr;
    }

    public String toString(){
        return String.format("Name: %s | Address: %s", this.name, this.address);
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setAddress(String newAddr){
        this.address = newAddr;
    }
}
