//import javax.swing.JOptionPane;
//public class ChoosingOption {
//public static void main(String[] args) {
//	int option=JOptionPane.showConfirmDialog(null,
//			"Do you want to change to the first class ticket?");
//	JOptionPane.showMessageDialog(null,"you've chosen: "
//			+ (option==JOptionPane.YES_OPTION?"Yes":"No"));
//	System.exit(0);
//		
//}
//}
// nếu ấn "Cancel" thì kết quả sẽ hiện thị trên màn hình là "No"
import javax.swing.JOptionPane;
public class ChoosingOption{
	public static void main(String[] args) {
		Object[] options= {"i do","i don't"};
		int option=JOptionPane.showOptionDialog(null,"Do you want to the first class ticket?",
                 "you've chosen: ",
				JOptionPane.YES_NO_OPTION,
				 JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[0]);
		if(option==0)
		{
			System.out.println("i do");
		}
		else {
			System.out.println("i don't");
		}
		System.exit(0);
	}
}