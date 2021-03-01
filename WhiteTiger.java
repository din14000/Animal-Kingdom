import java.awt.*;

public class WhiteTiger extends Critter {
	private boolean didInfect;

	public WhiteTiger() {
		super();
		this.didInfect = false;
	}

	public Action getMove(CritterInfo info) {
		if (info.frontThreat()) {
			didInfect = true;
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		} else {
			return Action.HOP;
		}
	}

	public Color getColor() {
		return Color.WHITE;
	}

	public String toString() {
		if (didInfect == false)
			return "tgr";
		else
			return "TGR";
	}

}
