
public class Integer_Container implements Container_Interface {

	private Node head;
	private Node tail;
	
	Integer_Container()
	{
		head = new Node();
		tail = new Node();
	}

	@Override
	public void InsertFront(Object obj)
	{
		Node node = new Node(obj);
		tail = head;
		
		if(head.GetItem() == null)
		{
			head = node;
			System.out.println("NEW HEAD IS: "+head.GetItem());
		}
		else
		{
			while(tail.GetNext() != null)
				tail = tail.GetNext();
			tail.SetNext(node);
			node.SetPrev(tail);
			tail = node;
			System.out.println("NEW TAIL IS: "+tail.GetItem());
		}
	}

	@Override
	public void InsertRear(Object obj)
	{
		Node node = new Node(obj);
		
		node.SetNext(head);
		
		if(head.GetItem() != null)
			head.SetPrev(node);
		
		head = node;
		System.out.println("NEW HEAD IS: "+head.GetItem());
	}

	@Override
	public void Delete(Object obj)
	{
		Node node = head;
		Node tempNode = new Node();
		
		if(head.GetItem() == null)
			System.out.println("LIST IS EMPTY, NOTHING TO DELETE");
		else
		{
			while(node.GetItem() != obj && node.GetNext() != null)
				node = node.GetNext();
			
			if(node.GetItem() != obj)
				System.out.println("ELEMENT "+obj+" NOT FOUND, NOTHING TO DELETE");
			else if(node.GetPrev() == null)
			{
				head.GetNext().SetPrev(null);
				head = head.GetNext();
				System.out.println("ELEMENT "+obj+" REMOVED, NEW HEAD IS "+head.GetItem());
			}
			else if(node.GetNext() == null)
			{
				tail.GetPrev().SetNext(null);
				tail = tail.GetPrev();
				System.out.println("ELEMENT "+obj+" REMOVED, NEW TAIL IS "+tail.GetItem());
				
			}
			else
			{
				node.GetNext().SetPrev(node.GetPrev());
				node.GetPrev().SetNext(node.GetNext());
				System.out.println("REMOVED ELEMENT: "+obj);
			}
			
		}
	}

	@Override
	public int ListSize()
	{
		Node countNode = head;
		int count = 0;
		
		while(countNode!=tail)
		{
			countNode = countNode.GetNext();
			count++;
		}
		
		return count;
	}

	@Override
	public int FindItem(Object obj) 
	{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void PrintListRev()
	{
		Node prev = tail;
		
		while(prev != null)
		{
			System.out.print(prev.GetItem()+ " : ");
			prev = prev.GetPrev();
		}
		System.out.println("Front to Rear");
	}
	
	@Override
	public void PrintList()
	{
		Node next = head;
		while(next != null)
		{
			System.out.print(next.GetItem()+" : ");
			next = next.GetNext();
		}
		
		System.out.println("Rear to Front");
	}
}
