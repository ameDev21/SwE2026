package Bank.Handlers;

/**
 * InsufficientFundsException
 */
public class InsufficientFundsException extends RuntimeException {
  public InsufficientFundsException(String msg) {
    super(msg);
  }
}
