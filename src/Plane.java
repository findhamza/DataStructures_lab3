//Author: Hamza Syed
//Class: COSC3319
//Lab 3 Option A

public class Plane implements Vehicle_Interface {
	
	String make;
	int doors;
	int engines;

	Plane(String make, int doors, int engineCount)
	{
		this.make = make;
		this.doors = doors;
		engines = engineCount;
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
	
	public void SetEngines(int engineCount)
	{
		engines = engineCount;
	}
	
	public int GetEngines()
	{
		return engines;
	}

	public String toString()
	{
		return ("\n"+doors+" doors and "+engines+" engine plane by "+make);
	}

}
