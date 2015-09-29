<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>User profile</h1>

<div class="userProfile">
    <table>
        <tr>
            <td>First Name</td>
            <td>${user.firstName}</td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>${user.lastName}</td>
        </tr>
        <tr>
            <td>E-Mail</td>
            <td>${user.email}</td>
        </tr>
        <tr>
            <td>Team</td>
            <td>${team.teamName}</td>
        </tr>
    </table>
</div>

<c:import url="template/footer.jsp" />