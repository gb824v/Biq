package com.att.biq.day18.exam3.junit;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SquareTest
{

	@ParameterizedTest
	@CsvSource(
	{ "10, 10, 20, 20, 100, 40", "10, 20, 20, 21, 10, 22" })
	void testSquareAreaAndPerimeter(int x1, int y1, int x2, int y2, double area, double perimeter)
	{
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Square s = new Square(p1, p2);
		assertEquals(area, s.getArea(), "area");
		assertEquals(perimeter, s.getPerimeter(), "perimeter");
	}

	@ParameterizedTest
	@CsvSource(
	{ "10, 10, 2, 20", "10, 20, 20, 2" })
	void testIllegalSquare(int x1, int y1, int x2, int y2)
	{
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		assertThrows(IllegalSquareInputException.class, () ->
		{
			new Square(p1, p2);
		});
	}

	@ParameterizedTest
	@ValueSource(ints ={ 10, 10, 20, 20, 100, 40 })
	void TestSquareNegative(int x1, int y1, int x2, int y2, double area, double perimeter)
	{
		Point p1 = new Point(x1, y1);
		Point p2 = new Point(x2, y2);
		Square s = new Square(p1, p2);
		assertEquals(area, s.getArea(), "area");
		assertEquals(perimeter, s.getPerimeter(), "perimeter");
	}
}