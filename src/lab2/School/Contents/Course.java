package School.Contents;

import java.time.Year;
import java.util.ArrayList;
import School.Users.*;

/**
 * Course
 */
public class Course {
  private int credits;
  private int course_id;
  // this may be redoundant with the professor information
  private Professor professor;
  private ArrayList<Student> enrolled = new ArrayList<Student>();
  private SemesterType semesterType;
  private Year year;

  Course(int course_id, int credits, Professor professor, ArrayList<Student> enrolled,
      SemesterType semesterType, Year year) {
    this.course_id = course_id;
    this.professor = professor;
    this.enrolled = enrolled;
    this.year = year;
    this.semesterType = semesterType;
  }

  Course(int course_id, int credits, SemesterType semesterType, Year year) {
    this.course_id = course_id;
    this.credits = credits;
    this.semesterType = semesterType;
    this.year = year;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

  public void setCourse_id(int course_id) {
    this.course_id = course_id;
  }

  public void setEnrolled(ArrayList<Student> enrolled) {
    this.enrolled = enrolled;
  }

  public void setSemesterType(SemesterType semesterType) {
    this.semesterType = semesterType;
  }

  public Year getYear() {
    return year;
  }

  public void setYear(Year year) {
    this.year = year;
  }

  public int getCredits() {
    return credits;
  }

  public int getCourse_id() {
    return course_id;
  }

  public Professor getProfessor() {
    return professor;
  }

  public void setProfessor(Professor professor) {
    this.professor = professor;
  }

  public ArrayList<Student> getEnrolled() {
    return enrolled;
  }

  public SemesterType getSemesterType() {
    return semesterType;
  }

  @Override
  public String toString() {
    return ("course_id: " + Integer.toString(this.getCourse_id()) + " cfu: " + Integer.toString(this.getCredits()));
  }
}
