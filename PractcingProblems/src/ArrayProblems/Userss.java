package ArrayProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ArrayProblems.User.Usss;

public class Userss {

	public static void main(String[] args) {
	    ArrayList<User> users = new ArrayList<User>();
	    users.add(new User(1, 20000, "bb"));
	    users.add(new User(3, 40000, "aa"));
	    users.add(new User(2, 30000, "cc"));
	    users.add(new User(4, 50000, "dd"));
	    users.add(new User(5, 20000, "hh"));
	 
	//  List<User> user = users.stream().sorted((new Usss()).
			  List<User> sortedUsers = users.stream()
              .sorted(new Usss())
              .collect(Collectors.toList());
	//  List<User> user = users.stream().sorted().collect(Collectors.toList());
	  
	  System.out.println(sortedUsers);
	    

	}

}
