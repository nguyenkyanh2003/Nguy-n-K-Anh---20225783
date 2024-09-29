import java.util.Scanner;
public class example225 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("Nhap hai so a va b:");
	double a = scanner.nextDouble();
	double b = scanner.nextDouble();
	double sum=a+b;
	System.out.println("Tong a + b = "+sum);
	scanner.close();
}
}
