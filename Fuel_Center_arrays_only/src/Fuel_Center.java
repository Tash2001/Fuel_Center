import java.io.File;      // import the file
import java.io.FileNotFoundException;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;// Import the IOException class to handle errors
import java.util.Scanner;



//class file
public class Fuel_Center {

    // create 3 arrays
    public static String[] pump1=new String[6];
    public static String[] pump2=new String[6];
    public static String[] pump3=new String[6];

    public static Scanner input = new Scanner(System.in);
    static int stock = 6600;
    static int count=0;
    static int remain=6600;
    static boolean repeat=true;

    static int addStk=0;

//---------------------------------------------------------------------------------------------
//main method
    public static void main(String[] args) {

        if((stock-count*10)<=500){
            System.out.println("WARNING!\nThe Stock reaches a value of 500 liters.");

        }

        for (int i=0; i<pump1.length;i++){
            pump1[i]="Empty";
            pump2[i]="Empty";
            pump3[i]="Empty";

        }

        System.out.println("--------------------------------------------------------");
        System.out.println("----------------------WELCOME---------------------------");
        System.out.println("---------------------FUEL CENTER------------------------");
        System.out.println("--------------------------------------------------------\n");


//menu
        while(repeat) {
            System.out.println("100 or VFQ: View all Fuel Queues.");
            System.out.println("101 or VEQ: View all Empty Queues.");
            System.out.println("102 or ACQ: Add customer to a Queue.");
            System.out.println("103 or RCQ: Remove a customer from a Queue. (From a specific location)");
            System.out.println("104 or PCQ: Remove a served customer.");
            System.out.println("105 or VCS: View Customers Sorted in alphabetical order (Do not use library sort routine)");
            System.out.println("106 or SPD: Store Program Data into file.");
            System.out.println("107 or LPD: Load Program Data from file.");
            System.out.println("108 or STK: View Remaining Fuel Stock.");
            System.out.println("109 or AFS: Add Fuel Stock.");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println("\n--------------------------------------------------------");

            //option
            System.out.print("\nEnter your option: ");
            String option = input.next().toUpperCase();

            switch (option) {

                case "100", "VFQ":
                    fuelQueues();
                    System.out.println();

                    break;

                case "101", "VEQ":
                    emptyQueues();
                    System.out.println();
                    break;

                case "102", "ACQ":
                    addCustomer();
                    System.out.println();
                    break;

                case "103", "RCQ":
                    remvCustomer();
                    System.out.println();
                    break;

                case "104", "PCQ":
                    srvdCustomer();
                    System.out.println();
                    break;

                case "105", "VCS":
                    sorted();
                    System.out.println();
                    break;

                case "106", "SPD":
                    storeFile();
                    System.out.println();
                    break;

                case "107", "LPD":
                    loadFile();
                    System.out.println();
                    break;

                case "108", "STK":
                    remainingStock();
                    System.out.println();
                    break;

                case "109", "AFS":
                    addStock();
                    System.out.println();
                    break;

                case "999", "EXT":
                    exit();
                    System.out.println();
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid option. Please try again.");

            }
        }

    }
    //view all fuel Queues.
    public static void fuelQueues() {

        System.out.println("\nPump number 1");
        for (int i = 0; i < pump1.length; i++) {
            System.out.println("Customer "+(i+1)+" : "+pump1[i]);
        }

        System.out.println("\nPump number 2");
        for (int i = 0; i < pump2.length; i++) {
            System.out.println("Customer "+(i+1)+" : "+pump2[i]);
        }

        System.out.println("\nPump number 3");
        for (int i = 0; i < pump3.length; i++) {
            System.out.println("Customer "+(i+1)+" : "+pump3[i]);

        }

    }
//view all Empty Queues.
    public static void emptyQueues(){
        if((pump1[0].equals("Empty"))&&(pump2[0].equals("Empty"))&&(pump3[0].equals("Empty"))){
            System.out.println("All Queues are Empty.");

        } else if ((pump1[0].equals("Empty"))&&(pump2[0].equals("Empty"))&&(!pump3[0].equals("Empty"))){
            System.out.println("Pump 1 Queue & Pump 2 Queue are Empty.");

        } else if ((pump1[0].equals("Empty"))&&(!pump2[0].equals("Empty"))&&(pump3[0].equals("Empty"))) {
            System.out.println("Pump 1 Queue & Pump 3 Queue are Empty.");

        } else if ((!pump1[0].equals("Empty"))&&(pump2[0].equals("Empty"))&&(pump3[0].equals("Empty"))) {
            System.out.println("Pump 2 Queue & Pump 3 Queue are Empty.");

        } else if ((pump1[0].equals("Empty"))&&(!pump2[0].equals("Empty"))&&(!pump3[0].equals("Empty"))) {
            System.out.println("Pump 1 Queue is Empty.");

        } else if ((!pump1[0].equals("Empty"))&&(pump2[0].equals("Empty"))&&(!pump3[0].equals("Empty"))) {
            System.out.println("Pump 2 Queue is Empty.");

        } else if ((!pump1[0].equals("Empty"))&&(!pump2[0].equals("Empty"))&&(pump3[0].equals("Empty"))) {
            System.out.println("Pump 3 Queue is Empty.");
        }else {
            System.out.println("No Empty Queue");
        }

    }

