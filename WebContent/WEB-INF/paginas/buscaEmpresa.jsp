<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- importar uma taglib - forEach usa a core (c) : implementação da taglib core: o jstl-1.2.jar. dentro da pasta web-inf/lib-->
<html>
<body>
    Resultado da busca:
    <ul>
        <c:forEach var="empresa" items="${empresas}"><!-- emrpesas vem do model req.setAttribute("empresas", empresas); - busca variáveis no escopo de request  -->
<%--              <li>${empresa.getId()}: ${empresa.getNome()}</li> --%>
            <li>${empresa.id}: ${empresa.nome}</li> <!-- expression language do JSP permite que utilizemos somente id e nome quando desejamos chamar getters -->
        </c:forEach>
    </ul>
</body>
</html>