//Author: Hamza Syed
//Class: COSC3319
//Lab 3 Option A

public class Car implements Vehicle_Interface {
	
	String make;
	int doors;

	Car(String make, int doors)
	{
		this.make = make;
		this.doors = doors;
	}
	
	@Override
	public void SetMake(String make)
	{
		this.make = make;
	}

	@Override
	public String GetMake() 
	{
		return make;
	}

	@Override
	public void SetDoors(int doorCount) 
	{
		doors = doorCount;
	}

	@Override
	public int GetDoors() 
	{
		return doors;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(other == null) return false;
		if(!(other instanceof Car)) return false;
		if(other == this) return true;
		if(((Car) other).GetMake().equals(this.make)) return true;
		return false;
	}
	

	public String toString()
	{
		return (make+" with "+doors+" doors");
	}
}
