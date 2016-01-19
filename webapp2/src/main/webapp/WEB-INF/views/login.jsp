<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">    
<html>    
    <head>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    
        <title>Insert title here</title>    
    </head>    
        
    <body margin-top:200px > 
    <center>
       
       <c:out value="Hello，please write your name,then click save button."></c:out> 
  <form action="display.do" method="post" >
	Your name:<input type="text" name="username" />
	
	<p>
	<p>
	<input type="submit" value="save" />
</form>  
</center>     
    </body>    
</html>