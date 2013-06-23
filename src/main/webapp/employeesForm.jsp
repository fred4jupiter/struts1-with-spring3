<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<html>
<head>
<link href="<c:url value='css/main.css'/>" rel="stylesheet" type="text/css" />
<style>
td {
	white-space: nowrap;
}
</style>
<title>Update Employees</title>
</head>
<body>
	<div class="titleDiv">
		<fmt:message key="application.title" />
	</div>
	<h1>Update Employees</h1>
	<html:form action="/employeesProcess">
		<table class="borderAll">
			<tr>
				<th><fmt:message key="label.firstName" /></th>
				<th><fmt:message key="label.lastName" /></th>
				<th><fmt:message key="label.contact.info" /></th>
			</tr>
			<nested:iterate property="employees" indexId="indX">
				<c:set var="rowDec" value="${indX%2==0?'even':'odd'}" />
				<tr class="${rowDec}">
					<td><nested:text styleClass="${rowDec}" property="firstName" /></td>
					<td><nested:text styleClass="${rowDec}" property="lastName" /></td>
					<td><nested:iterate property="contacts">
							<nested:text styleClass="${rowDec}" property="label" />: 
							<nested:text styleClass="${rowDec}" property="phoneNumber" />
							<br />
						</nested:iterate>
					</td>
				</tr>
			</nested:iterate>
		</table>
		<input type="hidden" name="dispatch" value="update" />
		<p />
		<input type="submit" value="<fmt:message key="button.label.submit"/>" class="butStnd" />
 &nbsp;&nbsp;
<input type="submit" value="<fmt:message key="button.label.cancel"/>" onClick="document.forms[0].dispatch.value='getEmployees'"
			class="butStnd" />
	</html:form>
</body>
</html>