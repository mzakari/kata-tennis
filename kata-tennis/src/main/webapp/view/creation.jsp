<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%-- <%@ page contentType="text/html; charset=iso-8859-1" language="java" %> --%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<style>
th.game {
    background-color: #4CAF50;
    color: white;
}

th {
    display: table-cell;
    vertical-align: top;   
    text-align: center;
}

tr.gameRow:hover{background-color:#f5f5f5}
</style>
 <head>
        <title><spring:message code="titre.creation.listetennisgame"/></title>
    </head>
    <body>
    
	     <table align="center" >
		 <tr>
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="playTennisGame">       
		            <form:input path="id" type="hidden" value="1"/><br>           
		            <input type="submit" value="Player 1"/>
	        	</form:form>		     
		     </th>
		     
		     <th>
			     <form:form method="post" modelAttribute="creation" action="playTennisGame">      
		            <form:input path="id" type="hidden" value="2"/><br>  
		            <input type="submit" value="Player 2"/>
		      	 </form:form>
		     </th> 
		     
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="deleteTennisGame">  
		     		<form:input path="id" type="hidden" value="3"/><br> 
		            <input type="submit" value="Remove last play"/>
	        	</form:form>		     
		     </th>    
		     
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="deleteTennisGame">  
		     		<form:input path="id" type="hidden" value="4"/><br> 
		            <input type="submit" value="Reset match"/>
	        	</form:form>		     
		     </th>                  
		</tr>
	 	</table>
        
        <table align="center">
		 <tr>
		     <th>
				    <table border="1" align="center">
		            <thead>
		                <tr>		                   
		                    <th class="game"><spring:message code="colonne.gamep1"/></th>
		                    <th class="game"><spring:message code="colonne.gamesc1"/></th> 
		                                     
		                    <th class="game"><spring:message code="colonne.gamep2"/></th>
		                    <th class="game"><spring:message code="colonne.gamesc2"/></th>                          
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach items="${challenge}" var="challenge">
		                    <tr class="gameRow">		                    
		                        <td align="center"><c:out value="${challenge.playPoint_1}"/></td>
		                        <c:choose>
									   <c:when test="${challenge.playScore_1 == 42}"> 
									   		<td align="center"><c:out value="ADV"/></td>  
									   </c:when> 
									   <c:when test="${challenge.playScore_1 == 41}"> 
									   		<td align="center"><c:out value="DEUCE"/></td>  
									   </c:when> 
									   <c:otherwise>
									   <td align="center"><c:out value="${challenge.playScore_1}"/></td>
									   </c:otherwise>  
								</c:choose>
		                     
		                        <td align="center"><c:out value="${challenge.playPoint_2}"/></td>
		                        <c:choose>
									   <c:when test="${challenge.playScore_2 == 42}"> 
									   		<td align="center"><c:out value="ADV"/></td>  
									   </c:when> 
									   <c:when test="${challenge.playScore_2 == 41}"> 
									   		<td align="center"><c:out value="DEUCE"/></td>  
									   </c:when> 
									   <c:otherwise>
									   <td align="center"><c:out value="${challenge.playScore_2}"/></td>
									   </c:otherwise>  
								</c:choose>		                                                                                          
		                    </tr>
		                </c:forEach>
		            </tbody>
		        </table>
		     	     
		     </th>
		     		
		    <th>
			<table border="1" align="center" >
		            <thead>
		                <tr>
		                    <th class="game"><spring:message code="colonne.idset"/></th>
		                    
		                    <th class="game"><spring:message code="colonne.sets1"/></th>
		                     
		                    <th class="game"><spring:message code="colonne.sets2"/></th>                   		                                             
		                </tr>
		            </thead>
		            <tbody>
		                <c:forEach items="${games}" var="games">
		                    <tr class="gameRow">
		                        <td align="center"><c:out value="${games[0]-1}"/></td>		                        
		                        
		                        <td align="center"><c:out value="${games[1]}"/></td>
		                        
		                        <td align="center"><c:out value="${games[2]}"/></td>                    		                                                                                          
		                    </tr>
		                </c:forEach>
		              
		            </tbody>
		        </table>
		     </th> 
		    
		     
		                         
		</tr>
 	</table>
        
       
        
        <table align="center" >
		 <tr>
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="playTennisGame">       
		            <form:input path="id" type="hidden" value="1"/>  <br>           
		            <input type="submit" value="Player 1"/>
	        	</form:form>		     
		     </th>
		     
		     <th>
			     <form:form method="post" modelAttribute="creation" action="playTennisGame">      
		            <form:input path="id" type="hidden" value="2"/><br>  
		            <input type="submit" value="Player 2"/>
		      	 </form:form>
		     </th> 
		     
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="deleteTennisGame">  
		     		<form:input path="id" type="hidden" value="3"/><br> 
		            <input type="submit" value="Remove last play"/>
	        	</form:form>		     
		     </th>    
		     
		     <th>
		     	<form:form method="post" modelAttribute="creation" action="deleteTennisGame">  
		     		<form:input path="id" type="hidden" value="4"/><br> 
		            <input type="submit" value="Reset match"/>
	        	</form:form>		     
		     </th>                            
		</tr>
	 	</table>
    </body>

</body>
</html>