

import java.util.Scanner;


public class FuelQueue {


    static int passengerCount=0;


    public static Passenger[] passengers= new Passenger[6];
    public  Scanner input=new Scanner(System.in);


    public FuelQueue(){
        for (int i= 0 ;i < passengers.length;i++){
            passengers[i]=new Passenger("Empty","Empty","Empty",0);

        }

    }
    public void add(String firstName,String lastName,String vehiNo,int noOfLiters){
        if(passengerCount < 6){
            passengers[passengerCount] = new Passenger(firstName,lastName,vehiNo,noOfLiters);
            passengerCount++;
        }
    }
    public static String getFName(int x){
        return passengers[x].getFirstName();

    }

    public String getLName(int x){
        return passengers[x].getLastName();


    }

    public void del(int no){


        passengers[no]=new Passenger("Empty","Empty","Empty",0);


    }

    public static int getLiter(int no){
        return passengers[no].getNoOfLiters();
    }

    public void srvd(int no){

        passengers[no]=new Passenger("Empty","Empty","Empty",0);


    }





}
