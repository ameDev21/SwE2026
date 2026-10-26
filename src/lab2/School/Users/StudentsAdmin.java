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
  private ArrayList<Student> students = new ArrayList<>();

  public StudentsAdmin(String pathname) throws IOException {
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
      this.students.add(new Student(row[0], row[1], new Date(row[2])));
    }
    // closing the input stream to the file
    reader.close();

    // debugging call
    // printStudents();
  }

  // simple method that prints the managed students
  public void printStudents() {
    for (int i = 0; i < this.students.size(); i++) {
      System.out.printf("[%d] : %s, %s, %s \n", i, this.students.get(i).getName(), this.students.get(i).getSurname(),
          this.students.get(i).getBirth_date().toString());
    }
  }
}
