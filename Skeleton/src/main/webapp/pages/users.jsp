<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:import url="template/header.jsp" />

<h1>All Users</h1>

<ul>
    <c:forEach items="${users}" var="users">
        <li><a href="/Skeleton/userId=${users.id}"><c:out value="${users.firstName} ${users.lastName} "/></a></li>
    </c:forEach>
</ul>

<c:if test="${page_error != null}">
    <div class="alert alert-error">
        <button type="button" class="close" data-dismiss="alert">&times;</button>
        <h4>Error!</h4>
        ${page_error}
    </div>
</c:if>
    
<c:import url="template/footer.jsp" />