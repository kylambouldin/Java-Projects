
public class ContactLinkedList {
		// attributes
		private ContactNode first = null;
		private ContactNode last = null;
		private int size = 0;

		// default constructor
		public ContactLinkedList()
		{
		}

		// remove(int index) - removes a Node and number at a particular index
		public Contact remove(int index)
		{
			//0) removing from index out of bounds
			if (index >= size || index < 0)
			{
				return null;
			}

			//1) remove from empty LL - return error code
			if (size == 0)
			{
				return null;
			}

			//2) remove last Node from LL
			if (index == 0 && first == last)	// if (size == 1)
			{
				Contact tmp = first.contact;
				first = null;
				last = null;
				size--;
				return tmp;
			}

			//3) remove from the middle (b/w first and last) of the LL
			if (index != 0 && index != size -1)
			{
				int count = 0;
				ContactNode previous = first;
				for (ContactNode current = first; current != null; current = current.next)
				{
					//if you are at the correct current, set the previous next to the current's next
					if (count == index)
					{
						Contact x = current.contact;
						previous.next = current.next;
						size--;
						return x;
					}

					previous = current;
					count++;
				}
			}

			//4) remove from the first
			if (index == 0 && first != last)
			{
				Contact tmp = first.contact;
				first = first.next;
				size--;
				return tmp;
			}

			//5) remove from the last
			if ( index == size - 1 && size > 1)
			{
				Contact tmp = last.contact;

				for (ContactNode current = first; current != null; current = current.next)
				{
					if (current.next == last)
					{
						last = current;
						last.next = null;	//current.next = null;
						size--;
						return tmp;
					}
				}
				return tmp;
			}
			return null;
		}
		
		// add() adds a new number to the end of the LinkedList
		public void add(Contact contact)
		{

			//1st case - appending to empty LL
			if (isEmpty())
			{
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				first = myNode;
				last = first;
				size++;
			}
			//2nd case - appending to non-empty LL
			else if (!isEmpty())
			{
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				last.next = myNode;
				last = myNode;
				size++;
			}
		}
		
		//add num to the location index
		public void add(int index, Contact contact)
		{
				//0) adding to empty LL
			if (isEmpty() && index == 0)
			{
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				first = myNode;
				last = first;
				size++;
			}
				//1) adding to the first (beginning)
			else if (index == 0){
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				ContactNode tmp = first;
				myNode.next = tmp;
				first = myNode;
				size++;
			}
			//2) adding to the last (end)
			else if (index == size){
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				last.next = myNode;
				last = myNode;
				size++;
			}
			//3) adding to the middle
			else if (index != 0 && index < size){
				ContactNode myNode = new ContactNode();
				myNode.contact = contact;
				int count = 0;
				for (ContactNode current = first; current != null; current = current.next){
					if (count == index-1){
						ContactNode tmp = current.next;
						current.next = myNode;
						myNode.next = tmp;
						size ++;
					}
					count++;
				}
			}
			//4) adding to an index that is out of bounds
			else if (index > size + 1 || index < 0)
			{
				System.out.println("Out of bounds");
			}
		}
		
		public boolean isEmpty(){
			return size == 0;
		}
		public int size(){
			return size;
		}

		public Contact getFirst(){
			return first.contact;
		}
		
		public Contact getLast(){
			return last.contact;
		}
		
		public void clear(){
			first = null;
			last = null;
			size = 0;
		}
		
		public void print(){
			if (!isEmpty()){
				System.out.print("Front: ");
				for(ContactNode currentNode = first; currentNode != null; currentNode = currentNode.next)
				{
					System.out.print(currentNode.contact.firstName + " " + currentNode.contact.lastName + "-->");
				}
				System.out.println("null");
			}
			else
				System.out.println("List is Empty");
		}

		public Contact get(String firstName){
			for (ContactNode current = first; current != null; current = current.next){
				if (firstName == current.contact.firstName){
					return current.contact;
				}
			}
			return null;
		}
		

		public void addFirst(Contact contact){
			ContactNode myNode = new ContactNode();
			myNode.contact = contact;
			ContactNode tmp = first;
			myNode.next = tmp;
			first = myNode;
		}
		
		public void addLast(Contact contact){
			ContactNode myNode = new ContactNode();
			myNode.contact = contact;
			last.next = myNode;
		}
			
		public Contact removeFirst(){
			if (!isEmpty()){
				Contact tmp = first.contact;
				first = first.next;
				return tmp;
			}
			else
				return null;
		}
		
		public Contact removeLast(){
			if (!isEmpty()){
				Contact tmp = last.contact;
				for (ContactNode current = first; current != null; current = current.next)
				{
					if (current == last)
					{
						last = current;
						last.next = null;	//current.next = null;
						size--;
						return tmp;
					}
				}
			}
			return null;
		}
		
		
		public Contact get(int index){
			int count = 0;
			for (ContactNode current = first; current != null; current = current.next){
				if (count == index){
					return current.contact;
				}
				count++;
			}
			return null;
		}
}
