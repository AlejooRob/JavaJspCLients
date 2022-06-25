
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
        <script src="https://kit.fontawesome.com/5938021d37.js" crossorigin="anonymous"></script>
        <title>Editar CLiente</title>
    </head>
    <body>
        <!<!-- Header -->
        <jsp:include page="/WEB-INF/pages/commons/header.jsp" />

        <form action="${pageContext.request.contextPath}/ServletController?action=edit&idClient=${client.idClient}" method="POST" class="was-validated">
            <!<!-- Nav Buttons Edit-->
            <jsp:include page="/WEB-INF/pages/commons/buttonsEdit.jsp" />
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cliente</h4>
                                </div>
                                <div class="card-body row">
                                    <div class="col-md-6">
                                        <label for="firstName">Nombre</label>
                                        <input type="text" class="form-control" name="firstName" value="${client.firstName}" required/>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="lastName">Apellido</label>
                                        <input type="text" class="form-control" name="lastName" value="${client.lastName}" required/>
                                    </div>
                                    <div class="form-group">
                                        <label for="email">e-mail</label>
                                        <input type="email" class="form-control" name="email" value="${client.email}" required/>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="phone">Teléfono</label>
                                        <input type="tel" class="form-control" name="phone" value="${client.phone}" required/>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="balance">saldo</label>
                                        <input type="number" class="form-control" name="balance" value="${client.balance}" required/>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </section>
        </form>

        <!<!-- Footer -->
        <jsp:include page="/WEB-INF/pages/commons/footer.jsp" />
    </body>
</html>
