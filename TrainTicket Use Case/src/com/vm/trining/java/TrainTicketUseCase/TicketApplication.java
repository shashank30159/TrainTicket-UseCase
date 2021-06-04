package com.vm.trining.java.TrainTicketUseCase;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TicketApplication {

	public static void main(String[] args) {

		TrainDAO trainDao=new TrainDAO();
		Ticket ticket=null;
		double ticketPrice=0;
		System.out.println("============Welcome to Train Ticket Booking==========");
		System.out.println("Enter the train no");
		Scanner sc=new Scanner(System.in);
		int trainNo=sc.nextInt();

		
		System.out.println("Enter the travel date in dd/MM/yyyy format");
		String date=sc.next();
		try {

			Date travelDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			if(travelDate.after(new Date())) 
			{


				Train train= trainDao.findTrain(trainNo);
				ticket=new Ticket(travelDate,train);
				System.out.println("Enter the no. of passengers:");
				int passengerNo=sc.nextInt();

				for(int i=0;i<passengerNo;i++)
				{

					System.out.println("Enter the passenger name: ");
					sc.nextLine();
					String name=sc.nextLine();

					System.out.println("Enter the passenger age: ");
					int age=sc.nextInt();
					System.out.println("Enter the  gender (M/F): ");

					char gender=sc.next().charAt(0);
					if(gender=='F'|| gender== 'f'|| gender=='M'|| gender=='m'){
						Passenger passenger=new Passenger(name,age,gender);
						ticket.addPassenger(name, age, gender);
						ticketPrice=ticketPrice+ticket.calculateTotalTicketPrice();
					}
					else{
						System.out.println("Please enter correct gender");
					}


				}
				String pnr=ticket.generatePNR();
				System.out.println("Train booked with PNR No.: "+pnr);
				System.out.println("totalFare: "+ticketPrice);

				try {
					System.out.println("Ticket should be written to the file with filename "+pnr+".txt");
					ticket.writeTicket();
				} catch (IOException e) {
					System.out.println("File not generated");
				}

			}
			else
			{

				System.out.println("Please enter valid date");
			}

		} catch (ParseException e) {

			e.printStackTrace();
		} 
	}
}