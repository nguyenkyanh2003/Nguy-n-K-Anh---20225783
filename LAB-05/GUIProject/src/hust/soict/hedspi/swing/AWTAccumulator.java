package hust.soict.hedspi.swing;

import java.awt.Frame;// tao cua so ung dung
import java.awt.GridLayout; //su dung bo cuc dang luoi de sap xep cac thanh phan giao dien
import java.awt.Label; // hien thi cac van ban tinh
import java.awt.TextField; // cho phep nhap va hien thi van ban
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;// xu ly sk khi nhap dl


public class AWTAccumulator extends Frame {
private TextField tfInput;
private TextField tfOutput;
private int sum = 0;
public AWTAccumulator() {
 setLayout(new GridLayout(2,2));//giao dien duoi dang luoi 2x2
 add(new Label("Enter an Integer: "));// hang 1 nhan va nhap so nguyen
 // nhap input
 tfInput = new TextField(10);
 add(tfInput);
tfInput.addActionListener(new TFInputListener());
// nhan va hien thi output
 add(new Label("The Accumulated Sum is:"));
 tfOutput = new TextField(10);
 tfOutput.setEditable(false);
 add(tfOutput);
 // dat tieu de size va hien thi cua so
 setTitle("AWT Accumulator");
 setSize(350,120);
 setVisible(true);
 
}
// tao doi tung GUI
public static void main(String[] args) {
	new AWTAccumulator();
}
private class TFInputListener implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent evt)
	{
		int numberIn = Integer.parseInt(tfInput.getText());//chuyen vban nhap vao thanh so nguyen
		sum+= numberIn;
		tfInput.setText("");// xoa nd nhap sau khi xu ly
		tfOutput.setText(sum+"");// hien thi tong trong tfOutput
	}
}
}


