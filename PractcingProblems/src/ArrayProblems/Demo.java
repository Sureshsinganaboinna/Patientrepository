package ArrayProblems;

import java.io.FileInputStream;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Employee implements Serializable{
	 String name;
	 int num;
	 
	 public Employee(String name, int num)
	 {
		 this.name = name;
		 this.num = num;
	 }

}

public class Demo {
	//Serialization and deserialization in Java are used when you need to save the state of an object to a file, database, 
	//or send it over a network, and later reconstruct it back into an object.
// serilazation is a process of converting an object into a sequence of byte streans which can be 
	//persist to a disk or database or can be sent through streams
	
	//Deserilation is a reverse process of creating object from sequence of byte streams.
	//Example: In distributed applications like microservices, serialization is used to transfer data between services.
																								
	//An enum (short for enumeration) in Java is a special data type that represents a fixed set of constants. 
	//It is used to define a collection of predefined, unchangeable values, making the code more readable and type-safe.
	
	//upcasting means create an object of child class and assigning it to a variable of parent class.
	
	//Exception handling allows us to run our programms smoothly by managing run time errors
	//try:- write the code that might occur exception
	//catch :- handles the exception if it is occcur in try block
	//finally :- it executes always irrespective of try- catch block. it is used for cleanup like closing files
	//throw key word is used to explicitly create and throw an exception in your code.
	//throws keyword is Used to declare exceptions at the method level
	
	//Both HashMap and ConcurrentHashMap are classes (not interfaces), and both implement the Map interface. However, 
	//ConcurrentHashMap is part of the concurrent utilities and is specifically optimized for thread-safe operations.
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		
		FileInputStream fIn = new FileInputStream("D:\\suresh.ser");
		ObjectInputStream obje = new ObjectInputStream(fIn);
	     Employee employee = (Employee) obje.readObject();
	     fIn.close();
	     obje.close();
	   //  System.out.println(employee.name +"and"+ employee.num);
	
//		Employee e1 = new Employee("suresh", 232);
//		FileOutputStream outputStream = new FileOutputStream("D:\\suresh.ser");
//		ObjectOutputStream pObjec = new ObjectOutputStream(outputStream);
//		
//		pObjec.writeObject(e1);
//		outputStream.close();
//		pObjec.close();
//		System.out.println("success");
		}
	}


