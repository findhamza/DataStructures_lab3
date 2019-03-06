
public class Node {

	private Node next;
	private Node prev;
	private Object obj;
	
	Node()
	{
		next = null;
		prev = null;
		obj = null;
	}
	
	Node(Object obj)
	{
		next = null;
		prev = null;
		this.obj = obj;
	}
	
	Node(Node next, Node prev, Object obj)
	{
		this.next = next;
		this.prev = prev;
		this.obj = obj;
	}
	
	public void SetNext(Node next)
	{
		this.next = next;
	}
	
	public Node GetNext() 
	{
		return next;
	}
	
	public void SetPrev(Node prev)
	{
		this.prev = prev;
	}
	
	public Node GetPrev()
	{
		return prev;
	}
	
	public void SetItem(Object obj)
	{
		this.obj = obj;
	}
	
	public Object GetItem()
	{
		return obj;
	}
}
