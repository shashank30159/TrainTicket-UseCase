package com.vm.trining.java.TrainTicketUseCase;

public class Passenger implements Comparable<Passenger>
{
	private String name;
	private int age;
	private char gender;
	
	//Constructor
	public Passenger() 
	{
		super();
		
	}
	
	
	//Parameterized constructor
	public Passenger(String name, int age, char gender) 
	{
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	//Getters and Setters
	public String getName() 
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public char getGender()
	{
		return gender;
	}
	public void setGender(char gender) 
	{
		this.gender = gender;
	}

	@Override
	public String toString() 
	{
		return name + "           " + age + "          " + gender ;
	}
	public int compareTo(Passenger passenger) {
		
		return name.compareTo(passenger.name);
	}
}
