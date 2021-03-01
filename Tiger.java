import java.awt.*;
import java.lang.Math; 

public class Tiger extends Critter {
	private int numOfMoves;
	private Color currColor;

	public Tiger() {
		super();
		this.numOfMoves = 0;
		this.currColor = changeColor();
	}

	public Action getMove(CritterInfo info) {
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			numOfMoves++;
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			numOfMoves++;
			return Action.RIGHT;
		} else {
			numOfMoves++;
			return Action.HOP;
		}
	}

	public Color getColor() {
		if(numOfMoves != 0 && numOfMoves % 3 == 0) {
		 currColor = changeColor();
		}
		return currColor;
	}

	public String toString() {
		return "TGR";
	}

	private Color changeColor() {
		int rand = (int) (Math.random() * 3);
		if (rand % 3 == 0)
			return Color.GREEN;
		else if (rand % 3 == 1)
			return Color.BLUE;
		else
			return Color.RED;
	}

}
