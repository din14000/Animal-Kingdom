import java.awt.*;

public class NinjaCat extends Critter {
	private boolean didInfect;

	public NinjaCat() {
		super();
		this.didInfect = false;
	}

	// NinjaCat will turn LEFT if he hits a wall from FRONT or RIGHT. if he hits
	// another NinjaCat from he will turn RIGHT. He will INFECT anyone from the
	// FRONT and from the BACK. Otherwise he will HOP.
	public Action getMove(CritterInfo info) {
		if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
			return Action.LEFT;
		else if (info.getFront() == Neighbor.SAME)
			return Action.RIGHT;
		else if (info.frontThreat() || info.backThreat()) {
			didInfect = true;
			return Action.INFECT;
		} else
			return Action.HOP;

	}

	// NinjaCat turns from BLACK to GREY after he infects anyone.
	public Color getColor() {
		return didInfect ? Color.GRAY : Color.BLACK;

	}

	public String toString() {
		return didInfect ? "!" : "?";
	}

}