    //Add customer from a Queue
    private static void addCustomer() {

        try {
            System.out.print("\nEnter the pump number : ");
            int add = input.nextInt();

            if (add == 1) {
                for (int i = 0; i < pump1.length; i++) {
                    if (pump1[i].equals("Empty")) {
                        System.out.print("\nEnter the customer name : ");
                        String name = input.next();
                        pump1[i] = name;
                        count++;
                        System.out.println(name+" has been added to Queue No.0"+(add));

                        break;

                    }
                }


            } else if (add == 2) {
                for (int i = 0; i < pump2.length; i++) {
                    if (pump2[i].equals("Empty")) {
                        System.out.print("\nEnter the customer name : ");
                        String name = input.next();
                        pump2[i] = name;
                        count++;
                        System.out.println(name+" has been added to Queue No.0"+(add));

                        break;
                    }
                }

            } else if (add == 3) {
                for (int i = 0; i < pump3.length; i++) {
                    if (pump3[i].equals("Empty")) {
                        System.out.print("\nEnter the customer name : ");
                        String name = input.next();
                        pump3[i] = name;
                        count++;
                        System.out.println(name+" has been added to Queue No.0"+(add));

                        break;
                    }
                }
            } else {
                System.out.println("Invalid Entering.");
            }
        } catch (Exception e) {
            System.out.println("Invalid Input");
        }
    }

// Remove a customer from a Queue. (From a specific location)
    public static void remvCustomer () {
        try {
            System.out.print("Enter the remove customer's name : ");
            String rmvName = input.next();

            System.out.print("From which pump do you want to remove a customer ? ");
            int num = input.nextInt();

            if (num == 1) {
                for (int i = 0; i < pump1.length; i++) {
                    if (pump1[i].equals(rmvName)) {
                        while (i < (pump1.length - 1)) {

                            pump1[i] = pump1[(i + 1)];
                            i++;

                        }
                        pump1[(pump1.length - 1)] = "Empty";
                        System.out.println(rmvName+" removed.");
                    } else {
                        System.out.println("Invalid input.");
                    }

                }


            } else if (num == 2) {
                for (int i = 0; i < pump2.length; i++) {
                    if (pump2[i].equals(rmvName)) {
                        while (i < (pump2.length - 1)) {

                            pump2[i] = pump2[(i + 1)];
                            i++;

                        }
                        pump2[(pump2.length - 1)] = "Empty";
                        System.out.println(rmvName+" removed.");

                    } else {
                        System.out.println("Invalid input.");
                    }
                }

            } else if (num == 3) {
                for (int i = 0; i < pump3.length; i++) {
                    if (pump3[i].equals(rmvName)) {
                        while (i < (pump3.length - 1)) {
                            pump3[i] = pump3[(i + 1)];
                            i++;

                        }
                        pump3[(pump3.length - 1)] = "Empty";
                        System.out.println(rmvName+" removed.");

                    } else {
                        System.out.println("Invalid input.");
                    }
                }

            } else {
                System.out.println("Invalid Entering");
            }
        }catch (Exception e){
            System.out.println("Invalid Input");
        }
    }
//Remove a served customer.
    private static void srvdCustomer(){
        System.out.print("From which pump do you serve a customer ? ");
        int num = input.nextInt();
        count=count+1;

        switch (num){
            case 1:
                for (int i=0;i< pump1.length-1;i++){
                    pump1[i]=pump1[i+1];
                }
                pump1[(pump1.length-1)]="Empty";
                break;

            case 2:
                for (int i=0;i< pump2.length-1;i++){
                    pump2[i]=pump2[i+1];
                }
                pump2[(pump2.length-1)]="Empty";
                break;

            case 3:
                for (int i=0;i< pump3.length-1;i++){
                    pump3[i]=pump3[i+1];
                }
                pump3[(pump3.length-1)]="Empty";
                break;
        }

    }

