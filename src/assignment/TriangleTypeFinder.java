package assignment;

public class TriangleTypeFinder {

	/**
	 * Command-line tool builts a triangle based on 3 numeric arguments read from
	 * application parameters and prints triangle type to console. The application
	 * prints the error message if the number of arguments is not equal to 3 or
	 * arguments are not numeric.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.err.println("The program should be run with exactly 3 numeric parameters");
			return;
		}

		try {
			double sideA = Double.parseDouble(args[0]);
			double sideB = Double.parseDouble(args[1]);
			double sideC = Double.parseDouble(args[2]);

			Triangle triangle = new Triangle(sideA, sideB, sideC);
			System.out.println(triangle.getTriangleType());
		} catch (NumberFormatException e) {
			System.err.println("All 3 parameters should be numeric");
		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}
	}

}
