import java.io.*;
import java.util.Scanner;

class FileEncryptionDecryption{
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);

		//Ask the user what they want to do: Encrypt or Decrypt
		System.out.println("What you would like to do? Encrypt or Decrypt a file? (Enter E for Encrypt, D for Decrypt: ");
		char userChoice = scanner.next().toUpperCase().charAt(0); //Read the choice (E or D) and handle lowercase input

		//Ask the user for the name of the file
		System.out.println("Please enter the name of the file(with extension, For Eg, file.txt): ");
		scanner.nextLine(); //Consume the leftover newline character
		String fn = scanner.nextLine();//Read the file name

		//Check if the file already exists
		File file = new File(fn);
		if(!file.exists()){
			System.out.println("Oops! The file "+fn+" doesnt exist.");
			return; //Stop the program if the file isnt found
		}

		//Read the contents of the file
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		StringBuilder fileContent = new StringBuilder(); // To store the entire file content
		String currentLine;

		// Read each line from the file and add it to content
		while((currentLine = fileReader.readLine())!=null){
			fileContent.append(currentLine).append("\n");
		}
		fileReader.close(); //Close the reader after reading the file

		//Prepare to store the result after processing
		String result = "";

		//Encrypt or Decrypt based on the user's choice
		if(userChoice=='E'){
			result = processText(fileContent.toString(), 3); //Encrypt : shift letter by 3 positions
			System.out.println("The file has been Encrypted successfully!");
		}
		else if(userChoice=='D'){
			result = processText(fileContent.toString(), -3); //Decrypt: reverse the shift by 3 positions
			System.out.println("The file has been Decrypted successfully!");
		}
		else{
			System.out.println("Invalid Choice. Please restart the program and enter E or D");
			return; //Stop the program if choice is invalid
		}
		// Save the processed content to a new file
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("output.txt"));
        fileWriter.write(result); // Write the encrypted/decrypted text to the output file
        fileWriter.close(); // Close the writer

        System.out.println("The processed content has been saved to a new file: output.txt");
    }

    // Method to process the text (Encrypt or Decrypt) using a simple shift cipher
    private static String processText(String text, int shift) {
        StringBuilder result = new StringBuilder(); // To build the final processed string

        for (char character : text.toCharArray()) {
            // Check if the character is a letter (A-Z or a-z)
            if (Character.isLetter(character)) {
                // Determine whether it's uppercase or lowercase
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                // Shift the letter and wrap around if necessary
                result.append((char) ((character - base + shift + 26) % 26 + base));
            } else {
                // If it's not a letter (e.g., space, number, symbol), leave it as is
                result.append(character);
            }
        }

        return result.toString(); // Return the processed text
    }
}