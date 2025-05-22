import java.util.List;

public class NewStudent implements User {
    private final String name;
    private final int  age;
    public static long IDcounter = 1_000_000_000L;
    private final long studentId;
    private final List<Subjects> selectedSubjects;

    public NewStudent(String name, int age, List<Subjects> selectedSubjects) {
        this.name = name;
        this.age = age;
        this.studentId = IDcounter++;
        this.selectedSubjects = selectedSubjects;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public long getId() {
        return studentId;
    }

    public List<Subjects> getSelectedSubjects() {
        return selectedSubjects;
    }

    public String toString() {
        return "Student Name: " + name + ", Age: " + age + ", ID: " + studentId + ", Subjects: " + selectedSubjects;
    }
    
}