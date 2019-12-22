package gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton[][] numbers;
	
	private int number;
	
	public View(int num) {
		
		number = num;
		
		if(number != -1) {		//means number is already set
			this.setBounds(300, 400, 100*number, 100*number);
			this.setPuzzle(number);			
		}
	}
	
	private void setPuzzle(int num) {
		this.setLayout(new GridLayout(num, num));
		numbers = new JButton[num][num];
		for(int r=0; r<num; r++) {
			for(int c=0; c<num; c++) {
				numbers[r][c] = new JButton();
				numbers[r][c].setName(r+","+c);
				this.add(numbers[r][c]);
			}
		}
	}
	
	public void resetPuzzle(int num) {
		this.removeAll();
		setPuzzle(num);
		this.number = num;
		this.setSize(100*number, 100*number);
	}
	
	public int getNumofRow() {
		return number;
	}
	
	public int getNumAtButton(int row, int col) {
		return Integer.parseInt(numbers[row][col].getText());
	}
	
	public void initButtons(ActionListener listener) {
		for(int r=0; r<number; r++) {
			for(int c=0; c<number; c++) {
				numbers[r][c].addActionListener(listener);
			}
		}
	}
	
	public void popSetNum(int row, int col) {
		
		JDialog setNum2 = new JDialog();
		setNum2.setBounds(600, 500, 350, 150);
		setNum2.setModal(true);
		setNum2.setLayout(null);
		
		JLabel text = new JLabel("put a number here");
		text.setBounds(20, 10, 300, 20);
		JTextField num2 = new JTextField();
		num2.setBounds(20, 30, 300, 20);
		num2.setEditable(true);
		JButton ok2 = new JButton("ok");
		ok2.setBounds(120, 70, 70, 20);
		ok2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = num2.getText();
				if(isInteger(str)) {
					numbers[row][col].setText(str);
					setNum2.dispose();
				}
				else num2.setText("");
			}
		});
		
		setNum2.add(text);
		setNum2.add(num2);
		setNum2.add(ok2);
		
		setNum2.setVisible(true);
		
	}
	
	public void popWinInfo(boolean isWin) {
		JDialog dialog = new JDialog();
		dialog.setBounds(600, 500, 300, 100);
		dialog.setModal(true);
		dialog.setLayout(new FlowLayout());
		
		JLabel win = new JLabel();
		
		
		if(isWin) {
			dialog.setTitle("Win!");
			win.setText("Congratulations, you have made a magic square!");
		}
		else {
			dialog.setTitle("not a magic square");
			win.setText("This is not a magic square");
		}
		
		dialog.add(win);
		dialog.setVisible(true);
		
	}
	
	private boolean isInteger(String str) {
		if(str == null) {
			return false;
		}
		int length = str.length();
		if(length == 0) {
			return false;
		}
		int i=0;
		if(str.charAt(0) == '-') {
			if(length == 1) {
				return false;
			}
			i=1;
		}
		
		for(; i<length; i++) {
			char c = str.charAt(i);
			if(c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

}
