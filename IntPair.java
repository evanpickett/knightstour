/**
 * IntPair
 * Utility class used for making our lives easier
 * Can hold an x and y value, which is easy to get from a chess board
 */
public class IntPair {
	public int x;
	public int y;
	
	public IntPair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public IntPair() {
		x = 0;
		y = 0;
	}
}
