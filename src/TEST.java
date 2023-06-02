import java.security.PublicKey;
import java.util.Scanner;

public class TEST {

    public static String cabinName;
    public static int cabinNumber;
    public static String cabin[] = new String[12];


    private static void add(){
        Scanner addInput = new Scanner(System.in);
        System.out.println("Enter the cabin number");
        cabinNumber = addInput.nextInt();
        System.out.println("Enter the customer name for the cabin " + cabinNumber);
        cabinName = addInput.next();
        cabin[cabinNumber] = cabinName;

        //mainMenuChoice();
    }

    private static void view(){
        for (int i = 0; i < 12; i++){
            System.out.println("Cabin " + i + " occupied by " + cabin[i]);
        }
        //mainMenuChoice();
    }

    private static void inititalise(String cabinRef[]){
        for (int i=0; i < 12; i++){
            cabinRef[i] = "-empty-";
        }
    }

    public static void mainEU() {
        String line ="-";


        System.out.println(line.repeat(60));
        System.out.println("                    CRUISE SHIP BOARDING     ");
        System.out.println(line.repeat(60));

        while (true){

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
                    view();
                }

                if(num.equals("V") || num.equals("v")){
                    add();
                }

                if(num.equals("D") || num.equals("D")){
                    // System.out.println("You're good to proceed..! ");
                }

                if(num.equals("E") || num.equals("E")){

                    // System.out.println("You're good to proceed..! ");
                }

                if(num.equals("F") || num.equals("F")){

                    // System.out.println("You're good to proceed..! ");
                }

                if(num.equals("S") || num.equals("S")){

                    // System.out.println("You're good to proceed..! ");
                }

                if(num.equals("L") || num.equals("L")){

                    // System.out.println("You're good to proceed..! ");
                }

                if(num.equals("O") || num.equals("O")){

                    // System.out.println("You're good to proceed..! ");
                }
            }

            catch(Exception ex){
                System.out.println("Wrong Entry..Try Again!");
                System.out.println();
            }

        }

    }

    public static void main(String[] args) {
        inititalise(cabin);
        mainEU();
    }
}
