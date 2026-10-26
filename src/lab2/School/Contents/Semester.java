package School.Contents;

import java.util.ArrayList;
import java.util.Date;

/**
 * Semester (abstract)
 */
public abstract class Semester {
  SemesterType semester_type;
  Date start_date;
  Date end_date;

  Semester(SemesterType semester_type, Date start_date, Date end_date, ArrayList<Course> classes) {
    this.semester_type = semester_type;
    this.start_date = start_date;
    this.end_date = end_date;
  }

  public SemesterType getSemester_type() {
    return semester_type;
  }

  public void setSemester_type(SemesterType semester_type) {
    this.semester_type = semester_type;
  }

  public Date getStart_date() {
    return start_date;
  }

  public void setStart_date(Date start_date) {
    this.start_date = start_date;
  }

  public Date getEnd_date() {
    return end_date;
  }

  public void setEnd_date(Date end_date) {
    this.end_date = end_date;
  }
}
