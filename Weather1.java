package weatherLab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Weather1 {
	
	/**
     * Reads through a file containing information on the amount of 
     * rainfall Grinnell gets everyday in various years to determine
     * the two days with the highest amount of rain and returns them 
     * in Month/Date/Year format along with their amounts.
     *  Also returns the amount of rain 
     * (in inches) each year receives and sums the total amount of 
     * rain from all years within the file. 
     */

   

    public static void main (String args[])
	{   // file name for weather data
   	 String testFile =  "/home/ochoaste/207/Labs/Grinnell-rainfall.dat";


   	 try{// try needed in case opening the input stream fails
   		 
   		 // set up file reader for given data file
   		 FileReader fileReaderIn = new FileReader (testFile);
   		 
   		 // use FileReader object to initialize scanner
   		 Scanner fileIn = new Scanner (fileReaderIn);
   					 
   		 String line = fileIn.nextLine();
   		 
   	 	// Establishes the holders for the two max rain values
   		 int rainMax1_year = 0;
   		 int rainMax1_date = 0;
   		 int rainMax2_year = 0;
   		 int rainMax2_date = 0;
   		 
   		 int day = 0;
   		 
   		 int count = 1;
   		 int year = 2016;
   		 double rainYear_sum = 0;
   		 double rainAmount = 0.00;
   		 
   		 double rainMax1 = 0.0;
   		 double rainMax2 = 0.0;
   		 String rainMax1_month = new String ("");
   		 String rainMax2_month = new String ("");
   		 
   		 boolean firstTime = true;
   		 
   		 // creates an array with the month names in order from the file
   		 String [] months = new String[12];
   		 int month_start = 12;
   		 int month_end = 20;
   		 
   		 for (int l = 0; l < 12; l++){
   			 String month = line.substring (month_start, month_end);
   			 month = month.trim();
   			 
   			 months[l] = month;
   			 
   			 if (!(month_start>=100)){
   				 month_start +=8;
   		 	}
   			 
   			 if (!(month_end>=100)){
   				 month_end +=8;
   			 }
   			 else{
   				 month_end +=5;
   			 }
   		 }
   		 
   		 //loops until the end of the file
   		 while (fileIn.hasNextLine()){
   			 //skips every 32nd line (the header)
   			 if (count % 32!=0){
   				 line = fileIn.nextLine();
   				 
   				 
   			 	//extracts the year and converts it to an int
   				 String readYear = line.substring (0, 5);
   				 readYear = readYear.trim();
   				 year = Integer.parseInt(readYear);
   				 
   				 //extracts the date and converts it to an int
   				 String date = line.substring (6, 11);
   				 date = date.trim();
   				 day = Integer.parseInt(date);
   				 
   				 //specifies the starting point and ending point for each rainfall amount
   				 int start = 12;
   				 int end = 20;
               	 
   				 
   				 //extracts the amount of rainfall from each date
   				 for (int i = 0; i < 12; i++){
   					 String rain = line.substring (start, end);
   					 rain = rain.trim();
   					 
   					 if (!(rain.equals("---"))){
   						 rainAmount = Double.parseDouble(rain);    
   						 
   						 //calculates the total amount of rainfall
   						 rainYear_sum += rainAmount;
   						 
   						 // sets values based on the first iteration of the while loop
   						 if (firstTime){
   							 rainMax1 = rainAmount;
   							 rainMax1_month = months[i];
   							 rainMax2 = rainAmount;
   							 rainMax2_month = months[i];
   							 firstTime = false;
   						 }
   						 
   						 else{
   							 if (rainMax1< rainAmount){
   								 rainMax2 = rainMax1;
   								 rainMax2_year = rainMax1_year;
   								 rainMax2_date = rainMax1_date;
   								 rainMax2_month = rainMax1_month;
   										 
   								 rainMax1 = rainAmount;
   								 rainMax1_year = year;
   								 rainMax1_date = day;
   								 rainMax1_month = months[i];
   							 }
   				 
   						 }
   					 }
   					 
   					 if (!(start>=100)){
   						 start +=8;
   				 	}
   					 
   					 if (!(end>=100)){
   						 end +=8;
   					 }
   					 else{
   						 end +=5;
   					 }
   				 }
   			 }
   			 else{
   				 //skips the header and prints out the summary data for a year
   				 System.out.println ("Year: " + year + "  Total amount of rainfall: " + rainYear_sum + " inches");
   				 line = fileIn.nextLine();
   				 rainYear_sum = 0;
   			 }
   			 count++;
   		 }
   		 System.out.println ("Year: " + year + "  Total Amount of Rainfall: " + rainYear_sum + " inches \n");
   		 System.out.println ("Max amount of rainfall: " + rainMax1 +" inches");
   		 System.out.println ("Date of Max: " + rainMax1_month+"/" + rainMax1_date + "/" + rainMax1_year+"\n");
   		 System.out.println ("Second rainfall max: "+ rainMax2 + " inches");
   		 System.out.println("Date of Second Max: " + rainMax2_month+"/" + rainMax2_date + "/" + rainMax2_year);
   	 }

   	 catch (IOException e){   // identify any error that arises
   		 System.err.println ("No rainfall data is available.");
   	 }
    }  
}
