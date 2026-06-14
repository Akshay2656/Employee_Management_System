import java.util.*;

class Employee{
	private int empId;
	private String empName;
	private double salary;
	private String joiningDate;
	private String department;
	
	Employee(int empId, String empName, double salary, String joiningDate, String department)
	{
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.joiningDate = joiningDate;
		this.department = department;
	}
	
	public void setId(int empId){
		this.empId = empId;
	}
	
	public int getId(){
		return empId;
	}
	
	public void setName(String empName){
		this.empName = empName;
	}
	
	public String getName(){
		return empName;
	}
	
	public void setSalary(double salary){
		this.salary = salary;
	}

	public double getSalary(){
		return salary;
	}

	public void setJoiningDate(String joiningDate){
		this.joiningDate = joiningDate;
	}
	
	public String getJoiningDate(){
		return joiningDate;
	}	
	
	public void setDepartment(String department){
		this.department = department;
	}
	
	public String getDepartment(){
		return department;
	}
	
	public String toString(){
		return "EmployeeId:"+empId+"\nEmployeeName :"+empName+"\nEmployeeSalary: "+salary+"\nEmployeeJoining"+joiningDate+"\nEmployee Department: "+department;
	}
}

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		List<Employee> employees = new ArrayList<>();		
			
		while(true){
			System.out.println("=============================================");
			System.out.println("||  Welcome to Employee Management System  ||");
			System.out.println("=============================================");
			System.out.println("1. Add Employee");
			System.out.println("2. Remove Employee");
			System.out.println("3. Search Employee By ID: ");
			System.out.println("4. Update Salary: ");
			System.out.println("5. Display All Employee");
			System.out.println("6. Find Highest Paid Employee: ");
			System.out.println("7. Group Employee by Department: ");
			System.out.println("8. Sort by Salary: ");
			System.out.println("9. Sort by Joining Date: ");
			System.out.println("10. Exit");
			
			System.out.println("Enter Your Choice");
			int choice = sc.nextInt();	
			
			switch(choice){
				case 1: System.out.println("Enter your Id: ");
						int empId = sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter your Name: ");
						String empName = sc.nextLine();
						
						System.out.println("Enter Your salary: ");
						double salary = sc.nextDouble();
						sc.nextLine();
						
						System.out.println("Enter Date of Joining: ");
						String joiningDate = sc.nextLine();
						
						System.out.println("Enter Department Name: ");
						String department = sc.nextLine();
						
						employees.add(new Employee(empId, empName, salary, joiningDate, department));
						System.out.println("Employee Added Successfully");
						break;
				
				case 2: System.out.println("Enter Employee id to remove"); 
						int removeId = sc.nextInt();
						
						boolean isFound = false;
						
						Iterator<Employee> itr = employees.iterator();
						
						while(itr.hasNext()){
							Employee emp = itr.next();
							if(emp.getId() == removeId){
									itr.remove();
									isFound = true;
									System.out.println("Employee Removed Successfully");
									
									break;
							}
						}
						
						if(!isFound){
							System.out.println("Employee ID Not Found");
						}

						break;
						
				case 3: System.out.println("Enter Employee id to Search");
						int searchId = sc.nextInt();
						
						boolean found = false;
						
						for(Employee emp : employees){
							if (emp.getId() == searchId){
								System.out.println(emp);
								System.out.println("Employee Found Successfully");
								found = true;
								break;
							}
						}
						
						if(!found){
							System.out.println("Employee ID Not Found"); 
						}
						
						break;
						
				case 4: System.out.println("Enter Id to Update: ");
						int updateId = sc.nextInt();
						sc.nextLine();
						
						boolean isUpdate = false;
						
						for (Employee emp : employees){
							if (emp.getId() == updateId){								 
								System.out.println("Enter Salary to update");
								double newSalary = sc.nextDouble();
								emp.setSalary(newSalary);
								
								isUpdate = true;
								
								System.out.println("Employee Salary Updated Successfully");
								System.out.println("=============================================");
								break;
							}
						}
						
						if(!isUpdate){
							System.out.println("Employee Not found");
						}
						
						break;
				
				case 5: System.out.println("5. Display All Employee");
						for (Employee emp : employees){
							System.out.println(emp);
						}
						break;
				
				case 6: System.out.println("6. Find Highest Paid Employee: ");
											
						if(employees.isEmpty()){
							System.out.println("Employee not found");
						}
						else{
							Employee highestPaidEmployee = employees.get(0);
							
							for (Employee emp : employees){
								if (emp.getSalary() > highestPaidEmployee.getSalary()){
									highestPaidEmployee = emp;
								}
							}
							System.out.println(highestPaidEmployee);
						}
						break;
				
				case 7: System.out.println("7. Group Employee by Department: ");
						Map<String, List<Employee>> deptMap = new HashMap<>();
						
						for(Employee emp : employees){
							String dept = emp.getDepartment();
							
							if (!deptMap.containsKey(dept)){
								deptMap.put(dept, new ArrayList<>());
							}
							
							deptMap.get(dept).add(emp);
						}	

						System.out.print(deptMap);
						break;
				
				case 8: System.out.println("8. Sort by Salary: ");
						for (int i = 0; i < employees.size(); i++){
							for(int j = i + 1; j < employees.size(); j++){
								if (employees.get(i).getSalary() > employees.get(j).getSalary()){
									Employee temp = employees.get(i);
									employees.set(i, employees.get(j));
									employees.set(j, temp);	
								}
							}
						}
						
						for(Employee emp : employees){
							System.out.println(emp);
							System.out.println("=============================================");
						}
						
						break;
				
				case 9: System.out.println("9. Sort by Joining Date: ");
								
						break;		
						
				case 10: System.exit(0);	
			}
		}
	}
}

