package School.Contents;

import School.Users.*;

import java.time.Year;
import java.util.ArrayList;

/**
 * Exam
 */
public class Exam extends Course {

  private ArrayList<Grade> grades = new ArrayList<Grade>();

  public Exam(int course_id, int credits, Professor professor, ArrayList<Student> enrolled, Year year,
      SemesterType semesterType) {
    super(course_id, credits, professor, enrolled, semesterType, year);
  }

  public ArrayList<Grade> getGrades() {
    return grades;
  }

  public void setGrades(ArrayList<Grade> grades) {
    this.grades = grades;
  }

  public double mean() {
    double sum = 0;
    if (!grades.isEmpty()) {
      for (Grade g : grades) {
        sum += g.getNumerical_grade();
      }
    } else {
      // maybe here i could throw an exception
      return -1;
    }
    return sum / grades.size();
  }

  public double stdDev() {
    double sum = 0;
    double mean = this.mean();
    if (mean == -1) {
      return -1;
    }
    for (Grade g : grades) {
      sum += Math.pow(g.getNumerical_grade() - mean, 2);
    }
    return Math.sqrt(sum / this.grades.size());

  }

  // could add a method that plots the normal distribution
  // public void plotDistribution() {...}
}
