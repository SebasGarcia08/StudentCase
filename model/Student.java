package model;
public class Student{

    private Course[] courses;
  
    // Constants variables
    public final char ACTIVE = 'a';
    public final char RETIRED = 'r';
    public final char GRADUATE = 'g';
    
    // Atributes
    private boolean academicTest;
    private String id, name, last_name;
    private char state;
  
    // Constructor
    public Student(boolean academicTest, String id, String name, String last_name, char state, Course[] courses){
      this.academicTest = academicTest;
      this.id = id;
      this.name = name;
      this.last_name = last_name;
      this.state = state;
      this.courses = new Course[5];  
    }

    public Student() {
      this.academicTest = false;
      this.id = "";
      this.name = "";
      this.last_name = "";
      this.state = ACTIVE;
      this.courses = new Course[5];  
    }
    
    // Setters
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
        
        System.out.println("\nYOU CAN ENROLL " + (num_available_courses-1)+ " MORE COURSES. ");
        System.out.println((courseExists) ? "\nCOURSE ALREADY ENROLLED" : "\nCOURSE HAS NOT BEEN ENROLLED");

        if(!courseExists && num_available_courses > 0){
          // System.out.println("VALID CONDITIONS");
          int idx = courses.length - num_available_courses;
          for(int i = idx; i < (idx + 1); i++){
            courses[i] = new Course(validable, id, name, num_credits, grade);
          }
        } else {
          System.out.println("UNVALID CONDITIONS TO ENROLL COURSE WITH ID " + id);
        }
    }
 
    public void setAcademicTest(boolean academicTest){
      this.academicTest = academicTest;
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

    public boolean getAcademicTest(){
      return this.academicTest;
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