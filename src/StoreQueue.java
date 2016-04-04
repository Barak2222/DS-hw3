public class StoreQueue {
	MyHeap q;
	MyLinkedList records;
	
	public StoreQueue() {
		records = new MyLinkedList();
		q = new MyHeap();
	}
	
	// array starts from 1
	public StoreQueue(Person[] p,int numPeople) {
		records = new MyLinkedList();
		q = new MyHeap(p, numPeople);
	}

	public void enqueue(Person person) {
		q.insert(person);
	}

	public Person dequeue() {
		Person p = q.FindMax();
		q.DeleteMax();
		records.insert(p);
		return p;
	}

	public Person firstInQueue() {
		if(q.size <= 0){
			return null;
		}
		return q.FindMax();
	}
	
	//counting starts from 1(not 0)
	public Person returnNthPersonInRecord(int n){
		try{
			return records.get(n);
		} catch(NullPointerException e){
			return null;
		}
	}
	public void deleteNthPersonFromRecord(int n){
	}
	public Person returnPersonFromRecord(int id){

	}
	public void deletePersonFromRecord(int id){
	}
}
