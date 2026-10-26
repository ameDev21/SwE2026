package School.Contents;

import java.util.ArrayList;
import School.Users;

/**
 * Course
 */
public class Course extends Semester {
  private int credits;
  // this may be redoundant with the professor information
  private Professor teacher;
  private ArrayList<Student> enrolled = new ArrayList<Student>();
  // IDEA: to add a COURSE CHAT implemeting some others interesting
  // functionalities, like course materials etc...

  Course(int credits, Professor teacher, ArrayList<Student> enrolled, Date start_date, Date end_date,
      SemesterType semesterType) {
    super(semesterType, start_date, end_date, semesterType);
    this.credits = credits;
    this.teacher = teacher;
    this.enrolled = enrolled;
  }
}
