package School;

import java.io.IOException;

import School.Users.StudentsAdmin;
import School.Contents.SemestersAdmin;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    // Student pontes = new Student("ponte", "monte", new Date(12, 12, 12));
    try {
      StudentsAdmin.getInstance().readStudents("src/lab2/School/Users/Data/students.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
    try {
      SemestersAdmin.getInstance().readSemesters("src/lab2/School/Contents/Data/semestersCourses.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
    SemestersAdmin.getInstance().printSemesters();
    StudentsAdmin.getInstance().printStudents();
  }
}
