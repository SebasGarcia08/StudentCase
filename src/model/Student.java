package model;
import static java.lang.System.out;

public class Student{
  
    // Constants variables
    public final char ACTIVE = 'a';
    public final char RETIRED = 'r';
    public final char GRADUATE = 'g';
    public final int MAX_NUM_COURSES = 5;
    public boolean isInAcademicTest = isInAcademicTest();

    // Atributes
    private String id, name, last_name;
    private char state;
    private Course[] courses;
  
    // Constructor
    public Student(String id, String name, String last_name, char state, Course[] courses){
      this.id = id;
      this.name = name;
      this.last_name = last_name;
      this.state = state;
      this.courses = new Course[MAX_NUM_COURSES];  
    }

    public Student() {
      this.id = "";
      this.name = "";
      this.last_name = "";
      this.state = ACTIVE;
      this.courses = new Course[MAX_NUM_COURSES];  
    }
    
    public void addCourses(boolean validable, String id, String name, int num_credits, double grade){
      boolean courseExists = false;
      int num_available_courses=0;

        // Validar que el curso no exista.
        for (Course course : courses) {
            if (!(course == null)) {
                if (course.getId().equals(id)) {
                    courseExists = true;
                }
            } 
        }
  
        // Validar cuántos cursos están disponibles para matricular.
        for (Course course : courses) {
            if(course == null) {
                num_available_courses++;
            }
        }
        
       out.println("\nYOU CAN ENROLL " + (num_available_courses-1)+ " MORE COURSES. ");
       out.print((courseExists) ? "\nCOURSE ALREADY ENROLLED " : " ");

        if(!courseExists && num_available_courses > 0){
          //out.println("VALID CONDITIONS");
         out.print((grade >= 1) ? "" : "\nSince minimal final grade is 1, then switching grade to 1...\n");
          double final_grade = (grade >= 1) ? grade : 1;
          int idx = courses.length - num_available_courses;
          for(int i = idx; i < (idx + 1); i++){
            courses[i] = new Course(validable, id, name, num_credits, final_grade);
          }
         out.print( name + " ENROLLED SUCCESFULLY.");
        } else {
         out.println("UNVALID CONDITIONS TO ENROLL COURSE WITH ID " + id);
        }
    }

    public double calculateAverageGrade(){
      double sum_notes_times_num_credits = 0, total_credits=0;
      try {
        for(Course course: this.courses){
          if(course != null){
            sum_notes_times_num_credits += course.getGrade() * course.getNumCredits();
            total_credits+=course.getNumCredits();
          }
        }
        return sum_notes_times_num_credits / ( (total_credits>0) ? total_credits : 1);
      } catch (Exception e){
        return Course.MIN_GRADE;
      }
    }

    public boolean isInAcademicTest(){
      return (this.calculateAverageGrade() < 3.25 && this.state == ACTIVE);
    }

   // Setters
    public void setCourses(Course[] courses){
      this.courses = courses;
    }
  
    public void setId(String id){
      this.id = id;
    }
  
    public void setName(String name){
      this.name = name;
    }
    
    public void setLastName(String last_name){
      this.last_name = last_name;
    }
  
    public void setState(char state){
      this.state = state;
    }
  
  // Getters
    public Course[] getCourses(){
      return this.courses;
    }
  
    public String getCode(){
      return this.id;
    }
  
    public String getName(){
      return this.name;
    }
  
    public String getLastName(){
      return this.last_name;
    }
  
    public char getState(){
      return this.state;
    }

    public String getId(){
      return this.id;
    }
  
  }