<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal fade" id="addModalClient">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Agregar Cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletController?action=insert" method="POST" class="was-validated">
                <div class="modal-body row g-3">
                    <div class="col-md-6">
                        <label for="firstName">Nombre</label>
                        <input type="text" class="form-control" name="firstName"  required/>
                    </div>
                    <div class="col-md-6">
                        <label for="lastName">Apellido</label>
                        <input type="text" class="form-control" name="lastName"  required/>
                    </div>
                    <div class="form-group">
                        <label for="email">e-mail</label>
                        <input type="email" class="form-control" name="email"  required/>
                    </div>
                    <div class="col-md-6">
                        <label for="phone">Teléfono</label>
                        <input type="tel" class="form-control" name="phone"  required/>
                    </div>
                    <div class="col-md-6">
                        <label for="balance">saldo</label>
                        <input type="number" class="form-control" name="balance"  required/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>