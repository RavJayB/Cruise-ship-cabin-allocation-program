import java.util.*;
import java.io.*;

public class Main {
    public static  String cabinName;
    public static int cabinNumber = 0;
    public static String[] cabin = new String[12];

    public static void main(String[] args) {

        inititalise(cabin);
        mainMenu();

    }

    private static void add(){
        Scanner addInput = new Scanner(System.in);
        System.out.println("Enter the cabin number");
        cabinNumber = addInput.nextInt();
        System.out.println("Enter the customer name for the cabin " + cabinNumber);
        cabinName = addInput.next();
        cabin[cabinNumber] = cabinName;

        mainMenuChoice();
    }

    private static void view(){
        for (int i = 0; i < 12; i++){
            System.out.println("Cabin " + i + " occupied by " + cabin[i]);
        }
        mainMenuChoice();
    }

    private static void inititalise(String cabinRef[]){
        for (int i=0; i < 12; i++){
            cabinRef[i] = "-empty-";
        }
    }

    private static void delete(){
        Scanner addInput = new Scanner(System.in);
        System.out.println("Enter the cabin number");
        cabinNumber = addInput.nextInt();
        cabin[cabinNumber] = "-empty-";

        mainMenuChoice();
    }

    private static void emptyCabins(){
        for (int i = 0; i < 12; i++){
            if (cabin[i].equals("-empty-")){
                System.out.println("Cabin " + i + " is empty");
            }
        }

        mainMenuChoice();
    }

    private static void findCabin(){
        String customerName;
        Scanner addInput = new Scanner(System.in);
        System.out.println("Enter the customer name");
        customerName = addInput.next();

        for (int i = 0; i < 12; i++){
            if (cabin[i].equals(customerName)){
                System.out.println(customerName + " is in cabin " + i);
            }
        }

        mainMenuChoice();
    }

    private static void storeData(){
        try{
            FileWriter storeData = new FileWriter("StoredData.txt");
            for(String str: cabin){
                storeData.write(str + System.lineSeparator());
            }
            storeData.close();
            System.out.println("Successfully stored the data in the file.");
        }
        catch (IOException e){
            System.out.println("An error occurred");
        }

        mainMenuChoice();
    }

    private static void loadData(){
        int lineCount = 1;
        try{
            File loadData = new File("StoredData.txt");
            Scanner line = new Scanner(loadData);
            String fileLine;
            while (line.hasNext()){
                fileLine = line.nextLine();
                System.out.println(fileLine);
                lineCount++;
            }
        } catch (IOException e) {
            System.out.println("Error IOException is: " + e);
        }

        mainMenuChoice();

    }

    private static void arrayOrder(){
        String temp;
        for (int i = 0; i < 12; i++){
            for (int j = i + 1; j < 12; j++){
                if (cabin[i].compareTo(cabin[j]) > 0){
                    temp = cabin[i];
                    cabin[i] = cabin[j];
                    cabin[j] = temp;
                }
            }
        }

        System.out.println("Alphabetical order : ");
        for (int i = 0; i < 12; i++){
            System.out.println(cabin[i]);
        }

        mainMenuChoice();
    }

    private static void mainMenu(){
        Scanner input = new Scanner(System.in);
        String userInput;

        System.out.println("----------------------------------\n");
        System.out.println("Main Menu" + "\n" + "A: Add a customer\nV: View all cabins\nD: Delete customer from cabin" +
                "\nE: Display Empty Cabins\nF: Find cabin from customer name\nS: Store program data into file" +
                "\nL: Load program data from file\nO: View passengers Ordered alphabetically by name.");

        System.out.print("Enter the value ");
        userInput = input.next().toLowerCase(Locale.ROOT);

        if (userInput.equals("a")){
            add();
        }
        else if (userInput.equals("v")){
            view();
        }
        else if (userInput.equals("d")){
            delete();
        }
        else if (userInput.equals("e")){
            emptyCabins();
        }
        else if (userInput.equals("f")){
            findCabin();
        }
        else if (userInput.equals("s")){
            storeData();
        }
        else if (userInput.equals("l")){
            loadData();
        }
        else if (userInput.equals("o")){
            arrayOrder();
        }
    }

    private static void mainMenuChoice(){
        Scanner input = new Scanner(System.in);
        String choice;
        System.out.print("Go back to main menu ? Y/N : ");
        choice = input.next().toLowerCase(Locale.ROOT);

        if (choice.equals("y")){
            mainMenu();
        }
        else {
            System.exit(1);
        }

    }
}

