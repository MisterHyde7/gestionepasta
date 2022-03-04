<%@page import="it.prova.gestionepasta.model.Pasta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista tipi di pasta</title>
<head>

<!-- Common imports in pages -->
<jsp:include page="../header.jsp" />

<title>Lista Pasta</title>
</head>

<body class="d-flex flex-column h-100">

	<!-- Fixed navbar -->
	<jsp:include page="../navbar.jsp"></jsp:include>


	<!-- Begin page content -->
	<main class="flex-shrink-0">
		<div class="container">

			<div
				class="alert alert-success alert-dismissible fade show  ${successMessage==null?'d-none':'' }"
				role="alert">
				${successMessage}
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-danger alert-dismissible fade show d-none"
				role="alert">
				Esempio di operazione fallita!
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>
			<div class="alert alert-info alert-dismissible fade show d-none"
				role="alert">
				Aggiungere d-none nelle class per non far apparire
				<button type="button" class="btn-close" data-bs-dismiss="alert"
					aria-label="Close"></button>
			</div>



			<div class='card'>
				<div class='card-header'>
					<h5>Lista dei risultati</h5>
				</div>
				<div class='card-body'>
					<a class="btn btn-primary " href="PrepareInsertArticoloServlet">Add
						New</a>

					<div class='table-responsive'>
						<table class='table table-striped '>
							<thead>
								<tr>
									<th>marca</th>
									<th>Descrizione</th>
									<th>Prezzo</th>
									<th>Data di Scadenza</th>
									<th>Azioni</th>
								</tr>
							</thead>
							<tbody>
								<%
								List<Pasta> listaPasta = (List<Pasta>) request.getAttribute("listaPastaAttribute");
								for (Pasta item : listaPasta) {
								%>
								<tr>
									<td><%=item.getMarca()%></td>
									<td><%=item.getDescrizione()%></td>
									<td><%=item.getPrezzo()%></td>
									<td><%=item.getDataScadenza() != null ? new SimpleDateFormat("dd/MM/yyyy").format(item.getDataScadenza()) : "N.D."%></td>
									<td><a class="btn  btn-sm btn-outline-secondary"
										href="ExecuteVisualizzaPastaServlet?idArticolo=<%=item.getId()%>">Visualizza</a>
										<a class="btn  btn-sm btn-outline-primary ml-2 mr-2"
										href="PrepareEditPastaServlet?idArticolo=<%=item.getId()%>"">Edit</a>
										<a class="btn btn-outline-danger btn-sm"
										href="PrepareDeletePastaServlet?idArticolo=<%=item.getId()%>">Delete</a>
									</td>
								</tr>
								<%
								}
								%>

							</tbody>
						</table>
					</div>

					<!-- end card-body -->
				</div>
				<!-- end card -->
			</div>


			<!-- end container -->
		</div>

	</main>

	<!-- Footer -->
	<jsp:include page="../footer.jsp" />

	<!-- Modal conferma delete -->
	<div class="modal fade" id="deleteModal" tabindex="-1"
		aria-labelledby="deleteModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="deleteModalLabel">Conferma
						Operazione</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">Continuare con l'operazione?</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Annulla</button>
					<button type="button" class="btn btn-primary">Continua</button>
				</div>
			</div>
		</div>
	</div>
	<!-- End Modal conferma delete -->

</body>
</html>