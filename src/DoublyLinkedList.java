//Author: Hamza Syed
//Class: COSC3319
//Lab 3 Option A

public class DoublyLinkedList implements DDL_Interface {

	private Node headNode;
	private Node tailNode;
	private int elementCount;
	
	DoublyLinkedList()
	{
		elementCount = 0;
		headNode = new Node(headNode, elementCount, headNode);
	}
	
	@Override
	public void InsertFront(Object obj)
	{
		if(tailNode == null)
		{
			tailNode = new Node(headNode, obj, headNode);
			headNode.SetNext(tailNode);
			headNode.SetPrev(tailNode);
			headNode.SetItem(ListSize());
		}
		else
		{
			tailNode = new Node(tailNode, obj, headNode);
			tailNode.GetPrev().SetNext(tailNode);
			headNode.SetPrev(tailNode);
			headNode.SetItem(ListSize());
		}
		
		System.out.println("ADDED ELEMENT "+obj+" TO THE RIGHT");
	}

	@Override
	public void InsertRear(Object obj)
	{
		if(tailNode == null)
		{
			tailNode = new Node(headNode, obj, headNode);
			headNode.SetNext(tailNode);
			headNode.SetPrev(tailNode);
			headNode.SetItem(ListSize());
		}
		else
		{
			Node node = new Node(headNode, obj, headNode.GetNext());
			headNode.GetNext().SetPrev(node);
			headNode.SetNext(node);
			headNode.SetItem(ListSize());
		}
		
		System.out.println("ADDED ELEMENT "+obj+" TO THE LEFT");
	}

	@Override
	public void Delete(Object obj)
	{
		Node next = headNode;
		while(next.GetNext() != headNode)
		{
			if(next.GetObj().equals(obj))
			{
				next.GetPrev().SetNext(next.GetNext());
				next.GetNext().SetPrev(next.GetPrev());
				headNode.SetItem(ListSize());
				System.out.print(obj+" REMOVED FROM LIST\n");
				return;
			}
			else
				next = next.GetNext();
		}
		System.out.print(obj+" NOT FOUND IN LIST\n");
	}

	@Override
	public int ListSize()
	{
		Node next = headNode;
		elementCount = 0;
		while(next.GetNext() != headNode)
		{
			elementCount++;
			next = next.GetNext();
		}
		return elementCount;
	}

	@Override
	public int FindItem(Object obj)
	{
		int position = 0;
		Node next = headNode;
		while(next.GetNext() != headNode)
		{
			position++;
			if(next.GetItem().equals(obj))
				return position;
			else
				next = next.GetNext();
		}
		return 0;
	}

	@Override
	public void PrintList(String order)
	{
		Node next = headNode;
		
		if(order.equals("forward"))
			while(next.GetNext() != headNode)
			{
				next = next.GetNext();
				System.out.print(next.GetItem());
				if(next.GetNext() != headNode)
					System.out.print(" >> ");
			}
		
		else if(order.equals("backward"))
			while(next.GetPrev() != headNode)
			{
				next = next.GetPrev();
				System.out.print(next.GetItem());
				if(next.GetPrev() != headNode)
					System.out.print(" << ");
			}
		else
			System.out.print("List Size: "+ListSize());
		System.out.println();
	}

}
