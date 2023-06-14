package pf02_sw;
public class Salesman {
	private int salesman_id;
	private String name;
	private String city;
	private float comission;
	
	public Salesman(String name, String city, float comission) {
		this.name = name;
		this.city = city;
		this.comission = comission;
	}
	
	public Salesman(int salesman_id, String name, String city, float comission) {
		this.salesman_id = salesman_id;
		this.name = name;
		this.city = city;
		this.comission = comission;
	}
	
	public int getSalesman_id() {
		return salesman_id;
	}
	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getComission() {
		return comission;
	}
	public void setComission(float comission) {
		this.comission = comission;
	}
}
