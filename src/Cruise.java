import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

public class Cruise {

    public static String[] hotel = new String[12];
    public static int roomNum = 0;
    public static String roomName;

   // ---- METHOD FOR ADD CUSTOMER TO A CABIN ----
    private static void addCustomer()
    {
        System.out.println("Enter cabin number from 1-12 to add a customer:" );
        Scanner input = new Scanner(System.in);
        roomNum = input.nextInt()-1;
        System.out.println("Enter name for cabin " + (roomNum+1) +" :" ) ;
        roomName = input.next();
        hotel[roomNum] = roomName ;
        System.out.println(roomName + " successfully added to cabin NO: " + (roomNum+1));
        backOption();
    }

    // ---- METHOD FOR VIEW ALL THE CABINS ----
    private static void viewCabins(String []hotel){

        for(int x = 0; x<12; x++) {
            if (hotel[x].equals("__")) {
                System.out.println("Cabin " + (x+1) + " is empty..!");
            } else {
                System.out.println("Cabin " + (x+1) + " is occupied by " + hotel[x]);
            }
        }
        System.out.println();
        backOption();
    }

    private static void initialise( String hotelRef[])
    {
        for (int x = 0; x < 12; x++ )
            hotelRef[x] = "__";
    }

    // ---- METHOD FOR DELETE CUSTOMER FROM A CABIN ----
    private static void deleteCustomer(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter cabin number to delete a customer :");
        roomNum = input.nextInt()-1;
        hotel[roomNum] = "__";
        System.out.println("Customer in cabin NO: " + (roomNum+1) + " is successfully deleted!");
        System.out.println();
        backOption();
    }

    // ---- METHOD FOR VIEW EMPTY CABINS ----
    private static void emptyCabins(){
        for(int x=0; x<12; x++){
            if(hotel[x].equals("__")){
                System.out.println("Cabin " + (x+1) + " is empty..!");
            }
        }
        System.out.println();
        backOption();
    }

    // ---- METHOD FOR FIND CUSTOMER BY NAME ----
    private static void findCustomer(){
        System.out.println("Enter customer name : ");
        Scanner input = new Scanner(System.in);
        String customerName = input.next();
        for(int x=0; x<12; x++){
            if(hotel[x].equals(customerName)){
                System.out.println(customerName + " is in cabin NO: " + (x+1));
            }
        }
        backOption();
    }

    // ---- METHOD FOR STORE DATA INTO A .TXT FILE ----
    public static void storeData(){
        try{
            PrintWriter printData = new PrintWriter(new FileWriter("CabinData.txt"));

            for(int x = 0; x < 12; x++){
                printData.println(hotel[x]);
            }
            printData.close();
            System.out.println("Cruise boarding data stored successfully..!");
            System.out.println();
            backOption();
        }
        catch (Exception e){
            System.out.println("Error occurred..!!");
        }
    }

    // ---- METHOD FOR LOAD DATA FROM A .TXT FILE ----
    public static void loadData(){
        try{
            FileInputStream fis = new FileInputStream("CabinData.txt");
            BufferedReader bre = new BufferedReader(new InputStreamReader(fis));

            for (int x=0; x<hotel.length; x++){
                hotel[x] = bre.readLine();
            }
            bre.close();

            viewCabins(hotel);
            System.out.println();
            backOption();

        }
        catch (Exception b){
            System.out.println("Error occurred..!");
        }
    }

    // ---- METHOD FOR VIEW PASSENGERS ORDERED ALPHABETICALLY ----
    public static void alphabetically(){
        String temp;
        for (int i = 0; i < 12; i++){
            for (int j = i + 1; j < 12; j++){
                if (hotel[i].compareTo(hotel[j]) > 0){
                    temp = hotel[i];
                    hotel[i] = hotel[j];
                    hotel[j] = temp;
                }
            }
        }

        System.out.println("Alphabetical order : ");
        for (int i = 0; i < 12; i++){
            System.out.println(hotel[i]);
        }
        System.out.println();
        backOption();
    }


    // ---- MAIN MENU ----

    public static void menuDisplay() {
        String line ="-";
        System.out.println(line.repeat(60));
        System.out.println("                    CRUISE SHIP BOARDING     ");
        System.out.println(line.repeat(60));

        System.out.println("Please select an option :");
        System.out.println();

        Scanner mul = new Scanner(System.in);

        System.out.println(
                """
                        01. Select 'A' for View all cabins
                        02. Select 'V' for  Add a customer to a cabin
                        03. Select 'D' for Delete customer from cabin
                        04. Select 'E' for View empty cabins
                        05. Select 'F' for Find cabin from customer name
                        06. Select 'S' for Store program data into file
                        07. Select 'L' for Load program data from file
                        08. Select 'O' for View passengers ordered alphabetically by name""");
        System.out.println();

        try{


            String num = mul.next();
            if (num.equals("A") || num.equals("a")) {
                viewCabins(hotel);
            }
            if(num.equals("V") || num.equals("v")){
                addCustomer();
            }
            if(num.equals("D") || num.equals("d")){
                deleteCustomer();
            }
            if(num.equals("E") || num.equals("e")){
                emptyCabins();
            }
            if(num.equals("F") || num.equals("f")){
                findCustomer();
            }
            if(num.equals("S") || num.equals("s")){
                storeData();
            }
            if(num.equals("L") || num.equals("l")){
                loadData();
            }
            if(num.equals("O") || num.equals("o")){
                alphabetically();
            }
        }

        catch(Exception ex){
            System.out.println("Wrong Entry..Try Again!");
            System.out.println();
        }
    }

    // ---- BACK TO MAIN MENU OPTION ----

    public static void backOption(){
        System.out.println("Return to main menu Y/N");
        try{}
        catch (InputMismatchException c){
            System.out.println("Wrong entry! Try again..");
        }
        Scanner input = new Scanner(System.in);
        String select = input.next().toUpperCase();;
        if (select.equals("Y")){
            System.out.println();
            menuDisplay();
        }
        else if (select.equals("N")) {
            System.out.println("Exit selected!");
            System.exit(1);
        }
    }

    //  ----  MAIN METHOD  -----

    public static void main(String[] args) {
        initialise(hotel);
        menuDisplay();
    }
}
