<html>
<body>
<%@ page isErrorPage = "true" %>
<h4>This is ShowErrors.jsp page
   Showing the errors of ErrorPage.jsp</h4>
   The following errors occured:<hr>
   <%exception.printStackTrace(new java.io.PrintWriter(out));%>
</h4>
</body>
</html>