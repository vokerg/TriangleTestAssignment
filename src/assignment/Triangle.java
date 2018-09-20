package assignment;

/**
 * Implementation of Triangle class that accepts 3 sides and finds triangle type
 * Equialeral, Isosceles or Scalene. Only possible triangles are taken into
 * consideration and class constructor throws an IllegalArgumentException if one
 * of the sides is less than 0 or one of the sides is less than sum of two other
 * sides.
 * 
 * @author Dmitri.Grecov
 * @see #Triangle(double sideA, double sideB, double sideC)
 * @see #getTriangleType()
 *
 */
public final class Triangle {

	private enum Type {
		SCALENE("Scalene"), ISOSCELES("Isosceles"), EQUAILATERAL("Equailateral");

		private String typeName;

		private Type(String typeName) {
			this.typeName = typeName;
		}

		@Override
		public String toString() {
			return this.typeName;
		}
	}

	private final double sideA;
	private final double sideB;
	private final double sideC;
	private final Type triangleType;

	public double getSideA() {
		return sideA;
	}

	public double getSideB() {
		return sideB;
	}

	public double getSideC() {
		return sideC;
	}

	/**
	 * Returns string representation of triangle type
	 * 
	 * @return Equialeral, Isosceles or Scalene
	 */
	public String getTriangleType() {
		return triangleType.toString();
	}

	/**
	 * Creates a triangle object with 3 given sides.
	 *
	 * @param sideA side A
	 * @param sideB side B
	 * @param sideC side C
	 * @throws IllegalArgumentException if one of the sides is less than 0, or one
	 *                                  of the sides is longer than sum of 2 other
	 *                                  sides
	 */
	public Triangle(double sideA, double sideB, double sideC) {
		super();
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;

		if (!isTrianglePossible()) {
			throw new IllegalArgumentException("Cannot construct valid triangle with given sides");
		}

		this.triangleType = findTriangleType();
	}

	/**
	 * Checks if each side of triangle is more than zero so the triangle is not
	 * degenerated. Also checks if each side of triangle is less than sum of two
	 * other sides.
	 */
	private boolean isTrianglePossible() {
		if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
			return false;
		}
		return (sideA < (sideB + sideC) && sideB < (sideA + sideC) && sideC < (sideA + sideB));
	}

	/**
	 * Returns Triangle.Type for given triangle (SCALENE, EQUILATERAL or ISOSCELES)
	 */
	private Type findTriangleType() {
		Type result = Type.SCALENE;
		if (isEquailateral()) {
			result = Type.EQUAILATERAL;
		} else if (isIsosceles()) {
			result = Type.ISOSCELES;
		}
		return result;
	}

	/**
	 * Checks if all sides are equal
	 */
	private boolean isEquailateral() {
		return (sideA == sideB && sideA == sideC);
	}

	/**
	 * Checks if 2 out of 3 sides are equal
	 */
	private boolean isIsosceles() {
		return (sideA == sideB || sideA == sideC || sideB == sideC);
	}

	@Override
	public String toString() {
		return "Triangle [sideA=" + sideA + ", sideB=" + sideB + ", sideC=" + sideC + ", triangleType=" + triangleType
				+ "]";
	}

}
