

import java.util.Scanner;

public class Passenger {


    //create an attributes
    private String firstName;
    private String lastName;
    private String vehiNo;
    private int noOfLiters;



    public Passenger(String firstName,String lastName,String vehiNo,int noOfLiters){
        this.firstName=firstName;
        this.lastName=lastName;
        this.vehiNo=vehiNo;
        this.noOfLiters=noOfLiters;
    }

    public String getFirstName(){

        return this.firstName;
    }

    public void add(String firstName,String lastName,String vehiNo,int noOfLiters) {
       this.firstName=firstName;
       this.lastName=lastName;
       this.vehiNo=vehiNo;
       this.noOfLiters=noOfLiters;


    }
    public void del(String firstName,String lastName,String vehiNo,int noOfLiters){
        this.firstName=firstName;
        this.lastName=lastName;
        this.vehiNo=vehiNo;
        this.noOfLiters=noOfLiters;


    }

    public void  svrd(String firstName,String lastName,String vehiNo,int noOfLiters){
        this.firstName=firstName;
        this.lastName=lastName;
        this.vehiNo=vehiNo;
        this.noOfLiters=noOfLiters;
    }

    public String getLastName(){
        return this.lastName;
    }

    public String getVehiNo(){
        return this.vehiNo;

    }
    public int getNoOfLiters(){
        return this.noOfLiters;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }






}
