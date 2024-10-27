import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class example4 {
   private static final Map<String, Integer> monthMap
   = new HashMap<>();
   static
   {
	   monthMap.put("January", 31);
	   monthMap.put("Jan", 31);
	   monthMap.put("Jan.", 31);
	   monthMap.put("1",31);
	   monthMap.put("February", 28); 
       monthMap.put("Feb", 28);
       monthMap.put("Feb.", 28);
       monthMap.put("2", 28);
       monthMap.put("March", 31);
       monthMap.put("Mar", 31);
       monthMap.put("Mar.", 31);
       monthMap.put("3", 31);
       monthMap.put("April", 30);
       monthMap.put("Apr", 30);
       monthMap.put("Apr.", 30);
       monthMap.put("4", 30);
       monthMap.put("May", 31);
       monthMap.put("5", 31);
       monthMap.put("June", 30);
       monthMap.put("Jun", 30);
       monthMap.put("Jun.", 30);
       monthMap.put("6", 30);
       monthMap.put("July", 31);
       monthMap.put("Jul", 31);
       monthMap.put("Jul.", 31);
       monthMap.put("7", 31);
       monthMap.put("August", 31);
       monthMap.put("Aug", 31);
       monthMap.put("Aug.", 31);
       monthMap.put("8", 31);
       monthMap.put("September", 30);
       monthMap.put("Sep", 30);
       monthMap.put("Sep.", 30);
       monthMap.put("9", 30);
       monthMap.put("October", 31);
       monthMap.put("Oct", 31);
       monthMap.put("Oct.", 31);
       monthMap.put("10", 31);
       monthMap.put("November", 30);
       monthMap.put("Nov", 30);
       monthMap.put("Nov.", 30);
       monthMap.put("11", 30);
       monthMap.put("December", 31);
       monthMap.put("Dec", 31);
       monthMap.put("Dec.", 31);
       monthMap.put("12", 31);
   }
   public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
	String month;
	int year;
	boolean kiemtra = false;
	while(!kiemtra)
	{
		System.out.println("Enter the moth(full name, abbreviation or number): ");
		month = scanner.nextLine().trim();
		System.out.println("Enter the year (non-negative full number): ");
		year = scanner.nextInt();
		scanner.nextLine();
		if(isValidMonth(month)&& isValidYear(year))
		{
			kiemtra=true;
			int days= getDaysInMonth(month,year);
				System.out.println("Number of days in :" +days + "/" + month + "/"+ year);
		}
		else {
			System.out.println("Invalid moth or year. Please try again.");
			
		}
		}
	scanner.close();
	
		
	}
   private static boolean isValidMonth(String a)
   {
	   return monthMap.containsKey(a);
	   
   }
  private static boolean isValidYear(int a)
  {
	  return a>=0;
  }
  private static int getDaysInMonth(String a, int b)
  {
	  int days=monthMap.get(a);
	  if(a.equals("February")||a.equals("Feb")||a.equals("Feb.")
			  || a.equals("2"))
	  {
		  if(isLeapYear(b))
		  {
			  days=29;
		  }
		
		  
	  }
	  return days;
	  
  }
 private static boolean isLeapYear(int b)
 {
	 return (b%4==0 && b%100 !=0)||(b%400==0);
 }
}

