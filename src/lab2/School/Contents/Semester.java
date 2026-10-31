package School.Contents;

import java.time.Year;
import java.util.ArrayList;

/**
 * Semester (abstract)
 */
public abstract class Semester {
  private SemesterType semester_type;
  private Year year;
  private ArrayList<Course> courses = new ArrayList<Course>();

  Semester(SemesterType semester_type, Year year, ArrayList<Course> courses) {
    this.semester_type = semester_type;
    this.courses = courses;
    this.year = year;
    this.courses = courses;
  }

  public SemesterType getSemesterType() {
    return semester_type;
  }

  public void setSemesterType(SemesterType semester_type) {
    this.semester_type = semester_type;
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
}
