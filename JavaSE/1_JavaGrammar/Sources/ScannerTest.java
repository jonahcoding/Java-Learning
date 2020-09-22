import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//int i = input.nextInt();
		// int d = input.nextDouble();
		//boolean b = input.nextBoolean();
		String s = input.next();

		System.out.println("Value: " + s);
	}
}