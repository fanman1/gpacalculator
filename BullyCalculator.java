//This program is a modification of the original GPA calculator program
import java.util.Scanner;

public class BullyCalculator {

	Scanner keyboard = new Scanner(System.in);
	double creditsForClass;
	int courseType;
	int numberOfClasses;
	int gradeInClass;
	double sumCalculation;
	double totalCredits;
	double GPA;
	
	public BullyCalculator() {
		
	}
	
	public void calculateGPA() {
		System.out.print("How many classes do you take?\n> ");
		numberOfClasses = keyboard.nextInt();
		for (int i = 1; i <= numberOfClasses; i++) {
			System.out.println("Class " + i + ":");
			System.out.print("How many credits is this class? ");
			creditsForClass = keyboard.nextDouble();
			System.out.println("What is the course difficulty?");
			System.out.print("Options: \n1. Academic \n2. Honors \n3. AP \n> ");
			courseType = keyboard.nextInt();
			System.out.println("What was your grade in this class?");
			System.out.print("Options: \n1. A+ \n2. A \n3. A- \n4. B+ \n5. B \n6. B- \n7. C+ \n8. C \n9. C- \n10. D+ \n11. D \n12. D- \n13. U \n> ");
			gradeInClass = keyboard.nextInt();
			if (gradeInClass == 1) {
				System.out.println("You are average.");
			}
			else if (gradeInClass == 13) {
				System.out.println("Your GPA is the least of your problems.");
				System.out.println("Go study instead.");
				System.exit(0);
			}
			double defaultWeight = 4.33333;
			double actualWeight;
			if (courseType == 2) {
				defaultWeight = defaultWeight + 0.66667;
			}
			else if (courseType == 3) {
				defaultWeight = defaultWeight + 1.00;
			}
			actualWeight = Math.round((-(0.33333) * (gradeInClass - 1) + defaultWeight) * 100.0) / 100.0;
			sumCalculation = sumCalculation + creditsForClass * actualWeight;
			totalCredits = totalCredits + creditsForClass;
		}
		GPA = Math.round((sumCalculation / totalCredits) * 100.0) / 100.0;
		System.out.println("Your GPA is " + GPA + "!");	
	}
	
	public static void main (String[] args) {
		System.out.println("Welcome to the BRHS GPA Calculator!");
		BullyCalculator calculator = new BullyCalculator();
		calculator.calculateGPA();
	}
	
}