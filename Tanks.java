package Model;

public class Tanks extends Parts{

	@Override
	public String toString() {
		return getType() + " | " + " cost: $" + getCost();
	}

	public Tanks(String type, double cost) {
		super(type, cost);
		// TODO Auto-generated constructor stub
	}

}
