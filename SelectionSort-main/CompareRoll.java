import java.util.Comparator;

public class CompareRoll implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getRollNu(), s2.getRollNu());
    }
}