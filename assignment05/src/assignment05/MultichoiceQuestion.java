package assignment05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultichoiceQuestion extends Question {

	private List<String> choices = new ArrayList<String>();
	private List<Integer> correctChoices = new ArrayList<Integer>();

	public MultichoiceQuestion(String qText) {
		super(qText, "");
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

	@Override
	public boolean checkAnswer(String response) {
		int correct = 0, incorrect = 0;
		List<Integer> list = new ArrayList<Integer>();
		for(String answer: response.split(" ")) {
			Integer ans = Integer.parseInt(answer);
			if(!list.contains(ans))
				list.add(ans);
		}
		for(Integer answer: list) {
			if(correctChoices.contains(answer)) {
				correct++;
				continue;
			}
			incorrect++;
		}
		System.out.println("Correct: " + correct + ", Incorrect: " + incorrect);
		return (correct == correctChoices.size() && incorrect == 0); 
	}
	
	
	@Override
	public void presentQuestion() {
		display();
		System.out.println("Your answer (if more than one, seperate answers by spaces):");
		try(Scanner sc = new Scanner(System.in)) {
			System.out.println(checkAnswer(sc.nextLine()));
		}
	}
	
}
