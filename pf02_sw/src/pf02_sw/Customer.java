package pf02_sw;
public class Customer {
	private int customer_id;
	private String name;
	private String city;
	private float grade;
	private int salesman_id;
	
	public Customer(String name, String city, float grade) {
		this.name = name;
		this.city = city;
		this.grade = grade;
	}
	
	public Customer(int customer_id, String name, String city, float grade) {
		this.customer_id = customer_id;
		this.name = name;
		this.city = city;
		this.grade = grade;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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

	public float getGrade() {
		return grade;
	}

	public void setGrade(float grade) {
		this.grade = grade;
	}

	public int getSalesman_id() {
		return salesman_id;
	}

	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	
}
