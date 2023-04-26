<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

Cookie cartId = new Cookie("Shipping_cartId", URLEncoder.encode(request.getParameter("cartId"), "UTF-8"));
Cookie name = new Cookie("Shipping_name", URLEncoder.encode(request.getParameter("name"), "UTF-8"));
Cookie shippingDate = new Cookie("Shipping_shippingDate", URLEncoder.encode(request.getParameter("shippingDate"), "UTF-8"));
Cookie country = new Cookie("Shipping_country", URLEncoder.encode(request.getParameter("country"), "UTF-8"));
Cookie zipCode = new Cookie("Shipping_zipCode", URLEncoder.encode(request.getParameter("zipCode"), "UTF-8"));
Cookie addressName = new Cookie("Shipping_addressName", URLEncoder.encode(request.getParameter("addressName"), "UTF-8"));

cartId.setMaxAge(60 * 3);
name.setMaxAge(60 * 3);
shippingDate.setMaxAge(60 * 3);
country.setMaxAge(60 * 3);
zipCode.setMaxAge(60 * 3);
addressName.setMaxAge(60 * 3);

response.addCookie(cartId);
response.addCookie(name);
response.addCookie(shippingDate);
response.addCookie(country);
response.addCookie(zipCode);
response.addCookie(addressName);

response.sendRedirect("order_confirm.jsp");
%>