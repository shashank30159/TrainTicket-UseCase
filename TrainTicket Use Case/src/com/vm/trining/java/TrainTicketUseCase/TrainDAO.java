package com.vm.trining.java.TrainTicketUseCase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrainDAO { 
	private String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	private String DB_URL="jdbc:mysql://localhost:3306/digital?autoReconnect=true&useSSL=false";
	private String USERNAME="root";
	private String PASSWORD="root";
	Train train;
		
	@SuppressWarnings("unused")
	public Train findTrain(int trainNo){
	   

		try{
			Class.forName(DRIVER_NAME);
			Connection con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			
			
			
			PreparedStatement p = con.prepareStatement("select * from trains where train_no=?");
			p.setInt(1, trainNo);
		    ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				int train_no=rs.getInt("train_no");
				String train_name=rs.getString("train_name");
				String source=rs.getString("source");
				String destination=rs.getString("destination");
				Double ticket_price=rs.getDouble("ticket_price");
				train=new Train(train_no,train_name,source,destination,ticket_price);
				System.out.println(train);
				
	       }
			if(rs==null)
			{
				System.out.println("Train no not found");
			}
			

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return train;

	}

}


