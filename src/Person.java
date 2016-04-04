public class Person {
		private int id;
		private int age;
		
		
		public Person(int id, int age) {
			this.id = id;
			this.age = age;
		}


		public int getId() {
			return id;
		}


		public int getAge() {
			return age;
		}
		
		// print only age
		public String toString(){
			return "" + age;
		}
}
