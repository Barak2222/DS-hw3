public class MyHeap2 {
	protected Person[] holder;
	protected int maxSize;
	protected int size;

	/***
	 * 
	 * @param p array of people
	 * @param numPeople number of people
	 */
	// we ignore the 0 position at "holder"
	public MyHeap2(Person[] p, int numPeople) {
		holder = new Person[numPeople + 1];
		maxSize = numPeople +1;
		size = numPeople;
		for (int i = 0; i < numPeople; i++) {
			percDown(p[i], numPeople - i);
		}
	}
	
	/***
	 * Empty constructor
	 */
	public MyHeap2(){
		holder = new Person[2];
		maxSize = 1;
		size = 0;
	}

	/***
	 * 
	 * @param p person to add
	 * @param i	position
	 */
	private void percDown(Person p, int i) {
		if (2 * i > size) {
			holder[i] = p;
		} else if (2 * i == size) {
			if (holder[2 * i].getAge() > p.getAge()) {
				holder[i] = holder[2 * i];
				holder[2 * i] = p;
			} else {
				holder[i] = p;
			}
		} else {
			int look = (holder[2 * i].getAge() > holder[2 * i + 1].getAge()) ? 2 * i : 2 * i + 1;
			if(holder[look].getAge() > p.getAge()){
				holder[i] = holder[look];
				percDown(p, look);
			} else {
				holder[i] = p;
			}
		}
	}

	/***
	 * 
	 * @param p person to add
	 * @param i position
	 */
	private void percUp(Person p, int i) {
		if( i == 1){
			holder[i] = p;
			return ;
		}
		if(p.getAge() < holder[i/2].getAge()){
			holder[i] = p;
			return ;
		}
		holder[i] = holder[i/2];
		percUp(p, i/2);
	}

	/***
	 * 
	 * @return The oldest person
	 */
	public Person FindMax() {
		return holder[1];
	}
	
	/***
	 * 
	 * @param p person to insert
	 */
	public void insert(Person p) {
		if(size + 1 >= maxSize){
			resize();
		}
		size++;
		percUp(p, size);
	}
	
	/***
	 * utility function that doubles the maxSize
	 */
	private void resize(){
		maxSize = maxSize*2;
		Person[] holder2 = new Person[maxSize];
		for (int i = 0; i < holder.length; i++) {
			holder2[i] = holder[i];
		}
		holder = holder2;
	}
	
	/***
	 * delete the oldest person from the heap
	 */
	public void DeleteMax() {
		if(size <= 0){
			throw new IllegalArgumentException("heap is empty, cannot delete");
		}
		percDown(holder[size], 1);
		size--;
	}

	/***
	 * prints the heap
	 */
	public void print(){
		System.out.print("arr: [");
		for(int i = 0; i <= size; i++){
			System.out.print(holder[i] + " |");
		}
		System.out.println("]");
	}
}
