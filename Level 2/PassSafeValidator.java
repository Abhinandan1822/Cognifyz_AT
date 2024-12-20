import java.util.Scanner;

class PassSafeValidator{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Ask the user to input password
		System.out.println("Enter a password: ");
		String password = scanner.nextLine();


		//Check the strength of the password 
		if(password.length() < 8){
			System.out.println("WEAK: Password must be atleast equal to 8 or more than 8 characters long");
		}
		else if(!password.matches(".*[A-Z].*")){
			System.out.println("WEAK: Password must contain atleast one uppercase letter");
		}
		else if(!password.matches(".*[a-z].*")){
			System.out.println("WEAK: Password must contain atleast one lowercase letter");
		}
		else if(!password.matches(".*[0-9].*")){
			System.out.println("WEAK: Password must contain atleast one number");
		}
		else if(!password.matches(".*[!@#$%^&*()?].*")){
			System.out.println("WEAK: Password must contain atleast one character");
		}
		else{
			System.out.println("STRONG: Your password is secure and safe!");
		}
	}
}