package School.Contents;

import java.time.Year;
import java.util.ArrayList;

/**
 * Semester (abstract)
 */
public class Semester {
  private SemesterType semesterType;
  private Year year;
  private ArrayList<Course> courses = new ArrayList<Course>();

  Semester(SemesterType semesterType, Year year) {
    this.semesterType = semesterType;
    this.year = year;
  }

  public SemesterType getSemesterType() {
    return semesterType;
  }

  public void setSemesterType(SemesterType semesterType) {
    this.semesterType = semesterType;
  }

  public Year getYear() {
    return year;
  }

  public ArrayList<Course> getCourses() {
    return courses;
  }

  protected void addCourse(Course course) {
    if (!this.courses.contains(course)) {
      this.courses.add(course);
    }
  }

  @Override
  public String toString() {
    String s = this.getSemesterType().toString() + " " + this.getYear().toString() + ": [";

    for (Course course : this.getCourses()) {
      s += course.toString() + ", ";
    }
    s = s.substring(0, s.length() - 2);
    s += "]";
    return s;
  }
}
