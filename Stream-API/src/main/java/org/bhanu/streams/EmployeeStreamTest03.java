package org.bhanu.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamTest03 
{
	public static void main(String args[]) {
		List<Employee> list = new ArrayList<>();
		list.add(new Employee("Raju", 23, 65000.0, "Male"));
		list.add(new Employee("Suresh", 50, 36000.0, "Male"));
		list.add(new Employee("Dinesh", 33, 46000.0, "Male"));
		list.add(new Employee("Anjali", 23, 26000.0, "Female"));
		list.add(new Employee("Rani", 67, 86000.0, "Female"));
		list.add(new Employee("Queen", 42, 96000.0, "Female"));
		list.add(new Employee("Tarun", 19, 56000.0, "Male"));
		list.add(new Employee("Lokesh", 28, 16000.0, "Male"));
		list.add(new Employee("Manisha", 43, 76000.0, "Female"));
		list.add(new Employee("Nishanth", 36, 44000.0, "Male"));
			
	//1. Filter Employees by Gender having M:
		System.out.println("==1. Filter Employees by Gender having M:==".toUpperCase());
		list.stream().filter(emp->emp.getGender().startsWith("M")).forEach(System.out::println);
	//2. Filter Employees by Age older than 30 years:
		System.out.println("\n==2. Filter Employees by Age older than 30 years:==".toUpperCase());
		list.stream().filter(emp->emp.getAge()>30).forEach(System.out::println);
	//3. Filter Employees by Salary greater than $50,000:
		System.out.println("\n==3. Filter Employees by Salary greater than $50,000:==".toUpperCase());
		list.stream().filter(emp->emp.getSalary()>50000).forEach(System.out::println);
	//4. Create a list of employee names (Strings)
		System.out.println("\n==4. Create a list of employee names (Strings)==".toUpperCase());
		list.stream().map(Employee::getName).collect(Collectors.toList()).forEach(emp->System.out.print(emp + " | "));
		System.out.println();
	//5. Calculate the average salary of all employees:
		System.out.println("\n==5. Calculate the average salary of all employees:==".toUpperCase());
		double avg = list.stream().mapToDouble(Employee::getSalary).average().orElseThrow();
		System.out.println("Average of All Employee's: "+avg);
		System.out.println("==OR==");
		double avg1 = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println("Average of All Employee's:" + avg1);
	//6. Find the employee with the highest salary.
		System.out.println("\n==6. Find the employee with the highest salary.==".toUpperCase());
		Employee emp = list.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();
		System.out.println("Highest salary Paid To:" + emp);
	//7. Group Employees by Gender:
		System.out.println("\n==7. Group Employees by Gender:==".toUpperCase());
		list.stream().collect(Collectors.groupingBy(Employee::getGender)).forEach((k,v)->System.out.println(k + " " + v));
	//8. Count Male Employees:
		System.out.println("\n==8. Count Male Employees:==".toUpperCase());
		long count = list.stream().filter(emp1->emp1.getGender().startsWith("M")).count();
		System.out.println("Number of Male Employee's:" + count);
	//9. Sum of All Salaries:
		System.out.println("\n==9. Sum of All Salaries:==".toUpperCase());
		double sumOfAllSalary = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println("Sum of All Salary's:"+sumOfAllSalary);
		System.out.println("==OR==");
		double sumOfAllSalary1 = list.stream().mapToDouble(Employee::getSalary).sum();
		System.out.println("Sum of All Salary's:" + sumOfAllSalary1);
	//10. Sort the employees by their names in alphabetical order.
		System.out.println("\n==10. Sort the employees by their names in alphabetical order.==".toUpperCase());
		list.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
	//11. Sort Employees by Age in ascending Order:  
		System.out.println("\n==11. Sort Employees by Age in ascending Order:==".toUpperCase());
		list.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
	//12. Sort Employees by Age in descending Order:
		System.out.println("\n==12. Sort Employees by Age in descending Order:==".toUpperCase());
		list.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).forEach(System.out::println);
	//12. Sort Employees by Salary:
		System.out.println("\n==12. Sort Employees by Salary:==".toUpperCase());
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).forEach(System.out::println);
	//13. Find Oldest Employee:
		System.out.println("\n==13. Find Oldest Employee:==".toUpperCase());
		Employee employee = list.stream().max(Comparator.comparingDouble(Employee::getAge)).get();
		System.out.println("Oldest Employee: " + employee);
	//14. Group employees into age groups (e.g., 20-30, 31-40, etc.)
		System.out.println("\n==14. Group employees into age groups (e.g., 20-30, 31-40, etc.)==".toUpperCase());
		list.stream().collect(Collectors.groupingBy((emp1)-> {
			int age = emp1.getAge();
			if(age>=20 && age<=30) return "20-30";
			else if(age>=31 && age<=40) return "31-40";
			else return "40+";
		})).forEach((k, v)->System.out.println(k + " " + v));
		
	//15.Find all employees who are exactly 35 years old.
		System.out.println("\n==15.Find all employees who are exactly 35 years old.==".toUpperCase());
		list.stream().filter(emp1->emp1.getAge()==67).forEach(System.out::println);
	//16. Calculate the Sum of Salaries by Gender:
		System.out.println("\n==16. Calculate the Sum of Salaries by Gender:==".toUpperCase());
		list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.summingDouble(Employee::getSalary))).forEach((k,v)->System.out.println(k + " " + v));
	//17. Find Employees with Names Starting with "J":
		System.out.println("\n==17. Find Employees with Names Starting with \"J\":==".toUpperCase());
		list.stream().filter((emp1)->emp1.getName().startsWith("R")).forEach(System.out::println);
	//18. Calculate the Average Salary for Male and Female Employees:
		System.out.println("\n==18. Calculate the Average Salary for Male and Female Employees:==".toUpperCase());
		list.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary))).forEach((k,v)->System.out.println(k + " " + v));
	//19. Find the Top N Highest Paid Employees:
		System.out.println("\n==19. Find the Top N Highest Paid Employees:==".toUpperCase());
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(5).forEach(System.out::println);
	//20. Get a list of distinct ages of all employees.
		System.out.println("\n==20. Get a list of distinct ages of all employees.==".toUpperCase());
		list.stream().map(Employee::getAge).distinct().forEach((emp1)->System.out.print(emp1 + " | "));
		System.out.println();
	//21. Find the Three Lowest-Paid Employees:
		System.out.println("\n==21. Find the Three Lowest-Paid Employees:==".toUpperCase());
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).limit(3).forEach(System.out::println);
	//22. Sort Employees by Name Length:
		System.out.println("\n==22. Sort Employees by Name Length:==".toUpperCase());
		list.stream().sorted(Comparator.comparing((emp1)-> emp1.getName().length())).forEach(System.out::println);
