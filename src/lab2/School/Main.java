package School;

// TODO (MAIN):
//  1. implement for now the basic classes together with the TODO(3), 
// then make the repo and then you may start to think about additionals 
// functionalites like the chat thing (threads), or the class materials thing  

// TODO 2: should implement an interface for defining all those 
// functionalies that are only implemented 

// TODO 3: could use decorator design pattern and implementing 
// the course of study of each student, DECORATING the admin 
// in function of the course of study, perhaps different courses 
// may have different exams, credits etc... 

import java.io.IOException;

import School.Users.StudentsAdmin;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) {
    // Student pontes = new Student("ponte", "monte", new Date(12, 12, 12));
    try {
      StudentsAdmin admin = new StudentsAdmin("src/lab2/School/Users/Data/student.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
