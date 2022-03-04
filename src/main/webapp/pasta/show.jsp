<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionepasta.model.Pasta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista di tipi di pasta</title>
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Visualizza Pasta</title>
</head>
<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div class='card'>
				<div class='card-header'>
					<h5>Visualizza dettaglio</h5>
				</div>
				<% Pasta pastaInPagina = (Pasta)request.getAttribute("visualizzaPasta"); %>


				<div class='card-body'>
					<dl class="row">
						<dt class="col-sm-3 text-right">Marca</dt>
						<dd class="col-sm-9"><%=pastaInPagina.getMarca() %></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Descrizione:</dt>
						<dd class="col-sm-9"><%=pastaInPagina.getDescrizione() %></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Prezzo:</dt>
						<dd class="col-sm-9"><%=pastaInPagina.getPrezzo() %></dd>
					</dl>

					<dl class="row">
						<dt class="col-sm-3 text-right">Data di Scadenza:</dt>
						<dd class="col-sm-9"><%=pastaInPagina.getDataScadenza()!=null? new SimpleDateFormat("dd/MM/yyyy").format(pastaInPagina.getDataScadenza()):"N.D."  %></dd>
					</dl>

				</div>

				<div class='card-footer'>
					<a href="ListPastaServlet" class='btn btn-outline-secondary'
						style='width: 80px'> <i class='fa fa-chevron-left'></i> Back
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