package ui;

import java.util.Scanner;
import model.*;
// Little lazy trick to avoid typing System.blablabla everytime xd.
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
          program.enrollCourses();
          out.print("Do you want to unregister courses of this student? [y/n]: ");
          char unregister_y_n = sc_str.nextLine().charAt(0);
          boolean unregister = (unregister_y_n == 'y');
      
          if(unregister) {
            program.unregisterCourses();
          }
        }
        
      if(student.getNumberOfCoursesEnrolled() > 0){
          program.showLogs();
      }
  }

  public void enrollStudent(){
    out.println("\nPlease type in the information requested to register the student: \n");
    
    out.print("Id: ");
    String id = sc_str.nextLine();
    student.setId(id);

    out.print("Student's name: ");
    String name = sc_str.nextLine();
    student.setName(name);

    out.print("Last name: ");
    String last_name = sc_str.nextLine();
    student.setLastName(last_name);

    out.print("State: [a: ACTIVE / r: RETIRED / g: GRADUATE]: ");
    char state = sc_str.nextLine().charAt(0);
    student.setState(state);

    out.println("\nStudent '" + student.getName() + " " + student.getLastName() + "' with id '" + student.getId() + "' succesfully enrolled.");
  }

  public void enrollCourses(){
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

  public void unregisterCourses(){
    out.print("\nHow many courses do you want to unregister?: ");
    int num_courses = sc_int.nextInt();
    
    // Validate the number of courses registered.    
    if(num_courses <= student.getNumberOfCoursesEnrolled()){
      for(int i=0; i < num_courses; i++){
        out.print("Type the id of the course you want to unregister: ");
        String id = sc_str.nextLine();
        student.unregisterCourse(id);
      }
    } else {
      out.println("You CANNOT unregister more courses than the ones already enrolled.");
    }
  }

  public void showLogs(){
    out.println("\nEnrolled courses: \n");
    for(Course course : student.getCourses()){
        try {
            out.println(" Id: " + course.getId());
            out.println(" Name: " + course.getName());
            out.println(" Grade: " + course.getGrade());
            out.println(" Number of credits:  "+course.getNumCredits());
            out.println(" Is validable: " + ( (course.getValidable()) ? "YES": "NO"));
            out.println();    
        } catch(Exception e) {
          continue;
        }
    }
    out.print("AVERAGE GRADE: " + student.calculateAverageGrade());
    out.print( "\nACADEMIC TEST: " + ((student.isInAcademicTest) ? "YES" : "NO"));
  }
}