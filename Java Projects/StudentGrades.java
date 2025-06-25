import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] names = new String[5];
        int[] marks = new int[5];

        for(int i=0;i<5;i++){
            System.out.println("Enter name of student"+ (i+1) + ":");
            names[i] = sc.next();
            System.out.print("Enter marks: ");
            marks[i]= sc.nextInt();
        }

        System.out.println("\nStudent Grades:");
        for(int i=0;i<5;i++){
            String grade;
            if(marks[i]>=90) grade = "A";
            else if( marks[i]>=75) grade = "B";
            else if(marks[i]>=60) grade = "C";
            else if(marks[i]>=40) grade ="D";
            else grade = "F";

            System.out.println(names[i] + "-Marks:" +marks[i]+ ", Grade:" +grade);
        }
    }
}
