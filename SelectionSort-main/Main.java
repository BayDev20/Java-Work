import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(); // Create Instances
        students.add(new Student(990, "John", "143 Drift st"));
        students.add(new Student(991, "Cody", "8754 Car st"));
        students.add(new Student(992, "Leia", "1212 Flame st"));
        students.add(new Student(993, "Darcy", "90 waterford st"));
        students.add(new Student(994, "Nala", "834 Cheap st"));
        students.add(new Student(995, "Timber", "9872 Java st"));
        students.add(new Student(996, "Paco", "09 Python st"));
        students.add(new Student(997, "Josh", "234 Tim st"));
        students.add(new Student(998, "Tina", "094 Whistle st"));
        students.add(new Student(999, "Tiffny", "043 Water st"));
        // Name sort
        SelectionSort.selectionSort(students, new CompareName());
        System.out.println("By name:");
        students.forEach(System.out::println);
        System.out.println();

        // Roll number sort
        SelectionSort.selectionSort(students, new CompareRoll());
        System.out.println("By Roll:");
        students.forEach(System.out::println);
    }
}