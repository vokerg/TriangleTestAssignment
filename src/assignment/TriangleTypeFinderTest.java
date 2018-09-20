package assignment;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Unit test for Triangle class. Instanciates Triangle with array of parameters
 * consisting A, B and C side and compares triangle type with expected result
 * (Equialeral, Isosceles or Scalene) or checks if expected exception is thrown
 * 
 * @author Dmitri.Grecov
 * @see Triangle
 */
@RunWith(Parameterized.class)
public class TriangleTypeFinderTest {

	private double sideA;
	private double sideB;
	private double sideC;
	private String expectedResult;
	private Class<? extends Exception> expectedException;

	public TriangleTypeFinderTest(double sideA, double sideB, double sideC, String expectedResult,
			Class<? extends Exception> expectedException) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.expectedResult = expectedResult;
		this.expectedException = expectedException;
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Before
	public void setExpectedException() {
		if (this.expectedException != null) {
			thrown.expect(this.expectedException);
		}
	}

	@Parameters
	public static List<Object[]> generateTestValues() {
		return Arrays.asList(new Object[][] { 
			{ 1.1, 1.1, 1.1, "Equailateral", null }, 
			{ 1, 2, 2, "Isosceles", null },
			{ 3, 3, 1, "Isosceles", null },
			{ 3, 1, 3, "Isosceles", null },
			{ 3.01, 2.99, 3, "Scalene", null },
			{ 5, 1, 1, null, IllegalArgumentException.class },
			{ 1, 1, 5, null, IllegalArgumentException.class },
			{ 1, 2.1, 1, null, IllegalArgumentException.class },
			{ -1, -1, 1, null, IllegalArgumentException.class },
			{ 0, 2, 2, null, IllegalArgumentException.class },
		});
	}

	@Test
	public void test() {
		Triangle triangle = new Triangle(this.sideA, this.sideB, this.sideC);
		String result = triangle.getTriangleType();
		assertEquals(result, this.expectedResult);
	}

}
