
/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */

public class Salesman {
    protected int id;
    protected String name;
    protected String city;
    protected float comission;
 
    public Salesman() {
    }

    public Salesman(int id) {
        this.id = id;
    }

    public Salesman(int id, String name, String city, float comission) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.comission = comission;
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
 
    public float getComission() {
        return comission;
    }
 
    public void setComission(float comission) {
        this.comission = comission;
    }
}
