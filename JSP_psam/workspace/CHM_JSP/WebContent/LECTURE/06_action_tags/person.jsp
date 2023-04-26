<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="person" class="_06_action_tags.Person" scope="request"/>
<p> <%= person.getId() %>
<p> <%= person.getName() %>
