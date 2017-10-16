<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<style>
th.game {
    background-color: #4CAF50;
    color: white;
}

tr.gameRow:hover{background-color:#f5f5f5}
</style>
 <head>
        <title><spring:message code="titre.creation.listetennisgame"/></title>
    </head>
    <body >
    
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
		     	<form:form method="get" modelAttribute="creation" action="deleteTennisGame">  
		            <br><input type="submit" value="Remove last game"/><br> 
	        	</form:form>		     
		     </th>                  
		</tr>
	 	</table>
        
        
        <table border="1" align="center">
            <thead>
                <tr>
                    <th class="game"><spring:message code="colonne.idset"/></th>
                    <th class="game"><spring:message code="colonne.idgame"/></th>
                    <th class="game"><spring:message code="colonne.sets1"/></th>
                    <th class="game"><spring:message code="colonne.gamep1"/></th>
                    <th class="game"><spring:message code="colonne.gamesc1"/></th> 
                    <th class="game"><spring:message code="colonne.sets2"/></th>                   
                    <th class="game"><spring:message code="colonne.gamep2"/></th>
                    <th class="game"><spring:message code="colonne.gamesc2"/></th>                          
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${challenge}" var="challenge">
                    <tr class="gameRow">
                        <td><c:out value="${challenge.idSet}"/></td>
                        <td><c:out value="${challenge.idGame}"/></td>
                        
                        <td><c:out value="${challenge.setScore_1}"/></td>
                        <td><c:out value="${challenge.gamePoint_1}"/></td>
                        <td><c:out value="${challenge.gameScore_1}"/></td>
                        <td><c:out value="${challenge.setScore_2}"/></td>
                        <td><c:out value="${challenge.gamePoint_2}"/></td>
                        <td><c:out value="${challenge.gameScore_2}"/></td>                                                                  
                    </tr>
                </c:forEach>
            </tbody>
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
		     	<form:form method="get" modelAttribute="creation" action="deleteTennisGame">  
		            <br><input type="submit" value="Remove last game"/><br> 
	        	</form:form>		     
		     </th>                  
		</tr>
	 	</table>
    </body>

</body>
</html>