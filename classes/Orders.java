/*
 * Gabriel Ferreira de Souza
 * Guilherme Ferreira Santos
 */
import java.sql.Date;


public class Orders {
    protected int id;
    protected float purch_amt;
    protected Date ord_date;
    protected int id_customer;
    protected int id_salesman;
 
    public Orders(){
    }

    public Orders(int id){
        this.id = id;
    }
    
    public Orders(int id, float purch_amt, Date ord_date, int id_customer, int id_salesman){
        this.id = id;
        this.purch_amt = purch_amt;
        this.ord_date = ord_date;
        this.id_customer = id_customer;
        this.id_salesman = id_salesman;
    }

     public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }

    public float getPurchAmt() {
        return purch_amt;
    }
 
    public void setPurchAmt(float purch_amt) {
        this.purch_amt = purch_amt;
    }

    public Date getOrdDate() {
        return ord_date;
    }
 
    public void setOrdDate(Date ord_date) {
        this.ord_date = ord_date;
    }

    public int getIdCustomer() {
        return id_customer;
    }
 
    public void setIdCustomer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getIdSalesman() {
        return id_salesman;
    }
 
    public void setIdSalesman(int id_salesman) {
        this.id_salesman = id_salesman;
    }

}
