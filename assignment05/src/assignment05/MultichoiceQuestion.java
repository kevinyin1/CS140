package assignment05;

import java.util.ArrayList;
import java.util.List;

public class MultichoiceQuestion extends Question {

	private List<String> choices = new ArrayList<String>();
	private List<Integer> correctChoices = new ArrayList<Integer>();

	public MultichoiceQuestion(String qText, List<String> choices, List<Integer> correctChoices) {
		super(qText, "");
		this.choices = choices;
		this.correctChoices = correctChoices;
	}

	public void addChoice(String choice, boolean correct) {
		choices.add(choice);
		if (correct) {
			correctChoices.add(choices.size());
		}
	}

	public void display() {
		// Display the question text
		super.display();
		// Display the answer choices
		for (int i = 0; i < choices.size(); i++) {
			System.out.println((i+1) + ": " + choices.get(i));     
		}
	}
	
}
