package School.Handlers;

public class InvalidSemesterException extends RuntimeException {
  public InvalidSemesterException(String msg) {
    super(msg);
  }
}
