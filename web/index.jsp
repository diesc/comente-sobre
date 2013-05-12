<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
        <link rel="stylesheet" href="<c:url value="resources/css/polaris.css"/>"/>
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <div id="polaroid">
            <figure>
                <a href="metodo-agil/pagina-metodos-ageis.htm">
                    <img src="resources/img/image1.jpg" 
                         width="200" height="200" alt="Métodos Ageis" />
                </a>
                <figcaption>Métodos Ageis</figcaption>
            </figure>
            <figure>
                <a href="cloud-computing/pagina-cloud-computing.htm">
                    <img src="resources/img/image2.jpg" 
                         width="200" height="200" alt="Cloud Computing" />
                </a>
                <figcaption>Cloud Computing</figcaption>
            </figure>
            <figure>
                <a href="programacao/pagina-programacao.htm">
                    <img src="resources/img/image3.jpg" 
                         width="200" height="200" alt="Programação" /> 
                </a>
                <figcaption>Programação</figcaption>
            </figure>
            <figure>
                <a href="rede-social/pagina-redes-sociais.htm">
                    <img src="resources/img/image4.jpg" 
                         width="200" height="200" alt="Redes Sociais" /> 
                </a>
                <figcaption>Redes Sociais</figcaption>
            </figure>
        </div>
        
        
    </body>
</html>
