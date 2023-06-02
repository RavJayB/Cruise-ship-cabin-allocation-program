import java.io.*;
import java.util.*;

public class HotelArrayVersion {

    //Making five arrays
    public static void main(String[] args) {

        int[] customerNum = new int[8];
        String[] firstName = new String[8];
        String[] surName = new String[8];
        String[] creditCardNum = new String[8];
        System.out.println("Array Version");

        initialise(customerNum);
        initialise(firstName);
        initialise(surName);
        initialise(creditCardNum);
        print();

        //Get the choice from user
        while (true){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter your choice:");
            String choice = input.next().toUpperCase();

            //Each letter is a choice and if user enters an invalid letter, program gives another attempt
            if (choice.equals("V")) view(firstName,surName);
            else if (choice.equals("A")) add(customerNum,firstName,surName,creditCardNum);
            else if (choice.equals("E")) empty(firstName);
            else if (choice.equals("D")) delete(customerNum,firstName,surName,creditCardNum);
            else if (choice.equals("F")) find(firstName);
            else if (choice.equals("S")) store(customerNum,firstName,surName,creditCardNum);
            else if (choice.equals("L")) load(customerNum,firstName,surName,creditCardNum);
            else if (choice.equals("O")) order(firstName);
            else if (choice.equals("X")) break;
            else System.out.println("Sorry, you have entered wrong choice. Try again.");
        }
    }

    //Print menu of choices
    private static void print() {
        //Welcome message
        System.out.println("Welcome to ABC Hotel Booking System...");
        //Choices
        System.out.println("V: To View all rooms");
        System.out.println("A: To Add customer to a room");
        System.out.println("E: To Display empty rooms");
        System.out.println("D: To Delete customer from a room");
        System.out.println("F: Find room from customer name");
        System.out.println("S: Store program data into file");
        System.out.println("L: Load program data from file");
        System.out.println("O: View guests alphabetically by name");
        System.out.println("X: Exit program");
    }

    //Initialising arrays
    private static void initialise( String[] hotelRef ){
        for (int x = 0; x < 8; x++ ){hotelRef[x] = "e";}
        System.out.println( "initialise");
    }
    private static void initialise( int[] hotelRef ){
        for (int x = 0; x < 8; x++ ){hotelRef[x] = 0;}
        System.out.println( "initialise");
    }


    //View all rooms in hotel
    private static void view(String[] firstName, String[] surName) {
        System.out.println("View All Rooms...");
        for (int x = 0; x < 8; x++){
            if (firstName[x].equals("e")) {
                System.out.println("Room " + (x + 1) + " is empty");
            } else {
                System.out.println("Room " + (x + 1) + " is occupied by " + firstName[x] + " " + surName[x]);
            }
        }
    }

    //Add customer to a room
    private static void add(int[] customerNum, String[] firstName, String[] surName, String[] creditCardNum) {
        String roomName;
        int customerNumber;
        String payFirstName;
        String paySurName;
        String creditCardNumber;
        int roomNum = 0;


        while (true) {
            try {
                //Get room number from the user
                Scanner input = new Scanner(System.in);
                System.out.println("Enter room number (1-8) or a number bigger than 8 to stop:");
                roomNum = input.nextInt() - 1;
                if (roomNum > 7) {
                    break;
                }

                //Get number of customers for the room
                System.out.println("Enter number of customers for room " + (roomNum + 1) + " :");
                customerNumber = input.nextInt();
                customerNum[roomNum] = customerNumber;

                //Get first name of the customer who pays for the room
                System.out.println("Enter first name of the paying customer for room " + (roomNum + 1) + " :");
                payFirstName = input.next();
                firstName[roomNum] = payFirstName;

                //Get surname of the customer who pays for the room
                System.out.println("Enter surname of the paying customer for room " + (roomNum + 1) + " :");
                paySurName = input.next();
                surName[roomNum] = paySurName;

                //Get credit card number of the customer who pays for the room
                System.out.println("Enter credit card number of the paying customer for room " + (roomNum + 1) + " :");
                creditCardNumber = input.next();
                creditCardNum[roomNum] = creditCardNumber;
                System.out.println("Details for room " + (roomNum + 1) + " is successfully added...");

                //If user enters an invalid room number, program will ask for a valid room number
            } catch (Exception e) {
                System.out.println("Please enter a valid number...");
            }
        }
    }

