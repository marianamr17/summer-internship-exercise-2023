package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  //public SnailShellPatternTest() {
  public Future<int[]> SnailShellPatternTest() {
	  SnailShellPattern caracol = new SnailShellPattern();
	  int[][] matrix = { { 1, 2, 3, 4, 5, 6, 7 }, { 8, 9, 10, 11, 12, 13, 14 }, { 15, 16, 17, 18, 19, 20, 21 },
				{ 22, 23, 24, 25, 26, 27, 28 }, { 29, 30, 31, 32, 33, 34, 35 }, { 36, 37, 38, 39, 40, 41, 42 },
				{ 43, 44, 45, 46, 47, 48, 49 } };
		  Future<int[]> v = caracol.getSnailShell(matrix);
		  return v;
}


  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }
	
@Test
public void ScreenLockinPatternTestFirst5Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { 
      { 1, 2, 3, 4, 5 }, 
      { 16, 17, 18, 19, 6 }, 
      { 15, 24, 25, 20, 7 }, 
      { 14, 23, 22, 21, 8 }, 
      { 13, 12, 11, 10, 9 } 
    };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25 };
    assertArrayEquals(result, expected);
}

}
