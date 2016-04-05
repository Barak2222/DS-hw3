public class MyHeap {
	protected Person[] holder;
	protected int maxSize;
	protected int size;

	// we ignore the 0 position at all arrays
	public MyHeap(Person[] p, int numPeople) {
		holder = new Person[numPeople + 1];
		maxSize = numPeople +1;
		size = numPeople;
		for (int i = 1; i <= numPeople; i++) {
			percDown(p[i], numPeople - i + 1);
		}
	}
	
	public MyHeap(){
		holder = new Person[2];
		maxSize = 1;
		size = 0;
	}

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

	public Person FindMax() {
		return holder[1];
	}

	public void insert(Person p) {
		if(size + 1 >= maxSize){
			resize();
		}
		size++;
		percUp(p, size);
	}
	
	private void resize(){
		maxSize = maxSize*2;
		Person[] holder2 = new Person[maxSize];
		for (int i = 0; i < holder.length; i++) {
			holder2[i] = holder[i];
		}
		holder = holder2;
	}
	

	public void DeleteMax() {
		if(size <= 0){
			throw new IllegalArgumentException("heap is empty, cannot delete");
		}
		percDown(holder[size], 1);
		size--;
	}

	public void print(){
		System.out.print("arr: [");
		for(int i = 0; i <= size; i++){
			System.out.print(holder[i] + " |");
		}
		System.out.println("]");
	}
}
