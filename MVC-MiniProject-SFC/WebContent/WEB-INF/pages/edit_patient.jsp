<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h1 style="color: red;text-align:center">Edit Patient Details</h1>

<form:form method="POST" commandName="patientCmd">
<body >
<table border="1" style="background-image:url(images/hospital.jpg)"align="center"  >
  <tr><td> patient Id:<form:input path="patientId" disabled="true" /></td></tr>
   <tr><td> patient Name:<form:input path="patientName" /></td></tr>
    <tr><td>patient age:<form:input path="age"/></td></tr>
    <tr><td>patient adress:<form:input path="adress" /></td></tr>
   <tr><td> patient problem:<form:input path="problem" /></td></tr>
   <tr><td> patient wardNo: <form:input path="wardNo" /></td></tr>
    <tr><td>patient contact:<form:input path="contact" /></td></tr>
    <tr><td>Ref by doctor:<form:input path="doctor" /></td></tr>
   
    <tr><td><input type="submit" value="update patient">
     <input type="submit" value="cancel"></td></tr>
   
</table>
 
</body>
</form:form>
  
