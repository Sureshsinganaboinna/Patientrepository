package Pro;

public class Emplo {
	
	private int id;
	private String name;
	private String department;
	
	
	public Emplo(int id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setDepartment(String department)
	{
		this.department = department;
		
	}
	public String getDepartment()
	{
		return department;
	}

	@Override
	public String toString() {
		return "Emplo [id=" + id + ", name=" + name + ", department=" + department + "]";
	}
	

}



 





