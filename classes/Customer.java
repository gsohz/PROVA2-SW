
/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */

public class Customer {
    protected int id;
    protected String name;
    protected String city;
    protected int grade;
    protected int id_salesman;    
 
    public Customer() {
    }

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String name, String city, int grade) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.grade = grade;
    }

    public Customer(int id, String name, String city, int grade, int id_salesman) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.grade = grade;
        this.id_salesman = id_salesman;
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
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public int getGrade() {
        return grade;
    }
 
    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getIdSalesman() {
        return id_salesman;
    }
 
    public void setIdSalesman(int id_salesman) {
        this.id_salesman = id_salesman;
    }
}
