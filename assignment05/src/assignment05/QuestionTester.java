package assignment05;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class QuestionTester {

	@Test
	void testChoiceQuestion() {
		ChoiceQuestion cquestion = new ChoiceQuestion("What is your favorite ice cream flavor?");
		cquestion.addChoice("Vanilla", false);
		cquestion.addChoice("Chocolate", true);
		cquestion.addChoice("Strawberry", false);
		cquestion.addChoice("Chocolate Chip", false);
		assertTrue(cquestion.checkAnswer("2"));
		assertFalse(cquestion.checkAnswer("3"));
	}

	@Test
	void testMultiplechoiceQuestion() {
		MultichoiceQuestion mquestion = new MultichoiceQuestion("Which are fruits?");
		mquestion.addChoice("Apple", true);
		mquestion.addChoice("Potato", false);
		mquestion.addChoice("Tomato", true);
		mquestion.addChoice("Tangerine", true);
		mquestion.addChoice("All Above", false);
		assertTrue(mquestion.checkAnswer("1 3 4 1 3 4"));
		assertFalse(mquestion.checkAnswer("1 1 3 2 4 3 2 5 1"));
	}
	
}
