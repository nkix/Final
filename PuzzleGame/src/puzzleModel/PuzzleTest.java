package puzzleModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PuzzleTest {
	
	private Puzzle p1;
	private Puzzle p2;
	
	@BeforeEach
	void setUp() throws Exception {
		p1 = new Puzzle(3);
		p2 = new Puzzle(5);
		
	}

	@Test
	void testIsMagicSquare() {
		p1.setNum(0, 0, 2);
		p1.setNum(0, 1, 7);
		p1.setNum(0, 2, 6);
		p1.setNum(1, 0, 9);
		p1.setNum(1, 1, 5);
		p1.setNum(1, 2, 1);
		p1.setNum(2, 0, 4);
		p1.setNum(2, 1, 3);
		p1.setNum(2, 2, 8);
		
		assertEquals(true, p1.isMagicSquare());
		
		for(int r=0; r<2; r++) {
			for(int c=0; c<3; c++) {
				p1.setNum(r, c, 3);
			}
		}
		p1.setNum(2, 0, 1);
		p1.setNum(2, 1, 2);
		p1.setNum(2, 2, 3);
		
		assertEquals(false, p1.isMagicSquare());
		
	}

	@Test
	void testIsFilled() {
		for(int r=0; r<3; r++) {
			for(int c=0; c<3; c++) {
				p1.setNum(r, c, 1);
			}
		}
		assertEquals(true, p1.isFilled());
		
		p2.setNum(0, 1, 2);
		assertEquals(false, p2.isFilled());
	}

}
