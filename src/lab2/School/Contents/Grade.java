package School.Contents;

/**
 * Grade
 */
public class Grade {
  private int numerical_grade;
  private int credits;

  public Grade(int numerical_grade, int credits) {
    this.numerical_grade = numerical_grade;
    this.credits = credits;
  }

  public int getNumerical_grade() {
    return numerical_grade;
  }

  public void setNumerical_grade(int numerical_grade) {
    this.numerical_grade = numerical_grade;
  }

  public int getCredits() {
    return credits;
  }

  public void setCredits(int credits) {
    this.credits = credits;
  }

}
