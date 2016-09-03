public class AddressBook {
	private ContactLinkedList myContacts;
	private int size;
	private int MAX_SIZE;

	public AddressBook(){
		MAX_SIZE = 20;
		myContacts = new ContactLinkedList();
		size = 0;
	}

	public ContactLinkedList getMyContacts() {
		return myContacts;
	}

	public void setMyContacts(ContactLinkedList myContacts) {
		this.myContacts = myContacts;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getMAX_SIZE() {
		return MAX_SIZE;
	}

	public boolean add(Contact newContact){
		if (size >= MAX_SIZE){
			return false;
		}
		else
		{
			myContacts.add(newContact);
			size ++;
			return true;
		}
	}
	
	public boolean add(int addInt, Contact newContact){
		if (size >= MAX_SIZE){
			return false;
		}
		else
		{
			myContacts.add(addInt, newContact);
			size ++;
			return true;
		}
	}
	
	public void print(){
		myContacts.print();
	}
	
	public Contact remove(int x){
		Contact removed = myContacts.remove(x);
		return removed;
	}
	public Contact find(int x){
		Contact found = myContacts.get(x);
		return found;
	}
	
}


//Find Contact
//Remove Contact

	
/*	public Contact remove(String fn, String ln){
		Contact removed = myContacts.remove(fn);
		return removed;
	}
/*		Contact tempContact;
		for (int x = 0; x < size; x++){
			if (fn.equals(myContacts[x].getFirstName()) && ln.equals(myContacts[x].getLastName())){
				 tempContact = myContacts[x];
				 for (int i = x;i < size;i++){
					 myContacts[i] = myContacts[i+1];
					 myContacts[size - 1] = null;
					 size -= 1;
				 }
				 return tempContact;
			}
		}
		return null;
	}*/

