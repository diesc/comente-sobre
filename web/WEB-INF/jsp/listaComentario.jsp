<%-- 
    Document   : listaComentario
    Created on : May 18, 2013, 11:03:55 PM
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${listar}" var="comentario" varStatus="status">
            <c:if test="${status.count % 2 == 0}"></c:if>
                <div class="comment_box">
                    <div class="body">
                        <span><p>${comentario.nmCliente}</p></span>
                    <div class="txt">${comentario.nmClienteComentario}</div>
                </div>
            </div>
        </c:forEach>
    </body>
</html>
