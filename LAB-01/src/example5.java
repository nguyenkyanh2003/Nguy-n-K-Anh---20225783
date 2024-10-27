import java.util.Arrays;
import java.util.Scanner;
public class example5 {
public static void main(String[] args) {
	Scanner scanner = new Scanner (System.in);
	System.out.println("Nhap so phan tu cua mang:");
	int n = scanner.nextInt();
	int[] a = new int[n];
	System.out.println("Nhap phan tu cua mang:");
	for(int i=0;i<n;i++)
	{
		a[i]=scanner.nextInt();
		
	}
	Arrays.sort(a);
	int sum=0;
	for(int i=0;i<n;i++)
	{
		sum+=a[i];
	}
	double average=(double)sum/n;
	System.out.println("Mang phan tu:"+ Arrays.toString(a));
	System.out.println("Tong:"+sum);
	System.out.println("Gia tri trung binh:"+ average);
	System.exit(0);
}
}
