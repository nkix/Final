package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import puzzleModel.Puzzle;

public class Controller {
	
	private Puzzle puzzle;
	private View view;
	private JMenuBar menuBar;
	private JMenuItem restart;
	
	public Controller() {
		RowSetDialog dialog= new RowSetDialog();
		while(dialog.getRowNum()==-1) {}
		
		view = new View(dialog.getRowNum());
		
		while(view.getNumofRow()==-1) {}
		
		puzzle = new Puzzle(view.getNumofRow());
		
		initViewButtons();
		
		JFrame frame = new JFrame();
		menuBar = new JMenuBar();
		restart = new JMenuItem("restart");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RowSetDialog dialog1= new RowSetDialog();
				while(dialog1.getRowNum()==-1) {}
				view.resetPuzzle(dialog1.getRowNum());
				frame.setSize(100*view.getNumofRow(), 100*view.getNumofRow());
				initViewButtons();
				puzzle = new Puzzle(dialog1.getRowNum());
			}
		});
		menuBar.add(restart);
		
		frame.add(menuBar, BorderLayout.NORTH);
		frame.setBounds(300, 400, 100*view.getNumofRow(), 100*view.getNumofRow());
		
		frame.getContentPane().add(view, BorderLayout.CENTER);
		frame.setVisible(true);
		
	}
	
	private void initViewButtons() {
		view.initButtons(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] str = ((JButton)e.getSource()).getName().split(",");
				int row = Integer.parseInt(str[0]);
				int col = Integer.parseInt(str[1]);
				view.popSetNum(row, col);
				puzzle.setNum(row, col, view.getNumAtButton(row, col));
				if(puzzle.isFilled()) {
					view.popWinInfo(puzzle.isMagicSquare());
				}
			}
		});
	}
	
	public static void main(String[] args) {
		Controller con = new Controller();
	}
	
	

}
