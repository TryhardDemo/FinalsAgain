/*
 * Need to add for this stupid shit:
 * 2.Unique number for subjects since professors might say it's not accurate ??
 * 3.Dashboard
 * 
 * Don't forget
 * 1.KISS (Keep it simple, stupid)
 * 2.SOLID
 * 3.DFRY (Don't Fucking Repeat Yourself )
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// EXAMPLE CHANGE

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            List<NewStudent> students = new ArrayList<>();

            while(true) {
                System.out.println("Enrollment System");
                System.out.print("Enter user type (1 for Old Student or 2 for New Student and Register): ");
                int userType = input.nextInt();
                input.nextLine(); // reason to hate this god forsaken language
                
                switch (userType) {
                    case 1:
                        OldStudent.displayStudents(students);
                        break;
                    case 2:
                        students.add(createStudent(input));
                        break;
                    case 0:
                        System.out.println("Exiting the program");
                        return;
                    default:
                        System.out.println("Invalid user type.");
                }
            }
        }
        //too lazy on doing specific error types
        catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    private static NewStudent createStudent(Scanner input) {
        System.out.print("Enter student name: ");
        String studentName = input.nextLine();
        
        System.out.print("Enter student age: ");
        int studentAge = input.nextInt();
        input.nextLine();

        List<Subjects> selectedSubjects = selectSubjects(input);
        NewStudent student = new NewStudent(studentName, studentAge, selectedSubjects);
        System.out.println("Student created: " + student.getName() + ", Age: " + student.getAge() + ", ID: " + student.getId() + ", Subjects: " + student.getSelectedSubjects());
        return student;
    }
    public static List<Subjects> selectSubjects(Scanner input) {
        List<Subjects> selectedSubjects = new ArrayList<>();
        Subjects[] allSubjects = Subjects.values();

        while (selectedSubjects.size() < 3) {
            System.out.println("Available Subjects:");
            for (int i = 0; i < allSubjects.length; i++) {
                Subjects subj = allSubjects[i];
                //so this is how you use print format
                    System.out.printf("%d. %s (Slots Left: %d)%n", i + 1, subj.name(), subj.getSlotsLeft());
            }
            
            System.out.print("Choose a subject (1-" + allSubjects.length + "): ");
            int choice = input.nextInt();

            if (choice < 1 || choice > allSubjects.length) {
                System.out.println("Invalid choice.");
                continue;
            }
            Subjects selected = allSubjects[choice - 1];

            if (selectedSubjects.contains(selected)) {
                System.out.println("Already selected.");
            } else if (selected.enroll()) {
                selectedSubjects.add(selected);
                System.out.println(selected.name() + " enrolled.");
            } else {
                System.out.println("No slots left for " + selected.name() + ".");
            }
        }
        return selectedSubjects;
    }
}
