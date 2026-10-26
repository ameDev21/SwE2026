package School.Users;

import java.util.Date;

/**
 * Person
 */
public abstract class Person {
  private String name;
  private String surname;

  public Person(String name, String surname, Date birth_date) {
    this.name = name;
    this.surname = surname;
    this.birth_date = birth_date;
  }

  public Person() {
  };

  private Date birth_date;

  public void setName(String name) {
    this.name = name;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public void setBirth_date(Date birth_date) {
    this.birth_date = birth_date;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public Date getBirth_date() {
    this.birth_date.toString();
    return birth_date;
  }
}
