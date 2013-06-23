<%@ page isErrorPage="true" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<html>
<head>
    <title>Error Page</title>
    <link href="<c:url value='css/main.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>

<c:if test='${ !empty requestScope["org.apache.struts.action.ERROR"] }'>
    <div class="error">
        <html:messages id="error">
            <c:out value="${error}" escapeXml="false"/><br/>
        </html:messages>
    </div>
</c:if>
<br/>
In order that the development team can address this error, please report what you were doing that caused this error.
<br/><br/>
The following information can help the development
team find where the error happened and what can be done to prevent it from
happening in the future.
<br/>
<%
if(null == exception){
    exception = (Throwable)request.getAttribute("org.apache.struts.action.EXCEPTION");
}
%>
<pre style="font-size:12px"><%
if(null == exception){
    out.write("Source of error is unknown.");
}else{
    java.io.StringWriter sw = new java.io.StringWriter();
    java.io.PrintWriter pw = new java.io.PrintWriter(sw);

    exception.printStackTrace(pw);
    out.write(sw.getBuffer().toString());
}
%></pre>

</body>
</html>
