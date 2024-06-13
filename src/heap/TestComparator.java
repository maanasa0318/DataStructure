package heap;

import java.util.Comparator;

public class TestComparator{

	public static void main(String[] args) {
		Student s1 = new Student("Maanasa", 90);
		Student s2 = new Student("Rohit", 98);
		
		System.out.println(s2.compare(s2, s1));
		
	}
	
	
}

 class Student implements Comparator<Student>{
	 String name; 
	 int marks;
	 

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}


	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getMarks() >= o2.getMarks()) {
			return 1;
		}
		else if (o1.getMarks() == o2.getMarks()) {
			return 0;
		}
		else if (o1.getMarks() <= o2.getMarks()) {
			return -1;
		}
		return -1;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public int getMarks() {
		return marks;
	}


	public void setMarks(int marks) {
		this.marks = marks;
	}



}
