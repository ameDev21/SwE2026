package School.Contents;

import School.Users.*;

import java.util.ArrayList;

/**
 * Exam
 */
public class Exam extends Course {

  public Exam(int credits, Professor teacher, ArrayList<Student> enrolled, Date start_date, Date end_date,
      SemesterType semesterType) {
    super(credits, teacher, enrolled, start_date, end_date, semesterType);
  }
}
