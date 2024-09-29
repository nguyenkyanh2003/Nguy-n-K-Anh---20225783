import java.util.Scanner;
public class example3 {
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	System.out.println("ban hay nhap n:");
	int n = scanner.nextInt();
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n-i-1;j++)
		{
			System.out.print(" ");
		}
		for(int k=0;k<(2*i+1);k++) {
			System.out.print("*");
		}
		
		System.out.println();
	}
	scanner.close();
}
}
