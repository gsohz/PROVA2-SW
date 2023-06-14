<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Prova 2 SW</title>
</head>
<body>
     <center>
        <h1>Prova 2 SW</h1>
        <table border="1" cellpadding="5">
        <tr>
        <th>
            <a href="list">Lista</a>
		</th>
		<th>
            <a href="newSalesman">Add Vendedor</a>
		</th>
		<th>
            <a href="newCustomer">Add Novo Cliente</a>
	    </th>
	    <th>
            <a href="newOrders">Add Novo Pedido</a>
        </th>
        <th>
            <a href="/pf02_sw/Creditos">Créditos</a>
        </th>
        </tr>
        </table>
    </center>
    
    <div align="center">
        <form action="insertOrders" method="post">
	        <table border="1" cellpadding="5">
	            <caption>
	                <h2>Add Novo Pedido</h2>
	            </caption>          
	            <tr>
	            	<th>Valor de Compra: </th>
	                <td>
	                    <input type="number" name="purch_amt" size="45" />
	                </td>
	            </tr>
	            <tr>
	                <th>Data: </th>
	                <td>
	                    <input type="date" name="ord_date" size="45" />
	                </td>
	            </tr>
	            <tr>
	                <th>Cliente Id: </th>
	                <td>
	                    <input type="number" name="customer_id" size="5" />
	                </td>
	            </tr>
	            <tr>
	                <th>Vendedor Id: </th>
	                <td>
	                    <input type="number" name="salesman_id" size="5" />
	                </td>
	            </tr>
	            <tr>
	                <td colspan="2" align="center">
	                    <input type="submit" value="Save" />
	                </td>
	            </tr>
	        </table>
        </form>
    </div>   
</body>
</html>