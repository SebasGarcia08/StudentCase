import java.util.Scanner;
import model.*;

public class Main {
  static Scanner sc_str, sc_int;
  private static Student student;

  public Main() {
    student = new Student();
    sc_str = new Scanner(System.in);
    sc_int = new Scanner(System.in);
  }

  public static void main(String[] args) {
      Main program = new Main();
      program.enrollCourse();
      program.showStudents();
  }

public void enrollStudent(){
    System.out.println("\nIngrese los datos del estudiante a registrar: \n");
    
    System.out.print("Código: ");
    String id = sc_str.nextLine();
    student.setId(id);

    System.out.print("Nombre del estudiante: ");
    String name = sc_str.nextLine();
    student.setName(name);

    System.out.print("Apellidos: ");
    String last_name = sc_str.nextLine();
    student.setLastName(last_name);

    System.out.print("Estado: [a: Activo / r: Retirado / g: Graduado]: ");
    char state = sc_str.nextLine().charAt(0);
    student.setState(state);

    System.out.print("El estudiante se encuentra en prueba académica [y/n]: ");
    char y_n = sc_str.nextLine().charAt(0); 
    boolean academicTest = (y_n == 'y') ? true : false;
    student.setAcademicTest(academicTest);
    System.out.println("\n Student with name " + student.getName() + " and id " + student.getId() + " has been enrolled.");
}

  public void enrollCourse(){
    System.out.print("\nType the number of courses you want to unroll for the student: ");
    int num_courses = sc_int.nextInt();
    if(num_courses<5)
      for(int i = 0; i < num_courses; i++){
            System.out.println("\n[-------- COURSE #" + (i+1) + "--------]");
            
            System.out.print("Name: ");
            String course_name = sc_str.nextLine();
            
            System.out.print("Course id: ");
            String course_id = sc_str.nextLine();
            
            System.out.print("Number of credits: ");
            int num_credits = sc_int.nextInt();
            
            System.out.print("Does the course is validable? [y/n]: ");
            char y_n = sc_str.nextLine().charAt(0);
            boolean validable = (y_n == 'y') ? true : false;
            
            System.out.print("Grade: ");
            double grade = sc_int.nextDouble();
            student.addCourses(validable, course_id, course_name, num_credits, grade);
      }
    else 
      System.out.println("You CANNOT enroll more than 5 courses.");
  }

  public void showStudents(){

    System.out.println("\nEnrolled courses: \n");
    // System.out.println(student.getCourses());

    for(Course course : student.getCourses()){
        try {
            System.out.println(course.getId());
            System.out.println(course.getName());
            System.out.println(course.getGrade());
            System.out.println(course.getNumCredits());
            System.out.println(course.getValidable());
            System.out.println();    
        } catch(Exception e) {
           continue;
        }
    }
  }
}