    //View Customers Sorted in alphabetical order
    public static void sorted() {
        String temp;
        for (int i = 0; i < pump1.length; i++) {
            for (int j = i + 1; j < pump1.length; j++) {

                // to compare one string with other strings
                if (pump1[i].compareTo(pump1[j]) > 0) {
                    // swapping
                    temp = pump1[i];
                    pump1[i] = pump1[j];
                    pump1[j] = temp;
                }
            }
        }

        // print output pump 1
        System.out.println(
                "The pump 1 in alphabetical order are: ");
        for (int i = 0; i < pump1.length; i++) {
            System.out.println(pump1[i]);
        }
        //pump2

        for (int i = 0; i < pump2.length; i++) {
            for (int j = i + 1; j < pump2.length; j++) {

                // to compare one string with other strings
                if (pump2[i].compareTo(pump2[j]) > 0) {
                    // swapping
                    temp = pump2[i];
                    pump2[i] = pump2[j];
                    pump2[j] = temp;
                }
            }
        }

        // print output pump 2
        System.out.println(
                "The pump 2 in alphabetical order are: ");
        for (int i = 0; i < pump2.length; i++) {
            System.out.println(pump2[i]);
        }

        //pump 3
        for (int i = 0; i < pump3.length; i++) {
            for (int j = i + 1; j < pump3.length; j++) {

                // to compare one string with other strings
                if (pump3[i].compareTo(pump3[j]) > 0) {
                    // swapping
                    temp = pump3[i];
                    pump3[i] = pump3[j];
                    pump3[j] = temp;
                }
            }
        }

        // print output pump 3
        System.out.println(
                "The pump 3 in alphabetical order are: ");
        for (int i = 0; i < pump3.length; i++) {
            System.out.println(pump3[i]);
        }
    }

    //Store Program Data into file
    public static void storeFile(){

        try{
            FileWriter store=new FileWriter("storedData.txt");
            store.write("Pump 1 data :");
            for (int i=0;i< pump1.length;i++){

                if (pump1[i].equals("Empty")){
                    store.write(pump1[i]+"\n");
                }else {
                    store.write("Name : "+pump1[i]+"\n");
                }


            }

            store.write("Pump 2 data :");

            for (int i=0;i< pump2.length;i++){
                if (pump2[i].equals("Empty")){
                    store.write(pump2[i]+"\n");
                }else {
                    store.write("Name : "+pump2[i]+"\n");
                }
            }

            store.write("Pump 3 Data :");
            for (int i=0;i< pump3.length;i++){
                if (pump3[i].equals("Empty")){
                    store.write(pump3[i]+"\n");
                }else {
                    store.write("Name : "+pump3[i]+"\n");
                }
            }

            store.close();
            System.out.println("The file was successfully written to file.");

        }catch (IOException e){
            System.out.println("There was a mistake.");


        }


    }
//Load Program Data from file.
    public static void loadFile(){
        try{
            File load=new File("storedData.txt");
            Scanner read=new Scanner(load);

            while(read.hasNextLine()){
                String data=read.nextLine();
                System.out.println(data);
            }
            read.close();

        }catch(FileNotFoundException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }

    //View Remaining Fuel Stock.
    public static void remainingStock(){
        remain=stock-(count*10);
        System.out.println("Remaining Fuel Stock(Liters) : "+remain);

    }

    // Add Fuel Stock.
    public static void addStock(){

        addStk=count*10;
        System.out.println("Add Fuel Stock(Liters) :"+addStk);

    }

    // Exit the Program.
    public static boolean exit(){
        repeat=false;
        System.out.println("Thank You!");
        return repeat;
    }



}
//referance---->https://www.w3schools.com/java/java_files_create.asp
//              https://www.w3schools.com/java/java_files_read.asp