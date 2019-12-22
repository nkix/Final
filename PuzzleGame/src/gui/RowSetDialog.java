package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RowSetDialog extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField num;
	private JButton ok;
	private int number;
	
	public RowSetDialog() {
		super();
		number = -1;
		
		this.setTitle("set puzzle");
		this.setBounds(600, 500, 350, 150);
		this.setModal(true);
		this.setLayout(null);
		
		JLabel text = new JLabel("Set the number of row/column of this puzzle");
		text.setBounds(20, 10, 300, 20);
		num = new JTextField();
		num.setBounds(20, 30, 300, 20);
		num.setEditable(true);
		ok = new JButton("ok");
		ok.setBounds(120, 70, 70, 20);
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String str = num.getText();
				if(isInteger(str) && Integer.parseInt(str)>=3) {
					number = Integer.parseInt(str);
					dispose();
				}
				else num.setText("");
			}
		});
		
		this.add(text);
		this.add(num);
		this.add(ok);
		
		this.setVisible(true);
	}
	
	public int getRowNum() {
		return number;
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
