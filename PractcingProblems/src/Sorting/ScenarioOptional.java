package Sorting;

import java.lang.foreign.Linker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScenarioOptional {
	
	private int id;
	private String name;
	
	public ScenarioOptional(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ScenarioOptional [id=" + id + ", name=" + name + "]";
	}




	public static void main(String[] args) {
		//Given an employee DB fetch employee by id and return number of employee. if it is not present return default name using java 8     

		//Default value of with orElse()
		
		List<ScenarioOptional> scenarioOptional = new ArrayList<ScenarioOptional>();
		scenarioOptional.add(new ScenarioOptional(1, "Ramesh"));
		scenarioOptional.add(new ScenarioOptional(2, "Suresh"));
		
		if(!scenarioOptional.isEmpty())
		{
	String ofString	=	Optional.ofNullable(scenarioOptional.get(1).getName()).orElse("Anonymus");
	String ofString1	=	Optional.ofNullable(scenarioOptional.get(1).getName()).orElseGet(  () -> "Anonymus");
	  System.out.println(ofString);
		}
		
	
	}

}
