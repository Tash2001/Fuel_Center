
import java.util.Scanner;
import java.io.*;

public class FuelCenter {
    public static Scanner input = new Scanner(System.in);

    // variables
    static boolean repeat=true;
    static int remain=0;
    static int stock=6600;
    static int count=0;
    static int fLiter=0;
    static int fTotal=0;



    //main method
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------------");
        System.out.println("----------------------WELCOME---------------------------");
        System.out.println("---------------------FUEL CENTER------------------------");
        System.out.println("--------------------------------------------------------\n");

        FuelQueue[] queues=new FuelQueue[5];
        for (int i=0;i< queues.length;i++){
            queues[i]=new FuelQueue();
        }

        //warning msg

        if ((stock-fTotal)<=500){
            System.out.println("WARNING ! \n Tge Stock reaches a value of 500 liters");
        }



            // to print the menu
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
            System.out.println("110 or IFQ: Income of all Fuel Queue");
            System.out.println("999 or EXT: Exit the Program.");
            System.out.println("\n--------------------------------------------------------");

            //option
            System.out.print("\nEnter your option: ");
            String option = input.next().toUpperCase();

                // to select the option
            switch (option) {

                case "100", "VFQ":
                    viewObject(queues);   // view customers
                    System.out.println();
                    break;

                case "101", "VEQ":
                    emptyObject(queues);  //view empty queues
                    System.out.println();
                    break;

                case "102", "ACQ":
                    addCustomer(queues);  // to add customer
                    System.out.println();
                    break;

                case "103", "RCQ":
                    removeObject(queues);  // to remove customer
                    System.out.println();
                    break;

                case "104", "PCQ":
                    servedCustomer(queues);  // to remove the served customer
                    System.out.println();
                    break;

                case "105", "VCS":
                    sortObject(queues);  // to print the alphabetically order
                    System.out.println();
                    break;

                case "106", "SPD":
                    storeObject(queues);   // store the data (txt file)
                    System.out.println();
                    break;

                case "107", "LPD":
                    loadObject();
                    System.out.println();  // to load the txt file
                    break;

                case "108", "STK":
                    remainingObject(queues); // to view remaining Fuel stock
                    System.out.println();
                    break;

                case "109", "AFS":
                    addStock(queues);  // add Fuel stock
                    System.out.println();
                    break;


                case "110","IFQ":
                    income(queues); // to get the income
                    System.out.println();
                    break;

                case "999", "EXT":
                    exit(queues);  // for exit
                    System.out.println();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");

            }

        }

    }

    // method for view customers
    static void viewObject(FuelQueue[] queues){
        for (int i=0;i< queues.length;i++){
            System.out.println("Pump No : "+(i+1));
            for(int x = 0; x< queues[i].passengers.length; x++){


                if(!queues[i].getFName(x).equals("Empty")){
                    System.out.println("Customer "+(x+1)+" : "+ queues[i].getFName(x)+" "+queues[i].getLName(x));
                }else {
                    System.out.println("This is Empty");
                }

            }
            System.out.println();
        }
    }

    // method for add to the customer
    public static FuelQueue[] addCustomer(FuelQueue[] queues){
       int i=0;
       int queueNo=0;
       int tempCount= queues[i].passengerCount;

       int cust=queues[i].passengerCount;

       i=1;
       try {
           while (i < queues.length) {
               if (tempCount > queues[i].passengerCount) {
                   tempCount = queues[i].passengerCount;
                   queueNo = i;

               }
               i++;
           }
           System.out.print("Enter the first name: ");
           String fname = input.next();

           System.out.print("Enter the last name: ");
           String lname = input.next();

           System.out.print("Enter the vehical number: ");
           String numPlt = input.next();

           System.out.print("Enter the required liter: ");
           int fuel = input.nextInt();

           queues[queueNo].add(fname, lname, numPlt, fuel);
           System.out.println();
           System.out.println(fname + " " + lname + " has been added to Queue No.0" + (queueNo + 1));

       }catch (Exception e){
           System.out.println("Invalid!");
       }
       return queues;

    }

    //method for find the empty queues
    public static void emptyObject(FuelQueue[] queues){
        for (int i=0;i< queues.length;i++){
            for(int x=0;x< FuelQueue.passengers.length;x++){
                if(queues[i].getFName(x).equals("Empty")){
                    System.out.println("Pump "+(i+1)+" Customer "+(x+1)+"  is Empty");

                }

            }
            System.out.println();
        }
    }

    //method to remove customer

    public static FuelQueue[] removeObject(FuelQueue[] queues){
        try{


            System.out.print("Enter the pump number : ");
            int pump=input.nextInt();

            System.out.print("Enter the name : ");
            String name=input.next();

            for (int i=0;i<FuelQueue.passengers.length;i++) {
                while (FuelQueue.getFName(i).equals(name)) {



                    queues[(pump - 1)].del(i);
                    System.out.println();
                    System.out.println(name + " has been removed to Queue no.0" + pump);


                }
            }




            return queues;
        }catch (Exception e) {
            System.out.println("Invalid Input");
        }


        return queues;
    }


    public static FuelQueue[] servedCustomer(FuelQueue[] queues){
        try{
            System.out.print("From which pump do you serve a customer : ");
            int pump= input.nextInt();

            for(int i=0;i<FuelQueue.passengers.length;i++) {
                if (!FuelQueue.getFName(i).equals("Empty")) {
                    fLiter= FuelQueue.getLiter(i);
                    queues[(pump - 1)].srvd((i));

                    fTotal=fTotal+fLiter;
                    System.out.println();
                    System.out.println("A Served Customer has been removed to queue no.0" + pump);

                    break;
                }
            }


        }catch (Exception e){
            System.out.println("Invalid");
        }

        return queues;
    }

    public static void sortObject(FuelQueue[] queues){
        int sortNumber=0;

        //new array to sort by alphabetical order

        String[] sort=new String[30];
        for (int i=0;i< queues.length;i++){
            for (int x= 0; x< FuelQueue.passengers.length;x++){
                if (!queues[i].getFName(x).equals("Empty")){
                    sort[sortNumber]=(queues[i].getFName(x)+" "+queues[i].getLName(x));

                }else {
                    sort[sortNumber]=("This is empty");
                }
                sortNumber++;


            }
        }

        //sorting

        int num=30;
        String temp;

        for (int i =0; i<num;i++){
            for (int j=i+1 ; j<num;j++){
                //swapping

                if (sort[i].compareTo(sort[j])>0){
                    temp=sort[i];
                    sort[i]=sort[j];
                    sort[j]=temp;
                }
            }
        }

        //print sorted array

        System.out.println("Alphabetically ordered Passenger name list");

        for (int i=0; i<num;i++){
            if (sort[i] !=("This is empty")){
                System.out.println(sort[i]);


            }
        }

    }

    private static FuelQueue[] storeObject(FuelQueue[] queues){
        try {
            FileWriter file = new FileWriter("Stored_data_task2.txt");
            for (int q=0; q<queues.length; q++) {
                for(int i=0;i< queues[q].passengers.length;i++)
                    if (queues[q].getFName(i).equals("This is empty")){
                        file.write("This is empty"+"\n");
                    } else{
                        file.write((q+1)+"."+(i+1)+". Customer : "+queues[q].getFName(i)+" "+queues[q].getLName(i)+"\n");
                    }

            }
            file.close();
            System.out.println("Data has been stored to the file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        return queues;

    }

    private static void loadObject(){
        try {
            File load_file = new File("Stored_data_task2.txt");
            Scanner myReader = new Scanner(load_file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void remainingObject(FuelQueue[] queues){
        remain=stock-fTotal;
        System.out.println("Remaining Fuel Stock(Liters) : "+remain);


    }

    public static void addStock(FuelQueue[] queues){
        System.out.println("Add Fuel Stock(Liters) :"+fTotal);
    }

    public static void income(FuelQueue[] queues){
        int income=fTotal*430;
        System.out.println("Income : "+income);
    }


    public static boolean exit(FuelQueue[] queues){
        repeat=false;
        System.out.println("Thank You !");
        return repeat;
    }

}
