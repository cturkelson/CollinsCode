import org.junit.Assert;
import org.junit.Test;
import java.util.function.BiFunction;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Test cases for a signed 16-bit ALU.
 * <p>
 * IMPORTANT:  These test cases do *not* thoroughly test the circuit.
 *  You need to re-name this class and add more tests!
 * <p>
 * <p>
 * Created by kurmasz on 8/8/16. Updated and added to by Collin
 * Turkelson and Meghan Harris on 3/3/2022.
 */
public class ALU16BitTest {

  public static class OpCodes {
    public static final int ADDU = 0;
    public static final int SUBU = 1;
    public static final int AND  = 2;
    public static final int OR   = 3;
    public static final int NOT  = 4;
    public static final int XOR  = 5;
    public static final int LUI  = 6;
    public static final int SLTU = 7;
    public static final int ADD  = 8;
    public static final int SUB  = 9;
    public static final int SLT  = 15;
  }

  // Unsigned Addition Testing  NOTE: Not too worried about this one.
  @Test
  public void testAddu() {
    setPinUnsigned("InputA", 53400);
    setPinUnsigned("InputB", 53500);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (53400 + 53500) % 65536, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu1() {
    setPinUnsigned("InputA", 0);
    setPinUnsigned("InputB", 1);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (0 + 1), readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu2() {
    setPinUnsigned("InputA", 0);
    setPinUnsigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (0 + 0), readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu3() {
    setPinUnsigned("InputA", 400);
    setPinUnsigned("InputB", 3500);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (400 + 3500), readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddu4() {
    setPinUnsigned("InputA", 24);
    setPinUnsigned("InputB", 333);
    setPinUnsigned("Op", OpCodes.ADDU);
    run();
    Assert.assertEquals("Addition Output", (24 + 333), readPinUnsigned("Output"));
 
    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }
  
  // Unsigned Subtraction Testing  NOTE: See if the Subu1 makes sense to you.
  // I wanted to test what would happen if we subtracted two unsigned that technically
  // should be negative, but would ultimately be read as an unsigned positive.
  @Test
  public void testSubu() {
    setPinUnsigned("InputA", 2);
    setPinUnsigned("InputB", 2);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Subtraction Output", 2 - 2, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testSubu1() {
    setPinUnsigned("InputA", 2);
    setPinUnsigned("InputB", 3);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Subtraction Output", ((2 - 3) & 0xFFFF), readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testSubu2() {
    setPinUnsigned("InputA", 0);
    setPinUnsigned("InputB", 0);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Subtraction Output", 0 - 0, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testSubu3() {
    setPinUnsigned("InputA",1110);
    setPinUnsigned("InputB", 743);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Subtraction Output", 1110 - 743, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testSubu4() {
    setPinUnsigned("InputA", 53500);
    setPinUnsigned("InputB", 53400);
    setPinUnsigned("Op", OpCodes.SUBU);
    run();
    Assert.assertEquals("Subtraction Output", 53500 - 53400, readPinUnsigned("Output"));

    // Overflow for unsigned addition is false by definition
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  // Testing Signed Addition  NOTE: This one has the Frankenstein's creature method
  // I hacked from a previous test.  Scroll down.
  @Test
  public void testAddition() {
    setPinSigned("InputA", 23);
    setPinSigned("InputB", 44);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 23 + 44, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddition1() {
    setPinSigned("InputA", -23);
    setPinSigned("InputB", 44);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", -23 + 44, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddition2() {
    setPinSigned("InputA", 0);
    setPinSigned("InputB", -1);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 0 + -1, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  @Test
  public void testAddition3() {
    setPinSigned("InputA", 550);
    setPinSigned("InputB", -4444);
    setPinUnsigned("Op", OpCodes.ADD);
    run();
    Assert.assertEquals("Addition Output", 550 + -4444, readPinSigned("Output"));
    Assert.assertEquals("Addition Overflow", false, readPin("Overflow"));
  }

  // The complete list of integers to be tests.
  // Added additional numbers to original list.
  public static final long testIntegers[] = {-32768, -32767, -5500, -789,
	  -110, -8, -7, -6, -1, 0, 1, 2, 13, 0xA, 127, 128, 129, 500, 789,
	  1900, 1901, 1902, 0x5555, 5600, 5605, 22222, 32766, 32767};

  // NOTE: This is where the one test that fails exists.  It also tests Signed Subtraction.
  // Helper method that runs test for given pair of integers and an 
  // operation (`false` for add, `true` for subtract)
  private void verify(long a, long b, int op) {
    // Compute the expected outputs
    long expected;
    String s = "";
    if (op == OpCodes.SUB) {
	   expected = a - b;
	   s = "-";
    } else {
	   expected = a + b;
	   s = "+";
    }
    // The `overflow` output should be `true` if the expected output is not in the range [-(2^15), (2^15)-1]
    // (In java "1 << 15" takes the bit string 0000000000000001 and shifts it left 15 spaces, effectively
    // generating the value 2^15.)
    boolean expectedOverflow = ((expected >= (1 << 15)) || (expected < -(1 << 15)));

    // Output "wraps around" if there is an overflow
    if (expectedOverflow && expected > 0) {
      expected -= 65536;
    } else if (expectedOverflow && expected < 0) {
      expected += 65536;
    }

    // Configure and simulate the circuit
    setPinSigned("InputA", a);
    setPinSigned("InputB", b);
    setPinUnsigned("Op", op);
    run();

    // Check the correctness of the output
    //String message = "of " + a + (op ? " - " : " + ") + b + ": ";
    //Assert.assertEquals("Output " + message, expected, readPinSigned("Output"));
    //Assert.assertEquals("Overflow " + message, expectedOverflow, readPin("Overflow"));
   
    String message = String.format(" of %d %s %d (signed) ", a, s, b);
    Assert.assertEquals("Output" + message, expected, readPinSigned("Output"));
    if (expectedOverflow) {
      Assert.assertEquals("Overflow" + message, true, readPin("Overflow"));
    }

  }
 
  // Signed Addition and Subtraction Testing.
  @Test
  public void testAll() {
    for (long a : testIntegers) {
      for (long b : testIntegers) {
        verify(a, b, OpCodes.ADD);
        verify(a, b, OpCodes.SUB);
      }
    }
  }
  
  // Signed Subtraction Testing.  MORE?
  @Test
  public void testSubtraction() {
    setPinSigned("InputA", 24);
    setPinSigned("InputB", 45);
    setPinUnsigned("Op", OpCodes.SUB);
    run();
    Assert.assertEquals("Subtraction Output", 24 - 45, readPinSigned("Output"));
    Assert.assertEquals("Subtraction Overflow", false, readPin("Overflow"));
  }

  // Set Less Than Testing.
  @Test
  public void ltSigned() {
    setPinSigned("InputA", 5);
    setPinSigned("InputB", 6);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    Assert.assertEquals("Signed Less Than Output", 1, readPinSigned("Output"));
    Assert.assertEquals("Signed Less Than Overflow", false, readPin("Overflow"));
  }

  @Test
  public void ltSigned2() {
    setPinSigned("InputA", 32767);
    setPinSigned("InputB", -1);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    Assert.assertEquals("Signed Less Than Output", 0, readPinSigned("Output"));
    Assert.assertEquals("Signed Less Than Overflow", false, readPin("Overflow"));
  }

  // More Signed SLT Testing.
  public static void verifySigned(long a, long b, boolean checkOverflow) {
    long expected = (a < b) ? 1 : 0;

    setPinSigned("InputA", a);
    setPinSigned("InputB", b);
    setPinUnsigned("Op", OpCodes.SLT);
    run();
    String message = String.format(" of %d < %d (signed) ", a, b);
    Assert.assertEquals("Output" + message, expected, readPinUnsigned("Output"));
    if (checkOverflow) {
      Assert.assertEquals("Overflow" + message, false, readPin("Overflow"));
    }
  }


  @Test
  public void ltSigned_allPairs() {
    long[] values = {-32768, -32767, -1, 0, 1, 32766, 32767};
    for (long a : values) {
      for (long b : values) {
        verifySigned(a, b, true);
      }
    }
  }
  
  // Unsigned SLT Testing.
  public static void verifyUnsigned(long a, long b, boolean checkOverflow) {
    long expected = (a < b) ? 1 : 0;

    setPinUnsigned("InputA", a);
    setPinUnsigned("InputB", b);
    setPinUnsigned("Op", OpCodes.SLTU);
    run();
    String message = String.format(" of %d < %d (unsigned) ", a, b);
    Assert.assertEquals("Output" + message, expected, readPinUnsigned("Output"));
    if (checkOverflow) {
      Assert.assertEquals("Overflow" + message, false, readPin("Overflow"));
    }
  }

  @Test
  public void ltUnsigned_allPairs() {
    long[] values = {0, 1, 2, 65534, 65535};
    for (long a : values) {
      for (long b : values) {
        verifyUnsigned(a, b, true);
      }
    }
  }
  
  // Logical AND, OR, XOR Testing.
  private void verifyLogic(String name, int op, long a, long b, BiFunction<Long, Long, Long> func) {
    setPinUnsigned("InputA", a);
    setPinUnsigned("InputB", b);
    setPinUnsigned("Op", op); 
    run();
    String message = String.format("0x%x %s 0x%x", a, name, b);
    Assert.assertEquals(message, (long)func.apply(a, b), readPinUnsigned("Output"));
    Assert.assertFalse(message + " overflow", readPin("Overflow"));
  }
  
  // AND Testing
  @Test
  public void testAnd() {
    verifyLogic("and", OpCodes.AND, 0xFF00, 0x0F0F, (a, b) -> a & b);
  }

  @Test
  public void testAnd1() {
    verifyLogic("and", OpCodes.AND, 0xA843, 0xD5A2, (a, b) -> a & b);
  }

  @Test
  public void testAnd2() {
    verifyLogic("and", OpCodes.AND, 0x0000, 0xFFFF, (a, b) -> a & b);
  }
  
  @Test
  public void testAnd3() {
    verifyLogic("and", OpCodes.AND, 0xFFFF, 0xFFFF, (a, b) -> a & b);
  }

  @Test
  public void testAnd4() {
    verifyLogic("and", OpCodes.AND, 0x0000, 0x0000, (a, b) -> a & b);
  }

  // OR Testing
  @Test
  public void testOr() {
    verifyLogic("or", OpCodes.OR, 0xFF00, 0x0F0F, (a, b) -> a | b);
  }
 
  @Test
  public void testOr1() {
    verifyLogic("or", OpCodes.OR, 0xA843, 0xD5A2, (a, b) -> a | b);
  }

  @Test
  public void testOr2() {
    verifyLogic("or", OpCodes.OR, 0x0000, 0xFFFF, (a, b) -> a | b);
  }

  @Test
  public void testOr3() {
    verifyLogic("or", OpCodes.OR, 0xFFFF, 0xFFFF, (a, b) -> a | b);
  }

  @Test
  public void testOr4() {
    verifyLogic("or", OpCodes.OR, 0x0000, 0x0000, (a, b) -> a | b);
  }

  // XOR Testing
  @Test
  public void testXor() {
    verifyLogic("xor", OpCodes.XOR, 0xFF00, 0x0F0F, (a, b) -> a ^ b);
  }

  @Test
  public void testXor1() {
    verifyLogic("xor", OpCodes.XOR, 0xA843, 0xD5A2, (a, b) -> a ^ b);
  }

  @Test
  public void testXor2() {
    verifyLogic("xor", OpCodes.XOR, 0x0000, 0xFFFF, (a, b) -> a ^ b);
  }

  @Test
  public void testXor3() {
    verifyLogic("xor", OpCodes.XOR, 0xFFFF, 0xFFFF, (a, b) -> a ^ b);
  }

  @Test
  public void testXor4() {
    verifyLogic("xor", OpCodes.XOR, 0x0000, 0x0000, (a, b) -> a ^ b);
  }

  // NOT Testing  NOTE: NOT and LUI are working as I expect them to, but 
  // I would really like you to test my logic here.  I used 0xFFFF in order
  // to keep the ~a from being inverted back into and signed number.
  private void verifyLogicNot(String name, int op, long a) {
    setPinUnsigned("InputA", a);
    setPinUnsigned("Op", op);
    run();
    String message = String.format("0x%x %s", a, name);
    Assert.assertEquals(message, (~a & 0xFFFF), readPinUnsigned("Output"));
    Assert.assertFalse(message + " overflow", readPin("Overflow"));
  }
  
  @Test
  public void testNot() {
    verifyLogicNot("not", OpCodes.NOT, 0xFF00);
  }

  @Test
  public void testNot1() {
    verifyLogicNot("not", OpCodes.NOT, 0xA843);
  }

  @Test
  public void testNot2() {
    verifyLogicNot("not", OpCodes.NOT, 0x0000);
  }

  @Test
  public void testNot3() {
    verifyLogicNot("not", OpCodes.NOT, 0xFFFF);
  }

  @Test
  public void testNot4() {
    verifyLogicNot("not", OpCodes.NOT, 0xD5A2);
  }

  //LUI Testing
  private void verifyLogicLui(String name, int op, long a) {
    setPinUnsigned("InputA", a);
    setPinUnsigned("Op", op);
    run();
    a = a & 0xFF;
    String message = String.format("0x%x %s", a, name);
    Assert.assertEquals(message, ((a << 8)), readPinUnsigned("Output"));
    Assert.assertFalse(message + " overflow", readPin("Overflow"));
  }

  @Test
  public void testLui() {
    verifyLogicLui("lui", OpCodes.LUI, 0xFF00);
  }
  
  @Test
  public void testLui1() {
    verifyLogicLui("lui", OpCodes.LUI, 0xA843);
  }

  @Test
  public void testLui2() {
    verifyLogicLui("lui", OpCodes.LUI, 0x0000);
  }

  @Test
  public void testLui3() {
    verifyLogicLui("lui", OpCodes.LUI, 0xFFFF);
  }

  @Test
  public void testLui4() {
    verifyLogicLui("lui", OpCodes.LUI, 0xD5A2);
  }
}
