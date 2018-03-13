package assignment05;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PizzaTester {

	@Test
	void testMediumTopping() {
		Pizza pizza = new MediumCheesePizza();
		pizza = new Pineapple(pizza);
		pizza = new Pepperoni(pizza);
		assertEquals(10.8, pizza.getCost(), 1E-6);
	}

	@Test
	void testSmallTopping() {
		Pizza pizza = new SmallCheesePizza();
		pizza = new Mushroom(pizza);
		pizza = new GreenPeppers(pizza);
		pizza = new Pepperoni(pizza);
		assertEquals(8.45, pizza.getCost(), 1E-6);
	}
	
}
