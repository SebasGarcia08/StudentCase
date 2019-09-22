package ui;

import java.util.Scanner;
import model.*;
import static java.lang.System.out;

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
      program.enrollStudent();
      if(student.getState() == student.ACTIVE){
          program.enrollCourse();
          if(student.getCourses()[0] != null){
            program.showLogs();
          }
        }
      // out.println("Do you want to unenroll these students");
  }

public void enrollStudent(){
    out.println("\nIngrese los datos del estudiante a registrar: \n");
    
    out.print("Código: ");
    String id = sc_str.nextLine();
    student.setId(id);

    out.print("Nombre del estudiante: ");
    String name = sc_str.nextLine();
    student.setName(name);

    out.print("Apellidos: ");
    String last_name = sc_str.nextLine();
    student.setLastName(last_name);

    out.print("Estado: [a: Activo / r: Retirado / g: Graduado]: ");
    char state = sc_str.nextLine().charAt(0);
    student.setState(state);

    out.println("\nStudent '" + student.getName() + " " + student.getLastName() + "' with id '" + student.getId() + "' succesfully enrolled.");
}

  public void enrollCourse(){
    out.print("\nType the number of courses you want to enroll for the student: ");
    int num_courses = sc_int.nextInt();
    if(num_courses <= student.MAX_NUM_COURSES)
      for(int i = 0; i < num_courses; i++){
            out.println("\n[-------- COURSE #" + (i+1) + "--------]");
            
            out.print("Name: ");
            String course_name = sc_str.nextLine();
            
            out.print("Course id: ");
            String course_id = sc_str.nextLine();
            
            out.print("Number of credits: ");
            int num_credits = sc_int.nextInt();
            
            out.print("Does the course is validable? [y/n]: ");
            char y_n = sc_str.nextLine().charAt(0);
            boolean validable = (y_n == 'y') ? true : false;
            
            out.print("Grade: ");
            double grade = sc_int.nextDouble();
            student.addCourses(validable, course_id, course_name, num_credits, grade);
      }
    else 
      out.println("You CANNOT enroll more than " + student.MAX_NUM_COURSES + " courses.");
  }

  public void showLogs(){
    out.println("\nEnrolled courses: \n");
    for(Course course : student.getCourses()){
        try {
            out.println(course.getId());
            out.println(course.getName());
            out.println(course.getGrade());
            out.println(course.getNumCredits());
            out.println(course.getValidable());
            out.println();    
        } catch(Exception e) {
          continue;
        }
    }
    out.print("AVERAGE GRADE: " + student.calculateAverageGrade());
    out.print( "\nACADEMIC TEST: " + ((student.isInAcademicTest) ? "YES" : "NO"));
  }
}