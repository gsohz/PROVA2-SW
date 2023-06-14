package pf02_sw;

import java.util.Date;

public class Orders {
	private int orders_id;
	private float purch_amt;
	private Date ord_date;
	private int customer_id;
	private int salesman_id;
	
	public Orders(float purch_amt, Date ord_date, int customer_id, int salesman_id) {
		this.purch_amt = purch_amt;
		this.ord_date = ord_date;
		this.customer_id = customer_id;
		this.salesman_id = salesman_id;
	}
	
	public Orders(int orders_id, float purch_amt, Date ord_date, int customer_id, int salesman_id) {
		this.orders_id = orders_id;
		this.purch_amt = purch_amt;
		this.ord_date = ord_date;
		this.customer_id = customer_id;
		this.salesman_id = salesman_id;
	}

	public int getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(int orders_id) {
		this.orders_id = orders_id;
	}

	public float getPurch_amt() {
		return purch_amt;
	}

	public void setPurch_amt(float purch_amt) {
		this.purch_amt = purch_amt;
	}

	public Date getOrd_date() {
		return ord_date;
	}

	public void setOrd_date(Date ord_date) {
		this.ord_date = ord_date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public int getSalesman_id() {
		return salesman_id;
	}

	public void setSalesman_id(int salesman_id) {
		this.salesman_id = salesman_id;
	}
	
	
}
