package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import Model.Animal;
import Model.Deco;
import Model.Fish;
import Model.Parts;
import Model.Plants;
import Model.Tanks;

public class Driver {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		ArrayList<Animal> cart = new ArrayList<Animal>(); // Cart of Fish and Plants
		ArrayList<Parts> cart2 = new ArrayList<Parts>(); // Cart of Decorations and Tanks

		ArrayList<Parts> tankList = new ArrayList<Parts>();
		tankList.add(new Tanks("10 Gallon BioWheel LED Aquarium Kit", 84.99));
		tankList.add(new Tanks("60 Gallon Heartland LED Aquarium with Stand", 369.99));
		tankList.add(new Tanks("Clear-For-Life 55 Gallon Hexagon UniQuarium", 899.99));
		tankList.add(new Tanks("Clear-For-Life 100 Gallon Rectangle UniQuarium", 1299.99));
		tankList.add(new Tanks("Clear-For-Life 300 Gallon Rectangle Aquarium", 3849.99));

		System.out.println("### Welcome to the Extreme Aquariums Design Tool ###");
		System.out.println("####################################################");

		int choice = -99;
		while (choice != 0) {

			System.out.println("Select from the following options: ");
			System.out.println(" ");
			System.out.println("1. Create a Fresh Water Aquarium");
			System.out.println("2. Create a Salt Water Aquarium");
			System.out.println("3. Close Program");

			choice = Integer.parseInt(br.readLine());

			switch (choice) {
			case 1:
				tankSelection(cart, cart2, tankList);
				break;
			case 2:

				break;
			case 3:
				System.out.println("Closing the Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection: try again.");
			}
			System.out.println("");
			choice = 1;
		}

	}

	/**
	 * 
	 * @param cart2
	 * @param tankList
	 * @throws IOException
	 */
	
	private static void tankSelection(ArrayList<Animal> cart, ArrayList<Parts> cart2, ArrayList<Parts> tankList)
			throws IOException {

		System.out.println(" ");
		System.out.println("Fresh Water Design Selected");
		System.out.println(" ");
		System.out.println("To Choose your Tank please Enter its Number Below:");
		System.out.println(" ");
		for (int i = 0; i < tankList.size(); i++) {
			System.out
					.println(i + 1 + ". " + tankList.get(i).getType() + "        Cost: $" + tankList.get(i).getCost());

		}

		int tank = Integer.parseInt(br.readLine());

		///////////////

		for (int i = 0; i < tankList.size(); i++) {

			// System.out.println(tankList.get(i).getType().charAt(0));

			if (tank == i + 1) {
				System.out.println(" ");
				System.out.println("The " + tankList.get(i).getType() + " has been added to the Cart");
				System.out.println(" ");
				cart2.add(tankList.get(i));

			}

		}

		ArrayList<Animal> fishes = new ArrayList<Animal>();
		fishes.add(new Fish("African Cichlid", 124.99, ImageIO.read(new File("AfricanCichlid.png"))));

		ArrayList<Animal> plantList = new ArrayList<Animal>();
		plantList.add(new Plants("Java Fern", 21.99, ImageIO.read(new File("JavaFern.png"))));

		ArrayList<Parts> decoList = new ArrayList<Parts>();
		decoList.add(new Deco("South Castle Aquarium Decor", 48.59));

		freshMenuSelection(cart, cart2, fishes, plantList, decoList);

	}

	/**
	 * 
	 * @param cart
	 * @param fishes
	 * @param plantList
	 * @param tankList
	 * @throws IOException
	 */
	private static void freshMenuSelection(ArrayList<Animal> cart, ArrayList<Parts> cart2, ArrayList<Animal> fishes,
			ArrayList<Animal> plantList, ArrayList<Parts> decoList) throws IOException {
		int choice = -99;
		while (choice != 0) {

			System.out.println("Now Please Select from the following options: ");

			System.out.println("1. Show Available Inventory and Pricing");
			System.out.println("2. Add a Fresh Water Fish to the Cart");
			System.out.println("3. Add a Fresh Water Plant to the Cart");
			System.out.println("4. Add a Fresh Water Decoration to the Cart");
			System.out.println("5. Display content of Cart and Total Price");
			System.out.println("6. Test Aquarium for Issues");
			System.out.println("7. Print Receipt");
			System.out.println("9. Exit the program");
			System.out.print("Make your menu selection now: ");

			choice = Integer.parseInt(br.readLine());
			System.out.println(choice);

			switch (choice) {
			case 1:
				displayInventory(fishes, plantList, decoList);
				break;
			case 2:
				addFishToCart(cart, fishes);
				break;
			case 3:
				addPlantToCart(cart, plantList);
				break;
			case 4:
				addDecoToCart(cart2, decoList);
			case 5:
				displayCart(cart, cart2);
				break;
			case 6:
				testAquarium(cart, cart2);
				break;
			case 9:
				System.out.println("Closing the Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection: try again.");
			}
			System.out.println("");
			choice = 1;
		}

	} // end freshMenuSelection method

	/**
	 * 
	 * @param list
	 * @param fishes
	 * @param plantList
	 * @param tankList
	 * @param decoList
	 */
	private static void displayInventory(ArrayList<Animal> fishes, ArrayList<Animal> plantList,
			ArrayList<Parts> decoList) {

		System.out.println(" ");
		System.out.println("Here Is The Current Inventory:");
		System.out.println(" ");
		System.out.println("	Fish: " + fishes.toString());
		System.out.println("	Plants: " + plantList.toString());
		System.out.println("	Decorations: " + decoList.toString());
		System.out.println(" ");
	}

	/**
	 * 
	 * @param cart
	 */
	private static void displayCart(ArrayList<Animal> cart, ArrayList<Parts> cart2) {
		if (!(cart.isEmpty() && cart2.isEmpty())) {

			System.out.println("The Cart: " + cart.toString());
			System.out.println(cart2.toString());
			System.out.println(" ");
			for (int i = 0; i < cart.size(); i++) {
			
			}
			for (int i = 0; i < cart2.size(); i++) {
				Double total = 0.0;
				Double cost = cart2.get(i).getCost();
				total = total + cost;
				System.out.println(total);
			}

		} else {
			System.out.println("The Cart is currently Empty");
		}

	}// end displayCart method

	/**
	 * 
	 * @param list
	 * @param fishes
	 * @throws IOException
	 */

	private static void addFishToCart(ArrayList<Animal> cart, ArrayList<Animal> fishes) throws IOException {

		System.out.print("Enter a Fish: ");
		String fish = br.readLine();

		for (int i = 0; i < fishes.size(); i++) {
			if (fish.equals(fishes.get(i).getType())) {
				cart.add(fishes.get(i));
				System.out.println(fish + " added to Cart!");
			} else {
				System.out.println("Not in Inventory");
			}
		}

	}// end addFishToCart method

	/**
	 * 
	 * @param cart
	 * @param plantList
	 * @throws IOException
	 */
	private static void addPlantToCart(ArrayList<Animal> cart, ArrayList<Animal> plantList) throws IOException {
		System.out.print("Enter a Number from the List Below: ");
		System.out.println(" ");
		for (int i = 0; i < plantList.size(); i++) {
			System.out.println(
					i + 1 + ". " + plantList.get(i).getType() + "        Cost: $" + plantList.get(i).getCost());

		}

		int tank = Integer.parseInt(br.readLine());

		///////////////

		for (int i = 0; i < plantList.size(); i++) {

			// System.out.println(tankList.get(i).getType().charAt(0));

			if (tank == i + 1) {
				System.out.println(" ");
				System.out.println("The " + plantList.get(i).getType() + " has been added to the Cart");
				System.out.println(" ");
				cart.add(plantList.get(i));

			} else {
				System.out.println("Invalid Selection");
			}

		}

	}// end addPlantToCart method

	/**
	 * 
	 * @param cart2
	 * @param decoList
	 */
	private static void addDecoToCart(ArrayList<Parts> cart2, ArrayList<Parts> decoList) throws IOException {
		System.out.print("Enter a Decoration: ");
		String deco = br.readLine();

		for (int i = 0; i < decoList.size(); i++) {
			if (deco.equals(decoList.get(i).getType())) {
				cart2.add(decoList.get(i));
				System.out.println(deco + " added to Cart!");
			} else {
				System.out.println("Not in Inventory");
			}
		}

	}// endPlanToCart method

	/**
	 */
	private static void testAquarium(ArrayList<Animal> cart, ArrayList<Parts> cart2) {
		// TODO Auto-generated method stub

	}// testAquarium method

}// end Class
