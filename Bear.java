import java.awt.*;

public class Bear extends Critter {
	private boolean polar;
	private int numOfMoves;

	public Bear(boolean polar) {
		super();
		this.polar = polar;
		this.numOfMoves = 0;
	}

	public Action getMove(CritterInfo info) {
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			numOfMoves++;
			return Action.HOP;
		}
		else {
			numOfMoves++;
			return Action.LEFT;
		}
	}

	public Color getColor() {
		if (isPolar())
			return Color.WHITE;
		else
			return Color.BLACK;
	}

	public String toString() {
		if (numOfMoves % 2 == 0)
			return "/";
		else
			return "\\";
	}

	public boolean isPolar() {
		return polar;
	}

	public void setPolar(boolean polar) {
		this.polar = polar;
	}

}
