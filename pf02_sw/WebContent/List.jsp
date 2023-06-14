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
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Vendedores</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Comissão</th>
            </tr>
            <c:forEach var="salesman" items="${listSalesman}">
                <tr>
                    <td><c:out value="${salesman.salesman_id}" /></td>
                    <td><c:out value="${salesman.name}" /></td>
                    <td><c:out value="${salesman.city}" /></td>
                    <td><c:out value="${salesman.comission}" /></td>
                </tr>
            </c:forEach>
        </table>
        
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Clientes</h2></caption>
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Cidade</th>
                <th>Grade</th>
            </tr>
            <c:forEach var="customer" items="${listCustomer}">
                <tr>
                    <td><c:out value="${customer.customer_id}" /></td>
                    <td><c:out value="${customer.name}" /></td>
                    <td><c:out value="${customer.city}" /></td>
                    <td><c:out value="${customer.grade}" /></td>
                </tr>
            </c:forEach>
        </table>
        
        <table border="1" cellpadding="5">
            <caption><h2>Lista de Pedidos</h2></caption>
            <tr>
            	<th>Número</th>
                <th>Valor de Compra</th>
                <th>Data</th>
                <th>Cliente</th>
                <th>Vendedor</th>
            </tr>
            <c:forEach var="orders" items="${listOrders}">
                <tr>
                    <td><c:out value="${orders.orders_id}" /></td>
                    <td><c:out value="${orders.purch_amt}" /></td>
                    <td><c:out value="${orders.ord_date}" /></td>
                    <td><c:out value="${orders.customer_id}" /></td>
                    <td><c:out value="${orders.salesman_id}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>   
    
</body>
</html>