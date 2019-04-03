//Author: Hamza Syed
//Class: COSC3319
//Lab 3 Option A

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Containers {

	public static void main(String[] args) throws FileNotFoundException
	{
		System.setOut(new PrintStream(new FileOutputStream("output.txt")));
		
		DoublyLinkedList cList = new DoublyLinkedList();
		
		Object[] cInOne = new Object[] {33,57,85,62,95};
		int[] cInOneOrder = new int[] {1,1,0,0,1};
		TaskInsert cInsert = new TaskInsert(cList,cInOne,cInOneOrder);
		Thread cThreadInsert = new Thread(cInsert);
		cThreadInsert.start();
		while(cThreadInsert.isAlive());
		cList = cInsert.getList();
		cList.PrintList("forward");
		cList.PrintList("backward");
		Object[] cOutOne = new Object[] {57,33,33,62};
		TaskDelete cDelete = new TaskDelete(cList,cOutOne);
		Thread cThreadDelete = new Thread(cDelete);
		cThreadDelete.start();
		while(cThreadDelete.isAlive());
		cList = cDelete.getList();
		cInOne = new Object[] {22};
		cInOneOrder = new int[] {1};
		cInsert = new TaskInsert(cList,cInOne,cInOneOrder);
		cThreadInsert = new Thread(cInsert);
		cThreadInsert.start();
		while(cThreadInsert.isAlive());
		cList = cInsert.getList();
		cOutOne = new Object[] {95};
		cDelete = new TaskDelete(cList,cOutOne);
		cThreadDelete = new Thread(cDelete);
		cThreadDelete.start();
		while(cThreadDelete.isAlive());
		cList = cDelete.getList();
		cList.PrintList("forward");
		
		DoublyLinkedList bList = new DoublyLinkedList();
		Object[] bInOne = new Object[] {new Car("Ford",4), new Car("Ford",2), new Car("GMC",2), new Car("RAM",2), new Car("Chevy",3)};
		int[] bInOneOrder = new int[] {0,1,0,0,0};
		TaskInsert bInsert = new TaskInsert(bList,bInOne,bInOneOrder);
		Thread bThreadInsert = new Thread(bInsert);
		bThreadInsert.start();
		while(bThreadInsert.isAlive());
		bList = bInsert.getList();
		bList.PrintList("count");
		bList.PrintList("forward");
		Object[] bOutOne = new Object[] {new Car("Ford",0)};
		TaskDelete bDelete = new TaskDelete(bList,bOutOne);
		Thread bThreadDelete = new Thread(bDelete);
		bThreadDelete.start();
		while(bThreadDelete.isAlive());
		bList = bDelete.getList();
		bList.PrintList("count");
		bList.PrintList("forward");
		bInOne = new Object[] {new Plane("Boeing",3,6), new Plane("Piper",2,1), new Plane("Cessna",4,4)};
		bInOneOrder = new int[] {1,1,1};
		bInsert = new TaskInsert(bList,bInOne,bInOneOrder);
		bThreadInsert = new Thread(bInsert);
		bThreadInsert.start();
		while(bThreadInsert.isAlive());
		bList = bInsert.getList();
		bList.PrintList("forward");
	}
}
class TaskInsert implements Runnable
{
	private DoublyLinkedList myList;
	private Object[] objArray;
	private int[] order;
	public TaskInsert(DoublyLinkedList myList, Object[] objArray, int[] order)
	{
		this.myList = myList;
		this.objArray = objArray;
		this.order = order;
	}
	
	@Override
	public void run() {
		try
		{
			for(int i=0; i<objArray.length;i++)
			{
				if(order[i]==1)
					myList.InsertFront(objArray[i]);
				else
					myList.InsertRear(objArray[i]);
			}
		}
		catch(Exception e)
		{
			System.out.println("THERE SEEMS TO BE AN ERROR AT INSERT THREAD");
		}
	}
	
	public DoublyLinkedList getList()
	{
		return myList;
	}
	
}
class TaskDelete implements Runnable
{
	private DoublyLinkedList myList;
	private Object[] objArray;
	public TaskDelete(DoublyLinkedList myList, Object[] objArray)
	{
		this.myList = myList;
		this.objArray = objArray;
	}
	
	@Override
	public void run() {
		try
		{
			for(int i=0; i<objArray.length;i++)
			{
				myList.Delete(objArray[i]);
			}
		}
		catch(Exception e)
		{
			System.out.println("THERE SEEMS TO BE AN ERROR AT DELETE THREAD");
		}
	}
	
	public DoublyLinkedList getList()
	{
		return myList;
	}
	
}