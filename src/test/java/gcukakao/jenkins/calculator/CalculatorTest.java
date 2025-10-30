package gcukakao.jenkins.calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private final Calculator calculator = new Calculator();

	@Test
	void testSum() {
		assertEquals(5, calculator.sum(2, 3));
	}

	@Test
	void testSub() {
		assertEquals(-3, calculator.sub(3, 6));
	}

	@Test
	void testMul() {
		assertEquals(10, calculator.mul(2, 5));
	}

	@Test
	void testDiv() {
		assertEquals(6, calculator.div(12, 2));
	}
}