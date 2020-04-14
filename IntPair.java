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
	
	public IntPair add(IntPair other) {
		return new IntPair(x+other.x, y+other.y);
	}
	
	@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //got this from: https://stackoverflow.com/questions/8180430/how-to-override-equals-method-in-java
        if (!IntPair.class.isAssignableFrom(obj.getClass())) {
            return false;
        }
        final IntPair other = (IntPair) obj;
        if (this.x != other.x) {
            return false;
        }
        if (this.y != other.y) {
            return false;
        }
        return true;
    }
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
