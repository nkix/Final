package puzzleModel;

import java.util.ArrayList;

public class Puzzle {
	
	private int[][] puzzle;
	private int num;  //number of row/column
	
	public Puzzle(int num) {
		if(num>=3) {					//the input num should be larger or equal to 3
			puzzle = new int[num][num];
			for(int r=0; r<num; r++) {
				for(int c=0; c<num; c++ ) {
					puzzle[r][c] = -1; //the input num of -1 means it's not set yet
				}
			}
			this.num = num;
		}
		else num=-1;
	}
	
	public void setNum(int row, int col, int num) {
		puzzle[row][col] = num;
	}
	
	private ArrayList<Integer> calcSums() {
		ArrayList<Integer> sums = new ArrayList<Integer>();
		int sum = 0;
		int sum1 = 0;
		
		for(int r=0; r<num; r++) {     //store sum of each row equals
			for(int c=0; c<num; c++) {
				sum += puzzle[r][c];
			}
			sums.add(sum);
			sum = 0;
		}
		
		for(int c=0; c<num; c++) {		//store sum of each column equals
			for(int r=0; r<num; r++) {
				sum += puzzle[r][c];
			}
			sums.add(sum);
			sum=0;
		}
		
		for(int i=0; i<num; i++) {    	//store sum of each diagonals
			sum += puzzle[i][i];
			sum1+= puzzle[i][num-1-i];
		}
		sums.add(sum);
		sums.add(sum1);
		
		return sums;
	}
	
	public boolean isMagicSquare() {
		ArrayList<Integer> sums = calcSums();
		int temp_sum = sums.get(0);
		
		for(int sum:sums) {
			if(sum != temp_sum) return false;
		}
		
		return true;
	}
	
	public boolean isFilled() {
		for(int r=0; r<num; r++) {
			for(int c=0; c<num; c++) {
				if(puzzle[r][c]==-1)return false;
			}
		}
		return true;
	}

}
