import java.util.ArrayList;

public class Tour {

	static int BOARD_SIZE = 8;
	static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
	static int n = 0;
	
	static IntPair[] validMoves = {
			new IntPair(1,-2),
			new IntPair(2,-1),
			new IntPair(2,1),
			new IntPair(1,2),
			new IntPair(-1,2),
			new IntPair(-2,1),
			new IntPair(-2,-1),
			new IntPair(-1,-2)
	};
	
	public static boolean isValidPosition(IntPair pos) {
		if (pos.x < BOARD_SIZE && pos.y < BOARD_SIZE && pos.x >= 0 && pos.y >= 0)
			return true;
		return false;
	}
	
	public static boolean bruteFind(IntPair startingPos, int i) {
		if (i >= BOARD_SIZE*BOARD_SIZE) {
			//System.out.println("FOUND: " + startingPos + " " + i);
			return true;
		}
		if (board[startingPos.x][startingPos.y]!=0)
			return false;
		board[startingPos.x][startingPos.y]=n;
		++n;
		for (IntPair move : validMoves) {
			if (isValidPosition(startingPos.add(move))&&bruteFind(startingPos.add(move),i+1))
				return true;
		}
		board[startingPos.x][startingPos.y]=0;
		--n;
		return false;
	}
	
	public static void main(String[] args) {
		boolean foundSolution = bruteFind(new IntPair(0,0),0);
		if (foundSolution) {
			ArrayList<IntPair> sorted = new ArrayList<IntPair>();
			for (int x = 0; x < BOARD_SIZE; x++) {
				for (int y = 0; y < BOARD_SIZE; y++) {
					IntPair currentPos = new IntPair(x,y);
					int value = board[x][y];
					boolean inserted = false;
					for (int i = 0; i < sorted.size(); i++) {
						IntPair otherPos = sorted.get(i);
						int otherValue = board[otherPos.x][otherPos.y];
						if (value < otherValue) {
							inserted = true;
							sorted.add(i, currentPos);
							break;
						}
					}
					if (!inserted) {
						sorted.add(currentPos);
					}
				}
			}
			
			for (int i = 0; i < sorted.size(); i++) {
				System.out.println(i+1 + "\t" + sorted.get(i).toString() + "\t" + board[sorted.get(i).x][sorted.get(i).y]);
			}
		}else {
			System.out.println("No solution found");
		}
		
	}

}
