package pointofsale;

import java.io.IOError;
import java.io.IOException;
import java.net.Socket;

class ModemDidNotConnectException extends Exception {
}

class ModemLib {
  public static void dialModem(int number)
      throws ModemDidNotConnectException {
  }
}

class RetryCCLaterException extends Exception {
  public RetryCCLaterException() {
  }

  public RetryCCLaterException(String message) {
    super(message);
  }

  public RetryCCLaterException(String message, Throwable cause) {
    super(message, cause);
  }

  public RetryCCLaterException(Throwable cause) {
    super(cause);
  }

  public RetryCCLaterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
public class POS {
  private static boolean useModem = false;

  public static void authorizePmt(int amount)
//      throws ModemDidNotConnectException, IOException {
      throws RetryCCLaterException {
    int retriesAllowed = 3;
    boolean success = false;
//    while (! success && retriesAllowed > 0) {
    try {
      if (useModem) {
        // dial modem
        ModemLib.dialModem(1234); // try three times???
      } else {
        new Socket("127.0.0.1", 80);
      }
      // request payment
      // did it work?
      success = true;
    } catch (IOException | ModemDidNotConnectException e) {
      if (--retriesAllowed == 0) {
        throw new RetryCCLaterException(e);
      }
//    } catch (IOException e) {
//      if (--retriesAllowed == 0) {
//        throw e;
//      }
    }
  }

  public static void sellStuff() {
    try {
      authorizePmt(1000);
      // "What's a Modem" -> "I can't fix this"
      // oh, my methods are all ugly because they report "thows" this exception
//    } catch (ModemDidNotConnectException e) {
    } catch (RetryCCLaterException e) {
      System.out.println("Ooops, maybe wiggle the wires?");
    }
  }

  public static void main(String[] args) {
    sellStuff();
  }
}
