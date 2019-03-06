
public class Containers {

	public static void main(String[] args) 
	{
		
		Integer_Container intList = new Integer_Container();

		//Insert in front (right)
		intList.InsertFront(33);
		intList.InsertFront(57);
		
		//Insert in rear (left)
		intList.InsertRear(85);
		intList.InsertRear(62);
		
		//Insert in front (right)
		intList.InsertFront(95);

		//Print front to rear
		intList.PrintListRev();
		
		//Print rear to front
		intList.PrintList();
		
		//Delete node
		intList.Delete(57);
		intList.Delete(33);
		intList.Delete(33);
		intList.Delete(62);
		
		//Insert in front (right)
		intList.InsertFront(22);
		
		//Delete node
		intList.Delete(95);
		
		//Print front to rear
		intList.PrintListRev();
		
		//System.out.println("HELLO WORLD");
	}

}
