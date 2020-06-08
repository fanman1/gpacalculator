import java.util.*;

public class GpaCalculator{
    static Scanner keyboard = new Scanner(System.in);
    static int classNumber;
    static double totalCreditsAttempted, GPA;
    static double totalGradePoints = 0;
    static int[] gradePositions;
    static double totalPoints[];
    static Map<String,Double> mapGrades = new HashMap<>();

    //HashMap.get(mapGrades);
    static double gpaWeight[] = {4.33333, 4.00, 3.66667, 3.33333, 3.00, 2.66667, 2.33333, 2.00, 1.66667, 1.33333, 1.00, 0.66667, 0.00};
    static String grades[] = {"A+", "A", "A-","B+","B","B-", "C+", "C", "C-", "D+", "D", "D-", "U" };
    //corresponding grade and GPA grade points, for Academic classes
    //weighting for Honors and AP are accounted for in other code; +1.00 for AP, +0.67 for Honors
    static int ethnicityHold;
    static double creditsHold;
    static String[] arrayGrades;//letter grade for each class
    static double[] arrayCredits;//credits for that course
    static int[]  classType;//stores academic, honors, or ap

    public static void initialize() {
        System.out.println("How many classes are you submitting?: ");
        /*mapGrades.put("bruh",3.0);
        mapGrades.get("bruh");*/
        classNumber = keyboard.nextInt();
        arrayGrades = new String[classNumber];
        arrayCredits = new double[classNumber];
        classType = new int[classNumber];
        totalPoints = new double[classNumber];
        gradePositions = new int[classNumber];//stores positions of arrayGrades so that calculating total grades points is easier.
        //the grade position corresponds to GPA weighting
        for(int i=0; i<gpaWeight.length; i++){
            mapGrades.put(grades[i],gpaWeight[i]);
        }
    }

    public static void askForClassesAndGrades(){
        for(int i =0; i<classNumber; i++){
            System.out.println("Please choose the " + (i+1) + " class's type: \n1. Academic \n2. Honors \n3. AP \n> ");
            classType[i] = keyboard.nextInt();
            System.out.print("Enter final grade for that class: ");
            arrayGrades[i] = keyboard.next();
            System.out.print("How many credits is this class?: \n1. 5.0 \n2. 2.5 \n3. 4.0 \n4. 6.0 \n>");
            creditsHold = keyboard.nextDouble();
            if(creditsHold==1){
                arrayCredits[i] = 5.0;
            }
            else if(creditsHold==2){
                arrayCredits[i] = 2.5;
            }
            else if(creditsHold==3){
                arrayCredits[i] = 4.0;
            }
            else if(creditsHold==4){
                arrayCredits[i] = 6.0;
            }

            if((creditsHold!=1 && creditsHold!=2 && creditsHold!=3 && creditsHold!=4) || (classType[i]!=1 && classType[i]!=2 && classType[i]!=3)){
                System.out.println("Oops! Looks like you put a wrong number! Please reinput your information for the previous class.");
                i--;
            }

        }
    }


    public static void gradeIndex(){
        //will show index of grade in grades[] array
        for(int i=0; i<arrayGrades.length; i++){
            for(int x=0; x<grades.length; x++){

                if(arrayGrades[i].equals(grades[x])){
                    gradePositions[i] = x;
                    if(x>5){
                        System.out.println("LOL your grades are TRASH. Why are u calculating your GPA LOL GO STUDY INSTEAD");
                        System.exit(0);
                    }
                    break;
                }
                    
            }
        }
    }

    public static double getTotalGradePoints(){
        for(int i=0; i<arrayCredits.length; i++){
            switch(classType[i]) {
                case 1:
                    totalPoints[i] = gpaWeight[gradePositions[i]] * arrayCredits[i];
                    break;

                case 2:
                    totalPoints[i] = (gpaWeight[gradePositions[i]] + 0.67) * arrayCredits[i];
                    break;

                case 3:
                    totalPoints[i] = (gpaWeight[gradePositions[i]] + 1.00) * arrayCredits[i];
                    break;
            }

        }
        return DoubleStream.of(totalPoints).sum();
    }


    public static double getTotalCredits(){
        for(int i=0; i<arrayCredits.length; i++){
            totalCreditsAttempted+=arrayCredits[i];
        }
        return totalCreditsAttempted;
    }


    public static double calculateFinalGPA(){
        GPA = totalGradePoints/totalCreditsAttempted;
        return GPA;
    }

    public static void ethnicity(){
        System.out.print("Please enter your ethnicity: \n1. Chinese \n2. Korean \n3. Indian \n4. Caucasian \n> ");
        ethnicityHold = keyboard.nextInt();
        if(ethnicityHold==1 || ethnicityHold==2 || ethnicityHold==4){
            System.out.println("A little sus, but you pass.");
        }
        else if (ethnicityHold==3){
            System.out.println("We will lower your GPA by 0.5 to account for cheating :)");
        }
        else{
            System.out.println("Don't be shy. Reveal your ethnicity or we will lower your GPA by 0.5");
            GpaCalculator.ethnicity();
        }
    }

    public static void main(String args[]){
        System.out.print("Welcome to the BRHS GPA Calculator!\n");
        GpaCalculator.ethnicity();
        System.out.print("Please enter the grades that you definitely cheated for!\n");
        GpaCalculator.initialize();
        GpaCalculator.askForClassesAndGrades();
        GpaCalculator.gradeIndex();
        GpaCalculator.getTotalGradePoints();
        GpaCalculator.getTotalCredits();
        System.out.println("Your GPA is " + GpaCalculator.calculateFinalGPA() + "!");
        System.out.println("It's decent, but I'm sorry to say that it's NOT GOOD ENOUGH!");
    }
}
