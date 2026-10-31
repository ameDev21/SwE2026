// THIS SHOULD BE A SINGLETON
package School.Contents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;

import School.Handlers.InvalidPathException;
import School.Contents.Semester;

/**
 * SemesterAdmin
 */
public class SemestersAdmin {
  private static SemestersAdmin instance;
  private ArrayList<Semester> semesters = new ArrayList<Semester>();

  private SemestersAdmin() {
  }

  public SemestersAdmin getInstance() {
    if (instance == null) {
      instance = new SemestersAdmin();
      return instance;
    } else {
      return instance;
    }
  }

  public void addSemester(Semester s) {
    if (instance == null) {
      getInstance().addSemester(s);
    } else {
      instance.addSemester(s);
    }
  }

  public ArrayList<Semester> getSemesters() {
    return semesters;
  }

  public int semesterIndex(Year y, SemesterType st) {
    for (int i = 0; i < this.getInstance().semesters.size(); i++) {
      if (instance.getSemesters().get(i).getYear().equals(y)
          && instance.getSemesters().get(i).getSemesterType().equals(st)) {
        return i;
      }
    }
    return -1;
  }

  public void readSemesters(String pathname) throws IOException {
    File file = new File(pathname);
    if (!file.canRead()) {
      throw new InvalidPathException("invalid file path");
    }

    BufferedReader reader = new BufferedReader(new FileReader(pathname));
    String line = "";
    // marking the start of the file
    while ((line = reader.readLine()) != null) {
      // reading the line single element (CSV style)
      // the CSV the courses/semesters are:
      // course_id, year, semesterType, professor
      String[] row = line.split(",");
      // TODO: check here if the professor exists, otherwise display an error message
      int i; 
      // TODO: fix this adding the costructor for semestertype taking a string 
      // and for the year search a way around to convert the string to a number (int)
      /* 
      if ((i = semesterIndex(new Year(row[1]), new SemesterType(row[2]))) != -1) {
        // semester already existing 
      } else {
        instance.addSemester(new Semester(new SemesterType(row[2]), new Year(row[1]), new ArrayList<Course>()));
      }
      */ 
      /* ASSUMING HERE THAT THE PROFESSOR EXISTS */

      }
      // this.getInstance().cour(new Student(row[0], row[1], new Date(row[2])));

    }
  // closing the input stream to the file
  reader.close();

  // debugging call
  // printStudents();
}}