//	23. Group Employees by Age Range:ranges (e.g., 20-29, 30-39, etc.)
		System.out.println("\n==23. Group Employees by Age Range:ranges (e.g., 20-29, 30-39, etc.)==".toUpperCase());
		list.stream().collect(Collectors.groupingBy((emp1)-> {
			int age = emp1.getAge();
			if(age>=20 && age<=29) return "20-29";
			else if(age>=30 && age<=39) return "30-39";
			else return "40+";
		})).forEach((k,v)->System.out.println(k + " " + v));
//	24. Find the Average Salary of Employees Aged 30 or Younger:
		System.out.println("\n==24. Find the Average Salary of Employees Aged 30 or Younger:==".toUpperCase());
		double avgSal = list.stream().filter(emp1->emp1.getAge()<=30).mapToDouble(Employee::getSalary).average().orElseThrow();
		System.out.println("Avg Salary of Employee's Aged below 30:" + avgSal);
//	25. Find the Names of Male Employees with Salaries Over $50,000:
		System.out.println("\n==25. Find the Names of Male Employees with Salaries Over $60,000:==".toUpperCase());
		list.stream().filter(emp1->emp1.getGender().startsWith("M") && emp1.getSalary()>=50000).map(Employee::getName).forEach(name->System.out.print(name + " | "));
//	26. Find the Youngest Female Employee
		System.out.println("\n==26. Find the Youngest Female Employee==".toUpperCase());
		list.stream().filter(emp1->emp1.getGender().startsWith("F")).sorted(Comparator.comparingInt(Employee::getAge)).limit(1).forEach(System.out::println);
//	27. Retrieve the Names of Employees in Reverse Order:
		System.out.println("\n==27. Retrieve the Names of Employees in Reverse Order(descending):==".toUpperCase());
		list.stream().sorted(Comparator.comparing(Employee::getName).reversed()).map(Employee::getName).forEach(name->System.out.print(name + " | "));
//	28. Find the Highest Salary Among Female Employees:
		System.out.println("\n==28. Find the Highest Salary Among Female Employees:==".toUpperCase());
		Employee femaleMaxSal = list.stream().filter(emp1->emp1.getGender().startsWith("F")).max(Comparator.comparingDouble(Employee::getSalary)).orElseThrow();
		System.out.println("Female with Max Salary:" + femaleMaxSal);
		System.out.println("==OR==");
		Employee femaleMaxSal1 = list.stream().filter(emp1->emp1.getGender().equalsIgnoreCase("Female")).collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))).orElseThrow();
		System.out.println("Female with Max Salary:" + femaleMaxSal1);
//	29. Group Employees by Age and Gender:
		System.out.println("\n==29. Group Employees by Age and Gender:==".toUpperCase());
		list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getGender))).forEach((k,v)->System.out.println(k + " " + v));
//	30. Find the Sum of Salaries for Employees with Names Containing "Suresh":
		System.out.println("\n==30. Find the Sum of Salaries for Employees with Names Containing \"Suresh\":==".toUpperCase());
		double sumOfSal = list.stream().filter(emp1->emp1.getName().equalsIgnoreCase("Suresh")).mapToDouble(Employee::getSalary).sum();
		System.out.println("Sum of Salaries for Employees with Names Containing:" + sumOfSal);
	}
}
