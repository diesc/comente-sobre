<%-- 
    Document   : pagina-cloud-computing
    Created on : Apr 26, 2013, 2:24:03 PM
    Author     : HOME
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
        <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.9.1.js"/> "></script>
        <script>
            $(document).ready(function() {

            $(".btn").click(function() {
                var str = $(comentario).serialize();

                var name = $("#name").val();
                var email = $("#email").val();
                var comment = $("#comment").val();
                
                if (name === '' || email === '' || comment === '') {
                    alert('Opss, preencha todos os campos!');
                } else {
                    jQuery.ajax({
                        type: "POST",
                        url: "/comente-sobre/adicionarCloud.htm",
                        data: str,
                        async: false,
                        cache: false,
                        success: function() {
                            $("#name").val('');
                            $("#email").val('');
                            $("#comment").val('');
                            $("#success_msg").load('/comente-sobre/cloud-computing.htm  .comment_box');

                        }
                    });
                }
                return false;
            });
        });
        </script>
        <title>Cloud Computing</title>
    </head>
    <body>
        <div class="wrapper">
            <div class="header">
                <h1>Cloud Computing</h1>
            </div>

            <ul class="nav">
                <li><a href="/comente-sobre/">Home</a></li>
            </ul>

            <div class="main">
                <h2>Cloud Computing</h2>
                <p>Cum porta risus odio tincidunt? Ultrices, nascetur lundium tincidunt ridiculus? Enim nisi ac nec nec vel in ac pid ultricies nunc, cras porta ultrices. Hac lacus nisi non! Ut turpis, tempor eros? Tortor et, platea turpis scelerisque duis porttitor augue ridiculus nec et mid, sociis? Est ac a? Arcu elementum eros in ultrices dignissim pulvinar tincidunt elementum, hac platea hac. Purus et egestas vel, elementum facilisis, turpis sit augue ultricies, porta augue, enim massa cursus ac augue! Porta sed cras. Ut a augue ac in, dis pulvinar? Cras amet aenean magna adipiscing turpis mattis purus placerat, placerat nunc placerat urna.</p>
                <p>Dis? Rhoncus ultricies porta purus habitasse cum dictumst urna dictumst sociis, porttitor augue rhoncus enim! Lundium, magnis adipiscing ut! Lorem in nascetur lorem sagittis urna! Quis eu rhoncus mid platea cras facilisis! Eros in facilisis! Urna sit ac montes. Rhoncus et eros urna lectus, adipiscing lorem ultrices natoque placerat, pid tincidunt magna mus, placerat pid velit tristique sit amet. Pulvinar nec, parturient eros cras, parturient nec lorem, dolor purus phasellus porttitor. In porta cras, dolor odio ac porta sociis et cras quis, augue quis cum nisi aliquam lorem, ut. Cras mattis, phasellus dignissim augue enim massa nascetur, sit ut.</p>
                <p>Turpis purus aliquet. Habitasse placerat odio ac sociis mid, auctor cursus parturient eros! Lundium, vut, urna ridiculus? Penatibus ac et mus elementum. Sed magna augue, velit odio magna pellentesque a, lacus, aliquam elementum, in massa! Dapibus turpis, placerat purus, lectus in sagittis porta massa aenean! Turpis enim non adipiscing lundium parturient, a natoque egestas. Mid dictumst porta. Risus lorem aliquam velit mid, placerat! Et lectus sociis scelerisque ac turpis. Magna porta? Augue, augue in. Porta dolor, et amet, ac. Cum scelerisque tincidunt dignissim in, pellentesque habitasse! Elit? Mus porttitor in a nec, augue! Elit nisi purus? Porta platea integer.</p>
            </div>

            <div class="formAction">
                <c:url var="urlComentario" value="adicionarCloud.htm"/>
                <form:form modelAttribute="comentario" action="${urlComentario}" method="POST">
                    <table>
                        <tr>
                            <td>Nome :</td>
                            <td><form:input path="nmCliente" id="name"/></td>
                        </tr>
                        <tr>
                            <td>Email :</td>
                            <td><form:input path="nmClienteEmail" id="email"/></td>
                        </tr>
                        <tr>
                            <td>Comentário :</td>
                            <td><form:textarea path="nmClienteComentario" id="comment"/></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" class="btn" value="Enviar" ></td>
                        </tr>
                    </table>
                </form:form>

                <div id="success_msg">
                    <jsp:include page="listaComentario.jsp"/>
                </div>
            </div>
            <div class="footer">
                <p>&copy; 2013, All Rights Reserved</p>
            </div>
        </div>
    </body>
</html>
