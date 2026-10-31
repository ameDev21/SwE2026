package School.Users;

import java.util.ArrayList;
import java.util.Date;

import School.Contents.Course;
import School.Contents.Grade;

/**
 * Student
 */
public class Student extends Person {
  private static int counter = 0;
  private int id;
  private ArrayList<Grade> grades = new ArrayList<Grade>();
  private ArrayList<Course> courses = new ArrayList<Course>();

  public Student(String name, String surname, Date birth_date) {
    super(name, surname, birth_date);
    this.id = counter;
    counter++;
  }

  public int getId() {
    return id;
  }

  public ArrayList<Grade> getGrades() {
    if (this.grades.isEmpty()) {
      // TODO: throw an expetion signaling the list is empty
    }
    return this.grades;
  }

  public void setGrades(ArrayList<Grade> grades) {
    this.grades = grades;
  }

  public void addGrade(int grade, int credits) {
    if (grade <= 32 && grade >= 18 && credits > 0) {
      this.grades.add(new Grade(grade, credits));
    }
  }

  public double meanGrade() {
    int sum = 0;
    for (int i = 0; i < this.grades.size(); i++) {
      sum += this.grades.get(i).getNumerical_grade();
    }
    return sum / this.grades.size();
  }

  public boolean canGraduate() {
    int sum = 0;
    for (int i = 0; i < this.grades.size(); i++) {
      sum += this.grades.get(i).getCredits();
    }
    return (sum >= 180) ? true : false;
  }

  public void enroll(Course c) {
    this.courses.add(c);
  }

}
