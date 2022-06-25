<%@ page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en_US" />

<section id="clients">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="table-dark">
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Teléfono</th>
                                <th scope="col">Saldo</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clients}" varStatus="status" >
                                <tr>
                                    <th scope="row">${status.count}</th>
                                    <td scope="row">${client.firstName} ${client.lastName}</td>
                                    <td scope="row">${client.phone}</td>
                                    <td scope="row"><fmt:formatNumber value="${client.balance}" type="currency"/></td>
                                    <td scope="row">
                                        <a href="${pageContext.request.contextPath}/ServletController?action=edit&idClient=${client.idClient}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><!<!-- end cards -->

            <div class="col-md-3">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Saldo Total</h3>
                        <h4 class="display-6">
                            <fmt:formatNumber value="${totalBalance}" type="currency" />
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <h3>Total Clientes</h3>
                    <h4 class="display-6">
                        <i class="fas fa-users"></i> ${totalClients}
                    </h4>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Modal -->
<jsp:include page="/WEB-INF/pages/client/addClient.jsp" />