package cruiseship;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

	private static boolean MainMenu = true;
	private static boolean SubMenu = true;


	public static void main(String[] args) throws IOException {
		//		Implement scanner + initialise cabins 
		Scanner input = new Scanner(System.in);
		Cabin[] myShip = new Cabin[13];
		myShip[0] = new Cabin();
		myShip[1] = new Cabin();
		myShip[2] = new Cabin();
		myShip[3] = new Cabin();
		myShip[4] = new Cabin();
		myShip[5] = new Cabin();
		myShip[6] = new Cabin();
		myShip[7] = new Cabin();
		myShip[8] = new Cabin();
		myShip[9] = new Cabin();
		myShip[10] = new Cabin();
		myShip[11] = new Cabin();
		myShip[12] = new Cabin();

		int roomNum = 0;
		initialise(myShip);
		while (MainMenu) {
			while (SubMenu) {
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("Hello and Welcome to the Eldian Cruise Ship Program \n ");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("Please select one of the options.");
				System.out.println("A: Book A New Room.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("E: Display Empty Rooms.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("V: View all Rooms.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("D: Delete customer from room.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("F: Find room from customer name.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("S: Store program data in to file.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("L: Load program data from file.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("O: View rooms Ordered alphabetically by name.");
				System.out.println("---------------------------------------------------------------------------------------");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
				String Selection = input.next();

				//				include '.toUpperCase()' to transform any lower-case user input in order to meet cases in the switch statement 
				Selection = Selection.toUpperCase();

				//				switch and case for the menu
				switch (Selection) {
				case "A":
					BookARoom(myShip, roomNum);
					break;
				case "E":
					CheckIfEmpty(myShip);
					break;
				case "V":
					ViewAllRooms(myShip);
					break;
				case "D":
					DeleteCustomerFromRoom(myShip, roomNum);
					break;
				case "F":
					FindRoomFromCustomerName(myShip);
					break;
				case "S":
					StoreProgramDataInToFile(myShip);
					break;
				case "L":
					LoadProgramDataFromFile(myShip);
					break;
				case "O":
					ViewRoomsOrderedAlphabeticallyByName(myShip);
					break;
				default:
					System.out.println("Invalid Selection");
					break;
				}
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("Would you like to Select another Option\n1 ) Yes\n2 ) No");
				System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				if (input.nextInt() == 1) {
					SubMenu = true;
				} else {
					SubMenu = false;
				}
			}
			SubMenu = true;
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("Would You Like To Continue With The Program\n1 ) Yes\n2 ) No");
			System.out.println("¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬¬");
			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			if (input.nextInt() == 1) {
				MainMenu = true;
			} else {
				System.out.println("");
				System.exit(0);

			}
		}

	}

	private static void initialise(Cabin[] myShip) {
		for (int x = 0; x < myShip.length; x++) {
			myShip[x].setName("nobody");
		}
	}

	// for when user input = "E"
	private static void CheckIfEmpty(Cabin[] myShip) {
		for (int x = 0; x < myShip.length; x++) {
			if (myShip[x].getName().equals("nobody")) {
				System.out.println("cabin " + (x + 1) + " is empty");
			}
		}
	}

	// for when user input = "A"	
	private static void BookARoom(Cabin[] myShip, int roomNum) {
		String roomName;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter room number (1-12):");
		roomNum = input.nextInt() - 1;
		System.out.println("Enter name for room " + (roomNum + 1) + " :");
		roomName = input.next();
		myShip[roomNum].setName(roomName);
	}


	// for when user input = "V"
	private static void ViewAllRooms(Cabin[] myShip) {
		for (int x = 0; x < myShip.length; x++) {
			System.out.println("room " + (x + 1) + " occupied by " + myShip[x].getName());
		}
	}


	// for when user input = "D"
	private static void DeleteCustomerFromRoom(Cabin[] myShip, int roomNum) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter room number to delete(1-12):");
		roomNum = input.nextInt() - 1;
		myShip[roomNum].setName("nobody");
		System.out.println("Entry Deleted :)");
	}


	// for when user input = "F"
	private static void FindRoomFromCustomerName(Cabin[] myShip) {
		Scanner input = new Scanner(System.in);
		String roomName;
		System.out.println("Enter name to Search for:");
		roomName = input.next();
		int x;
		boolean Checker = false;
		for (x = 0; x < myShip.length; x++) {
			if (roomName.equals(myShip[x].getName())) {
				System.out.println("This oocupant is staying at cabin number " + x);
				Checker = true;
			}
		}
		if (Checker == false) {
			System.out.println("Unfortunately there are no cabins booked with that name\n(make sure you've used the correct CAPS)");
		}
	}


	// for when user input = "S"
	private static void StoreProgramDataInToFile(Cabin[] myShip) throws IOException {
		try (PrintWriter out = new PrintWriter(new FileWriter("\"C:\\Users\\ehsaa\\Documents\\Uni\\Soft. dev II\\cruiseOutput.txt\""))) {
			int x;
			for (x = 0; x < myShip.length; x++) {
				out.println("Name and Room number is: " + myShip[x].getName() + "at: " + x);
			}

		}
		System.out.println("All Room Names have been Saved!");
	}


	// for when user input = "L"

	private static void LoadProgramDataFromFile(Cabin[] myShip) throws IOException {
		FileInputStream fs = new FileInputStream("\"C:\\Users\\ehsaa\\Documents\\Uni\\Soft. dev II\\cruiseOutput.txt\"");
		BufferedReader br = new BufferedReader(new InputStreamReader(fs));
		for (int i = 0; i < myShip.length; i++) {
			myShip[i].setName(br.readLine());
		}
	}

	// for when user input = "V"
	private static void ViewRoomsOrderedAlphabeticallyByName(Cabin[] myShip) {
		String[] myStrArray = new String[myShip.length];
		for (int i = 0; i < myShip.length; i++) {
			myStrArray[i] = myShip[1].getName();
		}

		Arrays.sort(myStrArray);
		for (int a = 0; a < myStrArray.length; a++) {
			System.out.println(myStrArray[a]);
		}

	}
}









		