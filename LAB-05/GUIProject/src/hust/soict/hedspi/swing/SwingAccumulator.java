package hust.soict.hedspi.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
// ke thua JFrame trong swing
public class SwingAccumulator extends JFrame {
 private JTextField tfInput;
 private JTextField tfOutput;
 private int sum  = 0; // tong sum de hien thi
 // tao dao dien GUI
 public SwingAccumulator()
 {
	 Container cp = getContentPane();//Lấy content-pane của container cấp cao nhất.
	 cp.setLayout(new GridLayout(2,2));//Thiết lập bố cục của content-pane là GridLayout.
	 cp.add(new JLabel("Enter an Integer: "));// Thêm thành phần đầu tiên vào content-pane, một JLabel ẩn danh.
	 //Thêm một thành phần JTextField vào content-pane, nơi người
	 //dùng sẽ nhập giá trị. Gắn một listener để lấy thành phần JTextField này làm nguồn.
	 tfInput = new JTextField(10);
	 cp.add(tfInput);
	 tfInput.addActionListener(new TFInputListener());
	 
	 cp.add(new JLabel("The Accumulated Sum is: "));//Thêm một JLabel ẩn danh khác vào content-pane
//	 Thêm một thành phần JTextField vào content-pane,
//	 nơi hiển thị tổng tích lũy của các giá trị đã nhập. 
//	 Thành phần này được đặt ở chế độ chỉ đọc trong dòng 27.
	 tfOutput = new JTextField(10);
	 tfOutput.setEditable(false);
	 cp.add(tfOutput);
	 //tao tieu de size va hien thi
	 setTitle("Swing Accumulator");
	 setSize(350,120);
	 setVisible(true);
	 
	 
	 
 }
 public static void main(String[] args) {
	new SwingAccumulator();
}
 private class TFInputListener implements ActionListener{
	 public void actionPerformed(ActionEvent evt)
	 {
		 int numberIn  = Integer.parseInt(tfInput.getText());
		 sum+= numberIn;
		 tfInput.setText("");
		 tfOutput.setText(sum+"");
	 }
 }
}
