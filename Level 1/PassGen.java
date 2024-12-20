import java.util.Random; // Took its reference from javadoc oracle
import java.util.Scanner;

class PassGen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		//Ask the user to input the desired password length 
		System.out.println("Enter the desired password length: ");
		int length = scanner.nextInt();	

		//Define possible characters for the password
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz" + "0123456789" + "!@#$%^&*()";

		StringBuilder pw = new StringBuilder();

		//Randomly pick characters to build the password 
		for (int i=1; i<=length; i++) {
			int index = random.nextInt(chars.length());
			pw.append(chars.charAt(index));
		}

		//Display the generate password
		System.out.println("your random password is:"+pw);

		scanner.close();
	}
}