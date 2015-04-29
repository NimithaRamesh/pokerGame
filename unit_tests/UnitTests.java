package unit_tests;

public class UnitTests {

	private static int errorCount = 0;

	public static void test(boolean assertion, String subject) {
		if (!assertion) {
			System.out.println("Test Failed: " + subject);
			errorCount++;
		}
	}

  public static int getErrorCount() {
    return errorCount;
  }

  public static void report() {
    if ( errorCount == 0 ) {
      System.out.println("All test passed.");
    } else {
      System.out.println( errorCount + " errors.");
    }
  }
}
