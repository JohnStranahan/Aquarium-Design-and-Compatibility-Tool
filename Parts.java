package Model;

public class Parts {

	@Override
	public String toString() {
		return  type + ", cost:" + cost;
	}
	private String type;
	private double cost;
	public Parts(String type, double cost) {
		super();
		this.type = type;
		this.cost = cost;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
