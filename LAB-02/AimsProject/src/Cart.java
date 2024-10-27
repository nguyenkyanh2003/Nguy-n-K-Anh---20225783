
public class Cart {
  public static final int MAX_NUMBERS_ORDERED = 20;
  private DigitalVideoDisc itemOrdered[]=
		  new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
  private int qtyOrdered;
  public void addDigitalVideoDisc( DigitalVideoDisc d)
  {
	  if(qtyOrdered < MAX_NUMBERS_ORDERED ) {
		  itemOrdered[ qtyOrdered] = d;
		  qtyOrdered++;
		  System.out.println(d.getTitle() + " Has been added!");
		  
			  
	  }
	  else
	  {
		  System.out.println("Cannot add more DVDs! The cart is almost full .");
		  
	  }
		  
		  
	
  }
  public void removeDigitalVideoDisc(DigitalVideoDisc d)
  {
	  if(itemOrdered[0]== null) {
		  System.out.println("[ERROR] Your cart is empty!");
		  return;
	  }
	  for(int i=0;i<qtyOrdered;i++)
	  {
		 if(itemOrdered[i].equals(d))
		 {
			 for(int j=i;j<qtyOrdered -1;j++)
			 {
				 itemOrdered[j] = itemOrdered[j+1];
			 }
			 itemOrdered[qtyOrdered -1] = null;
			 qtyOrdered --;
			 System.out.println(d.getTitle() + "has been removed!");
			 return ;
		 }
		 
	  }
	  System.out.println("[ERROR] No such DVD exists!");
	  
	  }
  
  public float totalCost()
  {
	  float total = 0.0f;
	  for(int i=0; i < qtyOrdered ;i++)
	  {
		  total+=itemOrdered[i].getCost();
	  }
	  return total;
  }
  public String toString()
  {
	  String s = "";
	  for(int i=0 ;i < qtyOrdered ; i++)
	  {
		  s+=itemOrdered[i].toString();
		  s+="\n";
	  }
	  return s;
  }
  }
  

