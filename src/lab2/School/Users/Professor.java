// TODO: there may be a need for a professors admin, so
// you should see the applicability of some design patter
// on the StudentsAdmin.java class or in general you may
// need to create an Admin.java file...

package School.Users;

import java.util.ArrayList;
import java.util.Date;

import School.Contents.Course;

/**
 * Professor
 */
public class Professor extends Person {
  private static int counter = 0;
  private int id;
  private ArrayList<Course> courses = new ArrayList<>();

  Professor(String name, String surname, Date birthdate) {
    super(name, surname, birthdate);

  }

  public static int getCounter() {
    return counter;
  }

  public static void setCounter(int counter) {
    Professor.counter = counter;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ArrayList<Course> getCourses() {
    return this.courses;
  }

  public void addCourse(Course course) {
    this.courses.add(course);
  }
}
