/*import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.att.biq.day9.game.rectangle.Point;

// it's not a real java file!
// just the solution with all classes inside

// JUnit 5

class SquareTest {
	
	@ParameterizedTest
	@CsvSource({"10, 10, 20, 20, 100, 40", "10, 20, 20, 21, 10, 22"})
	void testSquareAreaAndPerimeter(int x1, int y1, int x2, int y2, double area, double perimeter) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Square s = new Square(p1, p2);
		assertEquals(area, s.getArea(), "area");
		assertEquals(perimeter, s.getPerimeter(), "perimeter");
	}

	@ParameterizedTest
	@CsvSource({"10, 10, 2, 20", "10, 20, 20, 2"})
	void testIllegalSquare(int x1, int y1, int x2, int y2) {
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		assertThrows(IllegalSquareInputException.class,
			() -> {
				new Square(p1, p2);
			});
	}
}

// JUnit 4

@RunWith(Parametrized.class)
class TestSquarePositive {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{10, 10, 20, 20, 100, 40},
				{10, 20, 20, 21, 10, 22}
			}
		);
	}

	private Square s;
	private double area;
	private double perimeter;
	
	TestSquarePositive(int x1, int y1, int x2, int y2, double area, double perimeter) {
		this.s = new Square(new Point(x1, y1), new Point(x2, y2));
		this.area = area;
		this.perimeter = perimeter;
	}
	
	@Test
	void testSquareArea() {
		assertEquals("area", area, s.getArea());
	}

	@Test
	void testSquarePerimeter() {
		assertEquals("perimeter", perimeter, s.getPerimeter());
	}

}

@RunWith(Parametrized.class)
class TestSquareNegative {
	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(
			new Object[][] {
				{10, 10, 2, 20},
				{10, 20, 20, 2}
			}
		);
	}

	private Point p1;
	private Point p2;
	
	TestSquareNegative(int x1, int y1, int x2, int y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2));
	}

	@Test(expected = IllegalSquareInputException.class)
	void testIllegalSquare() {
		new Square(p1, p2);
	}

}*/