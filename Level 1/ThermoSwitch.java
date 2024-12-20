import java.util.Scanner;

class ThermoSwitch{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//Ask the user to input the temperature value
		System.out.println("Enter the temperature value: ");
		double temper = scanner.nextDouble();

		//Ask the user to input the unit of temperature(Celsius or Fahrenheit)
		System.out.println("Enter the unit(C for Celsius, F for Fahrenheit): ");
		char unit = scanner.next().toUpperCase().charAt(0);

		//User will perform the conversion based on chosen unit
		if(unit=='C') {
			double f = (temper * 9/5)+32;
			System.out.println(temper + "°C is equal to " + f + "°F");
		} 
		else if (unit=='F') {
			double c = (temper - 32)*5/9;
			System.out.println(temper + "°F is equal to" + c + "°C");
		}
		else{
			System.out.println("Invalid Unit Entered. ");
		}
		scanner.close();
	}
}