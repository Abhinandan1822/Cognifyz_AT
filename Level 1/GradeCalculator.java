import java.util.Scanner;

class GradeCalculator{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Ask the use to input the grades
		System.out.println("How many grades do you want to enter ?");
		int numberOfGrades = scanner.nextInt();

		double sum = 0;

		//Use a loop to collect all the grades
		for(int i = 1; i<=numberOfGrades; i++){
			System.out.println("Enter Grades " + i + ": ");
			double grade = scanner.nextDouble();
			sum+=grade; //Add the grade to total

		}
		System.out.println("Sum of all grades: "+sum);

		//Calculate the average of all
		double avg = sum/numberOfGrades;

		//print the average grade
		System.out.println("The average grade is: "+avg);

		//close the scanner
		scanner.close();

	}
}