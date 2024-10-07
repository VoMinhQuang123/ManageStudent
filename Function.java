import java.util.Scanner;

public class Function {

    static final ListStudent listStudent = new ListStudent();
    static Scanner sc = new Scanner(System.in);

    // Add new Student
    public static void addStudent(){

        System.out.print("Enter the number of students you want to add:");
        String numberOfStudents = sc.nextLine(); // Enter input as string to check input
        if (Error.isInteger(numberOfStudents))
        {
            int numberOfStudentsChecked = Integer.parseInt(numberOfStudents); // Convert String to Int
            for (int i = 0; i < numberOfStudentsChecked; i++) {
                // Enter ID in this step
                String id;
                while (true){
                    System.out.print("Enter ID Student: "); id = sc.nextLine();
                    if(id.isEmpty()){
                        System.out.println("Please do not leave ID blank");
                    }
                    else if (listStudent.checkID(id)) {
                        System.out.println("ID already exists");
                    }
                    else {break;}}

                // Enter Name in this step
                String name;
                while (true) {
                    System.out.print("Enter Student's Name: ");
                    name = sc.nextLine();
                    if(name.isEmpty()){
                        System.out.println("Please do not leave Name blank");
                    }
                    else if (!Error.isValidName(name)) {
                        System.out.println("Please enter the correct name format as letters!");
                    } else {break;}}
                // Enter Point in this step
                float score;
                while (true){
                    System.out.print("Enter Point's Student: ");
                    String pointInput = sc.nextLine();
                    try {
                        score = Float.parseFloat(pointInput);
                        if(score>=0 && score <=10){
                            break;
                        }
                        else {System.out.println("Invalid input. Please enter score on a 10-score scale!");}

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid score.");
                    }
                }
                // When entering student's input score, compare and return rank.
                String rank = null;
                if(score >= 0 || score < 5){
                    rank = "Fail";
                }
                else if (score >= 5 || score < 6.5){
                    rank = "Medium";
                }
                else if(score >= 6.5 || score < 7.5){
                    rank = "Good";
                }
                else if (score >= 7.5 || score < 9){
                    rank = "Very Good";
                }
                else if(score >= 9 || score <= 10){
                    rank = "Excellent";
                }

                Student student = new Student(id, name,score,rank);
                listStudent.addNewStudent(student);
                System.out.println("Add Successfully!");
                sc.nextLine();
            }
        }
    }
    public static void printStudent(){
        System.out.println("Student list:");
        listStudent.printListStudent();
    }
    public static void removeStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID Student: "); String iD = sc.nextLine();
        Student student = new Student(iD);
        if (listStudent.deleteStudent(student)) {
            System.out.println("Remove Successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }
    public static void searchStudentName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name's Student: "); String name = sc.nextLine();
        if (!listStudent.searchStudentByName(name)) {
            System.out.println("Not found");
        }
    }
    public static void searchStudentId(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID Student: "); String id = sc.nextLine();
        if (!listStudent.searchStudentByID(id)) {
            System.out.println("Not found");
        }
    }
    public static void searchStudentScore(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Score's Student: "); Float point = sc.nextFloat();
        //if (!listStudent.searchStudentByPoint(point)) {
            System.out.println("Not found");
        //}
    }
    public static void scoreHighToLow(){
        listStudent.sortStudentsByScoreHighToLow();
    }
    public static void scoreLowToHigh(){
        listStudent.sortStudentsByScoreLowToHigh();
    }
}