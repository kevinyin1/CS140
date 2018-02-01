package lab03;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScanEx {	
	public void experiment (File file) {
		try {
			try(Scanner input = new Scanner(new FileReader(file))){
				int sum = 0;
				while(input.hasNext()) {
					if (input.hasNextInt()) {
						int i = input.nextInt(); 
						sum += i;
						System.out.println(i + " -> " + sum);
					} else System.out.println("Clearing line: " + input.next());
				}
			}
		} catch(InputMismatchException e) {
			System.out.println(e + "--not a number from nextInt()");
		} catch(NoSuchElementException ex) {
			System.out.println(ex);
			System.out.println(ex.getMessage());
			System.out.println(ex + "--nothing left in file");
		} catch(FileNotFoundException e) {
			System.out.println("File " + file.getName() + " is not found");
		} catch(Exception ex) {
			ex.printStackTrace();
		}	
	}
	
	public static void main(String[] args) {
		new ScanEx().experiment(new File(args[0]));
	}
}
