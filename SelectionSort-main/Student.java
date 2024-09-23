public class Student {
    private int rollNu;
    private String name;
    private String addy;

// Student demographic
    public Student(int rollNu, String name, String addy) {
        this.rollNu = rollNu;
        this.name = name;
        this.addy = addy;
    }

// Roll Number
    public int getRollNu() {
        return rollNu;
    }

// Name
    public String getName() {
        return name;
    }
// Address
    public String getAddy() {
        return addy;
    }

    @Override // Sort by name print // starts with name
    public String toString() {
        return "Student: " + name + ", Roll #: " + rollNu + ", Address: " + addy;
    }

    // Sort by Nu print // starts with roll no // doesnt work needs fixed
    public String toStringByRollNu() {
        return "Roll #: " + rollNu + ", Student: " + name + ", Address: " + addy;
    }
}