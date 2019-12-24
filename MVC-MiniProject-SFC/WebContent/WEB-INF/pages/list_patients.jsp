<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <c:choose>
    
    <c:when test="${!empty listDTO }">
       <table border ="1">
         <caption>All Patients Details</caption>
         <tr style="background:aqua;" >
           <th>srNo</th> <th>patientId</th> <th>patientName</th><th>age</th> <th> addres</th> <th>problem</th> <th>wardNo</th> <th>contact</th> <th>doctor</th>Operations<th>
         </tr> 
       <c:forEach var="dto" items="${listDTO} ">
        <tr>
          <td>${dto.srNo}</td>
           <td>${dto.patientId}</td>
           <td>${dto.patientName}</td>
            <td>${dto.age}</td>
             <td>${dto.addres}</td>
             <td>${dto.problem}</td>
              <td>${dto.wardNo}</td>
              <td>${dto.contact}</td>
              <td>${dto.doctor}</td>
                  
              <td><a href="patient_edit.htm?id=${dto.patientId}"><img src="images/edit.png" width="20" height="30"/></a>
                 &nbsp;&nbsp;&nbsp;
                  <a href="patient_delete.htm?id=${dto.patientId}"><img src="images/delete.jpg" width="20" height="30"/></a>
              </td>
        </tr>
       </c:forEach>
       </table> 
    </c:when>
    <c:otherwise>
         <h1 style="color: red">Records not found</h1>
    </c:otherwise>
    </c:choose>
    <br>
    <a href="home.htm"><img src="images/home.png"/></a>
