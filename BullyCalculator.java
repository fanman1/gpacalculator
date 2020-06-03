//This program is a modification of the original GPA calculator program
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
	
	public static void calculateGPA() {
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
				System.out.println("Nice job being average. Yes that's mean.");
			}
			else if (gradeInClass == 13) {
				System.out.println("Your GPA is the least of your problems.");
				System.out.println("Go study instead.");
				System.exit(0);
			} else if (gradeInClass < 1 || gradeInClass > 13){
				System.out.println("Don't be a jokester, put in a number between 1 and 13.");
				i--;
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
