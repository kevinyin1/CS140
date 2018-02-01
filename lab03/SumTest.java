package lab03;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SumTest {	
	public void experiment (File file) {
		try {
			try(Scanner input = new Scanner(new FileReader(file))){
				int sum = 0;
				while(input.hasNextInt()) {
					sum += input.nextInt();
					assert(sum >= 0);
				}	
				System.out.println(sum);	
				
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
