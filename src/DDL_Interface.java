//Author: Hamza Syed
//Class: COSC3319
//Lab 3 Option A

public interface DDL_Interface {

	public void InsertFront(Object obj);
	public void InsertRear(Object obj);
	public void Delete(Object obj);
	public int ListSize();
	public int FindItem(Object obj);
	public void PrintList(String order);
}
