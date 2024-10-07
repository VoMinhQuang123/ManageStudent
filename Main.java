import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            while (true) {
                System.out.println("___________Menu___________");
                System.out.println("""
                        1. Show all students
                        2. Add New Student
                        3. Delete student
                        4. Student search
                        5. Sort students by score
                        0. Exit""");
                System.out.println("Enter your choice! ");
                String select = sc.nextLine();
                // Call the integer check function in the checkError class to see the input.
                if (Error.isInteger(select))
                {
                    int selected = Integer.parseInt(select);
                    switch (selected) {
                        case 0:
                            System.out.println("Exiting...");
                            return;
                        case 1:
                            Function.printStudent();
                            break;
                        case 2:
                            Function.addStudent();
                            System.out.println();
                            break;
                        case 3:
                            Function.removeStudent();
                            System.out.println();
                            break;
                        case 4:
                            searchStudent();
                            System.out.println();
                            break;
                        case 5:
                            sortStudentByScore();
                            System.out.println();
                            break;
                        default:
                            break;
                    }
                }
                else {
                    System.out.println("Invalid input. Please enter a valid number.");
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    private static void searchStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                        1. Search Student By ID
                        2. Search Student By Name
                        3. Search Student By Score""");
        System.out.println("Enter your choice! ");
        String select = sc.nextLine();
        if (Error.isInteger(select))
        {
            int selected = Integer.parseInt(select);
            switch (selected) {
                case 1:
                    Function.searchStudentId();
                    System.out.println();
                    break;
                case 2:
                    Function.searchStudentName();
                    System.out.println();
                    break;
                case 3:
                    Function.searchStudentScore();
                    break;
                default:
                    break;
            }
        }
    }
    private static void sortStudentByScore(){
        Scanner sc = new Scanner(System.in);
        System.out.println("""
                        1. Sort List Student By Rank Low To High
                        2. Sort List Student By Rank High To Low""");
        System.out.println("Enter your choice! ");
        String select = sc.nextLine();
        if (Error.isInteger(select))
        {
            int selected = Integer.parseInt(select);
            switch (selected) {
                case 1:
                    Function.scoreLowToHigh();
                    System.out.println();
                    break;
                case 2:
                    Function.scoreHighToLow();
                    System.out.println();
                    break;
                default:
                    break;
            }
        }
    }
}