package Model;

import java.awt.image.BufferedImage;

public class Animal{

	@Override
	public String toString() {
		return  type + ", cost:" + cost;
	}

	private String type;
	private double cost;
	private BufferedImage cardImage;
	
	public Animal(String type, double cost, BufferedImage cardImage) {
		this.type = type;
		this.cost = cost;
		this.cardImage = cardImage;
	}
	
	
	public BufferedImage getCardImage() {
		return cardImage;
	}


	public void setCardImage(BufferedImage cardImage) {
		this.cardImage = cardImage;
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

