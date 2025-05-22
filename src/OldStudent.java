import java.util.List;

//This should not have taken me 4 hours, thanks java I despise you even more
public class OldStudent {
    public static void displayStudents(List<NewStudent> students) {
        System.out.println("List of Students:");
        for (int i = 0; i < students.size(); i++){
            NewStudent student = students.get(i);
            System.out.println(student);
        }
    }
}