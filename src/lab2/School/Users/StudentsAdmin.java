// THIS CLASS SHOULD BE A SINGLETON
package School.Users;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
// import java.io.Reader;
// import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
// import java.util.Scanner;
import School.Handlers.*;

/**
 * StudentsAdmin with aggregation to student
 */
public class StudentsAdmin {
  private static StudentsAdmin instance;
  private ArrayList<Student> students = new ArrayList<>();

  private StudentsAdmin() {
  }

  public static StudentsAdmin getInstance() {
    if (instance == null) {
      instance = new StudentsAdmin();
      return instance;
    } else {
      return instance;
    }
  }

  public void readStudents(String pathname) throws IOException {
    File file = new File(pathname);
    if (!file.canRead()) {
      throw new InvalidPathException("invalid file path");
    }

    BufferedReader reader = new BufferedReader(new FileReader(pathname));
    String line = "";
    // marking the start of the file
    while ((line = reader.readLine()) != null) {
      // reading the line single element (CSV style)
      String[] row = line.split(",");
      StudentsAdmin.getInstance().students.add(new Student(row[0], row[1], new Date(row[2])));
    }
    // closing the input stream to the file
    reader.close();

    // debugging call
    // printStudents();
  }

  public ArrayList<Student> getStudents() {
    return students;
  }

  // simple method that prints the managed students
  public void printStudents() {
    for (Student student : StudentsAdmin.getInstance().getStudents()) {
      System.out.println(student.toString());
    }
  }
}
