import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;
import static edu.gvsu.dlunit.DLUnit.readPin;

/**
 * Sample test cases for 16-bit set less than circuit
 * <p/>
 * IMPORTANT:  These test cases do *not* thoroughly test the circuit.  You need to
 * re-name this class and add more tests!
 * <p/>
 * Created by kurmasz on 8/8/16 and added to by Collin Turkelson and Meghan Harris 2/16/22.
 */
public class Slt16BitTest {

  public void verify(long a, long b, boolean signed) {

    if (signed) {
      setPinSigned("InputA", a);
      setPinSigned("InputB", b);
    } else {
      setPinUnsigned("InputA", a);
      setPinUnsigned("InputB", b);
    }

    setPin("Signed", signed);
    run();


    ////////////////////////////////////////
    //
    // Check the correctness of the output
    //
    ///////////////////////////////////////
    String message = String.format("%d < %d (%s): ", a, b, signed ? "signed" : "unsigned");
    Assert.assertEquals("Output " + message, a < b, readPin("LessThan"));
  }

  @Test
  public void zero_zero_signed() {
    verify(0, 0, true);
  }

  @Test
  public void zero_one_signed() {
    verify(0, 1, true);
  }

  @Test
  public void one_zero_signed() {
    verify(1, 0, true);
  }

  @Test
  public void zero_negone_signed() {
    verify(0, -1, true);
  }

  @Test
  public void negone_zero_signed() {
    verify(-1, 0, true);
  }

  @Test
  public void one_negone_signed() {
    verify(1, -1, true);
  }

  @Test
  public void negone_one_signed() {
    verify(-1, 1, true);
  }

  @Test
  public void zero_zero_unsigned() {
    verify(0, 0, false);
  }

  @Test
  public void zero_one_unsigned() {
    verify(0, 1, false);
  }

  @Test
  public void one_zero_unsigned() {
    verify(1, 0, false);
  }

  @Test
  public void test_unsigned() {
	  verify(84,96,false);
  }
  
  @Test
  public void test_signed() {
    verify(84, -96, true);
  }

  @Test
  public void test_nonsign() {
	  verify(65534,0,false);
  }

  @Test
  public void test_far_signed() {
	  verify(-32750,0,true);
  }

  @Test
  public void test_border_signed() {
	  verify(-32000,32000,true);
  }

  @Test
  public void test_oppo_border_signed() {
	  verify(32000,-32000, true);
  }

  @Test
  public void test_close_signed() {
	  verify(-32000,-31999, true);
  }

  @Test
  public void test_close_unsigned() {
	  verify(59000,58999, false);
  }

  @Test
  public void test_distance_unsigned() {
	  verify(-20000,-10,true);
  }

  @Test
  public void test_distance_signed() {
	  verify(20000,59000,false);
  }

}

