import java.awt.*;

public class Giant extends Critter {
	private int numOfMoves;
	private String currString;

	public Giant() {
		super();
		this.numOfMoves = 0;
		currString = "fee";
	}

	public Action getMove(CritterInfo info) {
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			numOfMoves++;
			return Action.HOP;
		} else {
			numOfMoves++;
			return Action.RIGHT;
		}
	}

	public Color getColor() {
		return Color.GRAY;
	}

	public String toString() {
		if (numOfMoves < 6) {
			currString = "fee";
			return currString;
		}
		if (numOfMoves == 6) {
			currString = "fie";
			return currString;
		} else if (numOfMoves == 12) {
			currString = "fum";
			return currString;
		} else if (numOfMoves == 18) {
			numOfMoves = 0;
			currString = "fee";
		}
		return currString;
	}

}
