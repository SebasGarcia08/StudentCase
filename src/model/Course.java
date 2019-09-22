package model;

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
      this.grade = (grade >= 1) ? grade : 1.0;
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