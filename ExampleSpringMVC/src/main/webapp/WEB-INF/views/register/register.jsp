<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	    <meta charset="utf-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <title>Crea una cuenta</title>
	    <link href="resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
	    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
	    <link href="resources/css/sb-admin-2.min.css" rel="stylesheet">
	</head>
	<body class="bg-gradient-primary">
	    <div class="container">
	        <div class="card o-hidden border-0 shadow-lg my-5">
	            <div class="card-body p-0">
	                <div class="row">
	                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
	                    <div class="col-lg-7">
	                        <div class="p-5">
	                            <div class="text-center">
	                                <h1 class="h4 text-gray-900 mb-4">¡Crea una cuenta!</h1>
	                            </div>
	                            <c:if test="${not empty error}">
	                            	<div class="col-lg-12 mb-4">
                                    	<div class="card bg-danger text-white shadow">
                                        	<div class="card-body text-center">
                                        		${message}
                                        	</div>
                                    	</div>
                                	</div>
								</c:if>
								<c:if test="${not empty message}">
	                            	<div class="col-lg-12 mb-4">
                                    	<div class="card bg-info text-white shadow">
                                        	<div class="card-body text-center">
                                        		${message}
                                        	</div>
                                    	</div>
                                	</div>
								</c:if>
	                            <form action="register-add" method="post" class="needs-validation" novalidate>
	                                <div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input name="firstName" type="text" class="form-control form-control-user" placeholder="Nombre" value="${registerVO.firstName}" required>
    										<div class="invalid-feedback">Por favor, rellene este campo.</div>
	                                    </div>
	                                    <div class="col-sm-6">
	                                        <input name="lastName" type="text" class="form-control form-control-user" placeholder="Apellido" value="${registerVO.lastName}" required>
    										<div class="invalid-feedback">Por favor, rellene este campo.</div>
	                                    </div>
	                                </div>
	                                <div class="form-group">
	                                    <input name="email" type="email" class="form-control form-control-user" placeholder="Correo electr&oacute;nico" value="${registerVO.email}" required>
    									<div class="invalid-feedback">Por favor, rellene este campo.</div>
	                                </div>
	                                <div class="form-group row">
	                                    <div class="col-sm-6 mb-3 mb-sm-0">
	                                        <input name="password" type="password" class="form-control form-control-user" placeholder="Contrase&ntilde;a" required>
    										<div class="invalid-feedback">Por favor, rellene este campo.</div>
	                                    </div>
	                                    <div class="col-sm-6">
	                                        <input name="repeat" type="password" class="form-control form-control-user" placeholder="Repita la contrase&ntilde;a" required>
    										<div class="invalid-feedback">Por favor, rellene este campo.</div>
	                                    </div>
	                                </div>
	                                <button type="submit" class="btn btn-primary btn-user btn-block">Registrar cuenta</button>
	                                <hr>
		                            <div class="text-center">
		                                <a class="small" href="forgot">¿Has olvidado tu contraseña?</a>
		                            </div>
		                            <div class="text-center">
		                                <a class="small" href="./">¿Ya tienes una cuenta? ¡Inicia sesión!</a>
		                            </div>
	                            </form>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <script src="resources/vendor/jquery/jquery.min.js"></script>
	    <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	    <script src="resources/vendor/jquery-easing/jquery.easing.min.js"></script>
	    <script src="resources/js/sb-admin-2.js"></script>
	</body>
</html>