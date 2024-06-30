package functionalprogramming;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Studentmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = Arrays.asList(
				new Student(1, "Rohit", "Mall", 30, "Male", "Mechanical Engineering", 2015, "Mumbai", 122),
				new Student(2, "Pulkit", "Singh", 56, "Male", "Computer Engineering", 2018, "Delhi", 67),
				new Student(3, "Ankit", "Patil", 25, "Female", "Mechanical Engineering", 2019, "Kerala", 164),
				new Student(4, "Satish Ray", "Malaghan", 30, "Male", "Mechanical Engineering", 2014, "Kerala", 26),
				new Student(5, "Roshan", "Mukd", 23, "Male", "Biotech Engineering", 2022, "Mumbai", 12),
				new Student(6, "Chetan", "Star", 24, "Male", "Mechanical Engineering", 2023, "Karnataka", 90),
				new Student(7, "Arun", "Vittal", 26, "Male", "Electronics Engineering", 2014, "Karnataka", 324),
				new Student(8, "Nam", "Dev", 31, "Male", "Computer Engineering", 2014, "Karnataka", 433),
				new Student(9, "Sonu", "Shankar", 27, "Female", "Computer Engineering", 2018, "Karnataka", 7),
				new Student(10, "Shubham", "Pandey", 26, "Male", "Instrumentation Engineering", 2017, "Mumbai", 98));

		//1- Find list of students whose first name starts with alphabet A
		students.stream().filter(s -> s.getFirstName().startsWith("R")).forEach(System.out::println);
		
		//2- Group The Student By Department Names
		Map<String, List<Student>> depname = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName));
		System.out.println(depname);
		
		//3- Find the total count of student using stream
		long count = students.stream().count();
		System.out.println(count);
		
		//4- Find the max age of student
		OptionalInt max = students.stream().mapToInt(st -> st.getAge()).max();
		System.out.println("Max age is " + max);

		//5- Find all departments names
		List<String> alldepname = students.stream().map(st -> st.getDepartmantName()).distinct().collect(Collectors.toList());
		System.out.println(alldepname);
		
		//6- Find the count of student in each department
		Map<String, Long> studentsInallDept = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting()));
		System.out.println("Students in all department "+ studentsInallDept);
		
		//7- Find the list of students whose age is less than 30
		List<Student> below_30_age = students.stream().filter(s -> s.getAge() < 30).collect(Collectors.toList());
		System.out.println("Students below 30 "+ below_30_age);
		
		//8- Find the list of students whose rank is in between 50 and 100
		List<Student> rank = students.stream().filter(s -> s.getRank() >= 50 && s.getRank() <= 100).collect(Collectors.toList());
		System.out.println("List of students whose rank is between 50 and 100 : "+rank);
		
		//9- Find the average age of male and female students
		Map<String, Double> mapAvgAge = students.stream().collect(Collectors.groupingBy(Student:: getGender, Collectors.averagingInt(Student::getAge)));
		System.out.println("Average age of male and female students : "+mapAvgAge);
		
		//10- Find the department who is having maximum number of students
		Entry<String, Long> entry = students.stream()
			    .collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.counting())).entrySet().stream()
			    .max(Map.Entry.comparingByValue()).get();
			System.out.println("Department having maximum number of students : "+entry);
			
	   //12- Find the average rank in all departments
	   Map<String, Double> avgRank = students.stream().collect(Collectors.groupingBy(Student :: getDepartmantName, Collectors.averagingInt(Student::getRank)));
	   System.out.println("Average rank in all departments  : "+avgRank);

	   //13- Find the highest rank in each department
	   Map<String, Optional<Student>> studentData = students.stream().collect(Collectors.groupingBy(Student::getDepartmantName, Collectors.maxBy(Comparator.comparing(Student::getRank))));
	   System.out.println("Highest rank in each department  : "+studentData);

	}

}
