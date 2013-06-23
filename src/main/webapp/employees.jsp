<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <link href="<c:url value='css/main.css'/>" rel="stylesheet" type="text/css"/>
    <title><fmt:message key="label.employees"/></title>
</head>
<body>
<div class="titleDiv">
    <fmt:message key="application.title"/>
</div>
<h1>
    <fmt:message key="label.employees"/>
</h1>
<table class="borderAll">
    <tr>
        <th><fmt:message key="label.firstName"/></th>
        <th><fmt:message key="label.lastName"/></th>
        <th><fmt:message key="label.contact.info"/></th>
    </tr>
    <c:forEach var="emp" items="${employees}" varStatus="status">
        <tr class="${status.index%2==0?'even':'odd'}">
            <td class="nowrap"><c:out value="${emp.firstName}"/></td>
            <td class="nowrap"><c:out value="${emp.lastName}"/></td>
            <td class="nowrap"><c:forEach var="contact" items="${emp.contacts}">
                <c:out value="${contact.label}"/>: &nbsp;<c:out value="${contact.phoneNumber}"/>
                <br/>
            </c:forEach></td>
        </tr>
    </c:forEach>
</table>
<p/>
<c:url var="url" scope="page" value="/employeesSetUp.do">
    <c:param name="dispatch" value="setUpForUpdate"/>
</c:url>
<a href="${url}">Edit Employees</a>
</body>
</html>