package model;
import java.lang.reflect.Field;

public class Course {
    // Constants
    public static final double MIN_GRADE = 1.0;
    
    // Attributes
    private boolean validable;
    private String id, name;
    private int num_credits;
    private double grade;
  
    // Constructor
    public Course (boolean validable, String id, String name, int num_credits, double grade) {
      this.validable = validable;
      this.id = id;
      this.name = name;
      this.num_credits = num_credits;
      this.grade = grade;
    }

  
  /*  public boolean isNull(){
        for (Field f : getClass().getDeclaredFields())
            try {
                if (f.get(this) != null)
                    return false;
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
            }
        return true;              
    }*/
    
    // Setters
    public void setValidable(boolean validable){
      this.validable = validable;
    }
  
    public void setId(String id){
      this.id = id;
    }
  
    public void setName(String name){
      this.name = name;
    }
  
    public void setNumCredits(int num_credits){
      this.num_credits = num_credits;
    }
  
    public void setGrade(double grade){
      this.grade = grade;
    }
  
    // Getters
    public boolean getValidable(){
      return this.validable;
    } 
  
    public String getId(){
      return this.id;
    }
  
    public String getName(){
      return this.name;
    }
  
    public int getNumCredits(){
      return this.num_credits
      ;
    }
    
    public double getGrade(){
      return this.grade;
    }
  }