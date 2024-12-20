import java.util.Scanner;

class PalindromeChecker{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Ask the user for input as word or phrase
		System.out.println("Enter a word or phrase: ");
		String input = scanner.nextLine();

		//Clean up the input: remove spaces and special characters , and convert to lowercase
		String clInp = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
		System.out.println("Initial Input: "+clInp);

		//Now Reverse the cleaned String
		String revInp = new StringBuilder(clInp).reverse().toString();
		System.out.println("Reversed Input: "+revInp);

		//Compare the cleaned string with reversed string
		if(clInp.equals(revInp)){
			System.out.println("Its a Palindrome");
		} 
		else{
			System.out.println("Not a Palindrome");
		}
		scanner.close();

	}
}