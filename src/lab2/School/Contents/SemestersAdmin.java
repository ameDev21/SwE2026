// THIS SHOULD BE A SINGLETON
package School.Contents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

import School.Handlers.InvalidPathException;
import School.Handlers.InvalidSemesterException;

/**
 * SemesterAdmin
 */
public class SemestersAdmin {
  private static SemestersAdmin instance;
  private ArrayList<Semester> semesters = new ArrayList<Semester>();

  private SemestersAdmin() {
  }

  public static SemestersAdmin getInstance() {
    if (instance == null) {
      instance = new SemestersAdmin();
      return instance;
    } else {
      return instance;
    }
  }

  public void addSemester(Semester s) {
    if (instance == null) {
      getInstance().semesters.add(s);
    } else {
      instance.semesters.add(s);
    }
  }

  public ArrayList<Semester> getSemesters() {
    return semesters;
  }

  public int semesterIndex(Year y, SemesterType st) {
    for (int i = 0; i < SemestersAdmin.getInstance().semesters.size(); i++) {
      if (SemestersAdmin.getInstance().getSemesters().get(i).getYear().equals(y)
          && SemestersAdmin.getInstance().getSemesters().get(i).getSemesterType().equals(st)) {
        return i;
      }
    }
    return -1;
  }

  public void readSemesters(String pathname) throws IOException {
    int counter_lines = 0;
    SemesterType st;
    File file = new File(pathname);
    if (!file.canRead()) {
      throw new InvalidPathException("invalid file path for classes registering");
    }

    BufferedReader reader = new BufferedReader(new FileReader(pathname));
    String line = "";
    // marking the start of the file
    while ((line = reader.readLine()) != null) {
      counter_lines++;
      // reading the line single element (CSV style)
      // the CSV the courses/semesters are:
      // course_id [0], year [1], semesterType[2], credits [3]
      String[] row = line.split(",");
      int i;
      if (row[2].equals("FALL")) {
        st = SemesterType.FALL;
      } else if (row[2].equals("SPRING")) {
        st = SemesterType.SPRING;
      } else {
        reader.close();
        throw new InvalidSemesterException("The semester inserted at line " + counter_lines + " is not valid");
      }
      if ((i = semesterIndex(Year.of(Integer.parseInt(row[1])), st)) != -1) {
        // semester already existing
        SemestersAdmin.getInstance().getSemesters().get(i).addCourse(
            new Course(Integer.parseInt(row[0]), Integer.parseInt(row[3]), st, Year.of(Integer.parseInt(row[1]))));
      } else {
        SemestersAdmin.getInstance().addSemester(new Semester(st, Year.of(Integer.parseInt(row[1]))));
        SemestersAdmin.getInstance().getSemesters().get(SemestersAdmin.getInstance().getSemesters().size() - 1)
            .addCourse(
                new Course(Integer.parseInt(row[0]), Integer.parseInt(row[3]), st, Year.of(Integer.parseInt(row[1]))));
      }
    }
    // closing input stream on the file
    reader.close();
  }

  public void printSemesters() {
    for (Semester semester : SemestersAdmin.getInstance().getSemesters()) {
      System.out.println(semester.toString());
    }
  }
}
