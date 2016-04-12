public class StoreQueue {
	MyHeap q;
	MyLinkedList records;
	
	/***
	 * Empty constructor
	 */
	public StoreQueue() {
		records = new MyLinkedList();
		q = new MyHeap();
	}
	
	/***
	 * Constructor
	 * @param p Array of people
	 * @param numPeople number of people in the array
	 */
	public StoreQueue(Person[] p,int numPeople) {
		records = new MyLinkedList(p, numPeople);
		q = new MyHeap(p, numPeople);
	}

	/***
	 * Add a person to the queue
	 * @param person a given person
	 */
	public void enqueue(Person person) {
		q.insert(person);
		records.insert(person);
	}

	/***
	 * remove the oldest person from the queue
	 * @return the removed person
	 */
	public Person dequeue() {
		Person p = q.FindMax();
		q.DeleteMax();
		return p;
	}

	/***
	 * 
	 * @return the first in queue
	 */
	public Person firstInQueue() {
		if(q.size <= 0){
			return null;
		}
		return q.FindMax();
	}
	
	/***
	 * get the nth person in records
	 * @param n index
	 * @return Person
	 */
	//counting starts from 1(not 0)
	public Person returnNthPersonInRecord(int n){
		try{
			return records.get(records.size - n + 1);
		} catch(NullPointerException e){
			return null;
		}
	}
	
	/***
	 * Delete the nth person in records
	 * @param n
	 */
	public void deleteNthPersonFromRecord(int n){
		Person p;
		try{
			p = records.get(records.size - n + 1);
		} catch(NullPointerException e){
			p = null;
		}
		if(p != null){
			records.delete(p);
		}
	}
	
	/***
	 * get a person from records that matches the id
	 * @param id of a needed person
	 * @return the needed person
	 */
	public Person returnPersonFromRecord(int id){
		return records.find(id);
	}
	
	/***
	 * Delete a person from records that mathces the given id
	 * @param id number
	 */
	public void deletePersonFromRecord(int id){
		records.delete(records.find(id));
	}
}
