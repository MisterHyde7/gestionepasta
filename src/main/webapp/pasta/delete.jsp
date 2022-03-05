<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionepasta.model.Pasta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rimozione pasta</title>
</head>
<body>
	<jsp:include page="../header.jsp" />

	<title>Visualizza Elemento Da Eliminare</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div class='card'>
				<div class='card-header'>
					<h5>Visualizza pasta da eliminare</h5>
				</div>
				
				<c:set var="pastaInPagina" value="${pastaDaEliminare }"></c:set>

				<div class='card-body'>
					<dl class="row">
						<dt class="col-sm-3 text-right">Marca</dt>
						<dd class="col-sm-9"><c:out value="${pastaInPagina.marca }"></c:out></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Descrizione:</dt>
						<dd class="col-sm-9"><c:out value="${pastaInPagina.descrizione }"></c:out></dd>
					</dl>
					
					<dl class="row">
						<dt class="col-sm-3 text-right">Codice:</dt>
						<dd class="col-sm-9"><c:out value="${pastaInPagina.codice }"></c:out></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Prezzo:</dt>
						<dd class="col-sm-9"><c:out value="${pastaInPagina.prezzo }"></c:out></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Data di Scadenza:</dt>
						<dd class="col-sm-9"><c:out value="${pastaInPagina.dataScadenza }"></c:out></dd>
					</dl>

				</div>

				<div class='card-footer'>
					<a href="ListPastaServlet" class='btn btn-outline-secondary'
						style='width: 80px'> <i class='fa fa-chevron-left'></i> Cancel
					</a> <a href="ExecuteDeletePastaServlet?idDaEliminare=${pastaInPagina.id }" class='btn btn-outline-primary'
						style='width: 100px'> <i class='fa fa-chevron-right'></i>
						Conferm
					</a>
				</div>

				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />
</body>
</html>