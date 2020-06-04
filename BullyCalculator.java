//This program is a modification of the original GPA calculator program V.2.0
import java.util.Scanner;

public class BullyCalculator {

	static Scanner keyboard = new Scanner(System.in);
	static double creditsForClass;
	static int courseType;
	static int numberOfClasses;
	static int gradeInClass;
	static double sumCalculation;
	static double totalCredits;
	static double GPA;
	static double defaultWeight;
	static double actualWeight;
	static boolean isValid;
	static int answer1;
	static double answer2;
	
	public static void validateInput(String startingQuestion, String errorMessage, String errorMessageTwo, String validDataType, double lowerBound, double upperBound) {
		do {
			System.out.print(startingQuestion + "\n> ");
			if (validDataType.equals("int")) {
				if (keyboard.hasNextInt()) {
					answer1 = keyboard.nextInt();
					isValid = true;
					if (!(answer1 >= lowerBound && answer1 <= upperBound)) {
						System.out.print(errorMessage + "\n");
						isValid = false;
					}
				}
				else {
					System.out.println(errorMessageTwo);
					isValid = false;
					keyboard.next();
				}
			}
			else if (validDataType.equals("double")) {
				if (keyboard.hasNextDouble()) {
					answer2 = keyboard.nextDouble();
					isValid = true;
					if (!(answer2 >= lowerBound && answer2 <= upperBound)) {
						System.out.print(errorMessage + "\n");
						isValid = false;
					}
				}
				else {
					System.out.println(errorMessageTwo);
					isValid = false;
					keyboard.next();
				}
			}
		} while (!isValid);
	}
	
	public static void calculateGPA() {
		validateInput("How many classes are you taking?", "No one outpizzas the hut! Try again.", "Invalid input. Put in a number.", "int", 5 , 8 );
		numberOfClasses = answer1;
		for (int i = 1; i <= numberOfClasses; i++) {
			System.out.println("Class " + i + ":");
			validateInput("How many credits is this class?", "Don't try to trick me. Type in how many credits the class is really worth.", "Invalid input. Put in a number.", "double", 2.5 , 7 );
			creditsForClass = answer2;
			validateInput("What is the course difficulty?\nOptions: \n1. Academic \n2. Honors \n3. AP ", "I have a suspicion that this kind of class does not exit.", "Invalid input. Put in a number.", "int", 1, 3);
			courseType = answer1;
			validateInput("what was your grade in this class?\nOptions: \n1. A+ \n2. A \n3. A- \n4. B+ \n5. B \n6. B- \n7. C+ \n8. C \n9. C- \n10. D+ \n11. D \n12. D- \n13. U ","I'm sure you know how to type in numbers. Type in a valid number.","Invalid input. Put in a number.", "int", 1, 13 );
			gradeInClass = answer1;
			if (gradeInClass == 1) {
				System.out.println("You are average.");
			}
			else if (gradeInClass == 13) {
				System.out.println("Your GPA is the least of your problems.");
				System.out.println("Go study instead.");
				System.exit(0);
			}
			double actualWeight = Math.round((-(0.33333) * (gradeInClass - 1) + (10.0/3 + (7.0*courseType)/6 - (courseType*courseType)/6.0)) * 100.0) / 100.0;
			sumCalculation = sumCalculation + creditsForClass * actualWeight;
			totalCredits = totalCredits + creditsForClass;
		}
		GPA = Math.round((sumCalculation / totalCredits) * 100.0) / 100.0;
		System.out.println("Your GPA is " + GPA + "!");	
	}
	
	public static void main (String[] args) {
		System.out.println("Welcome to the BRHS GPA Calculator!");
		BullyCalculator.calculateGPA();
	}
	
}