    //Display all empty rooms in hotel
    private static void empty(String[]firstName) {
        for (int x = 0; x < 8; x++ ) {
            if (firstName[x].equals("e")){
                System.out.println("room " + (x+1) + " is empty");
            }
        }
    }

    //Delete customer from a room
    private static void delete(int[] customerNum, String[] firstName, String[] surName, String[] creditCardNum) {

        try {
            //Get room number to make it empty
            Scanner input = new Scanner(System.in);
            System.out.print("Enter room number (1-8):");
            int i = input.nextInt() - 1;

            if (i < 8) {
                customerNum[i] = 0;
                firstName[i] = "e";
                surName[i] = "e";
                creditCardNum[i] = "e";
                System.out.println("Customer details for room " + (i + 1) + " is deleted successfully");

                //If customer enters a wrong room number, program will say that it is an invalid room number
            } else {
                System.out.println("Invalid room number...");
            }
        }catch (Exception e){
            System.out.println("Invalid room number...");
        }
    }

    //Find room number using customer name
    private static void find(String[] firstName) {
        //Get customer name
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name of the customer:");
        String name = input.next();
        boolean noCustomers = true;
        for (int x = 0; x < 8; x++) {
            if (firstName[x].equals(name)) {
                System.out.println("room is " + (x+1));
                noCustomers = false;
                break;
            }
        }
        //If user enters an invalid customer name, program says that the customer is not in the hotel
        if(noCustomers){
            System.out.println("The customer name you entered is not in hotel...");
        }
    }

    //Store program data into a file
    private static void store(int[] customerNum, String[] firstName, String[] surName, String[] creditCardNum) {

        try{
            PrintWriter out = new PrintWriter(new FileWriter("HotelStoreT3T1.txt"));

            for (int b = 0; b < 8; b++) {
                out.println("Room " + (b+1) + " has " + customerNum[b] + " customer/customers");
            }
            for (int y = 0; y < 8; y++) {
                out.println("First name of the customer who pays for room " + (y+1) + " is " + firstName[y]);
            }
            for (int z = 0; z < 8; z++) {
                out.println("Surname of the customer who pays for room " + (z+1) + " is " + surName[z]);
            }
            for (int a = 0; a < 8; a++) {
                out.println("Credit card number of the customer who pays for room " + (a+1) + " is " + creditCardNum[a]);
            }
            //After storing data to the file. program says that all the data has been saved
            System.out.println("All the data has been Saved.");
            out.close();

            //If there is any blocker, program says an error occurred
        } catch(Exception e){
            System.out.println("Error occurred while storing!");
        }
    }

    //Load program data from file
    private static void load(int[] customerNum, String[] firstName, String[] surName, String[] creditCardNum) {

        try{
            FileInputStream fs = new FileInputStream("HotelStoreT3T1.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));

            for (int i = 0; i < customerNum.length; i++) {
                customerNum[i] = Integer.parseInt(br.readLine());
            }
            for (int i = 0; i < firstName.length; i++) {
                firstName[i] = br.readLine();
            }
            for (int i = 0; i < surName.length; i++) {
                surName[i] = br.readLine();
            }
            for (int i = 0; i < creditCardNum.length; i++) {
                creditCardNum[i] = br.readLine();
            }
            view(firstName,surName);

        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //View rooms alphabetically by name
    private static void order(String[] hotelRef) {
        String[] hotel = new String[8];
        for (int i = 0; i < 8; i++) {
            hotel[i] = hotelRef[i];
        }

        //Two for loops should be used to check the alphabetical order of customer names
        for (int i = 0; i < hotel.length; i++) {
            for (int j = i + 1; j < hotel.length; j++) {
                if(hotel[i].compareTo(hotel[j]) > 0){
                    String hotelRoom = hotel[j];
                    hotel[j] = hotel[i];
                    hotel[i] = hotelRoom;
                }
            }
        }
        for (int x = 0; x < 8; x++ ){
            System.out.println(hotel[x]);
        }
    }
}

