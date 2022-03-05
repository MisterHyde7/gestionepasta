<%@page import="java.text.SimpleDateFormat"%>
<%@page import="it.prova.gestionepasta.model.Pasta"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Ricerca Tipo di Pasta</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Cerca tipo di pasta</h5> 
				    </div>
				    <div class='card-body'>
		
							<form method="post" action="ExecuteSearchPastaServlet" class="row g-3" novalidate="novalidate">
							
								<% Pasta pastaInPagina = (Pasta)request.getAttribute("searchPasta"); %>
							
								<div class="col-md-6">
									<label for="marca" class="form-label">Marca</label>
									<input type="text" name="marca" id="marca" class="form-control" placeholder="Inserire la marca"  
										value="<%=pastaInPagina.getMarca()!=null?pastaInPagina.getMarca():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="descrizione" class="form-label">Descrizione</label>
									<input type="text" name="descrizione" id="descrizione" class="form-control" placeholder="Inserire la descrizione"  
										value="<%=pastaInPagina.getDescrizione()!=null?pastaInPagina.getDescrizione():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="codice" class="form-label">Codice</label>
									<input type="text" name="codice" id="codice" class="form-control" placeholder="Inserire il codice"  
										value="<%=pastaInPagina.getCodice()!=null?pastaInPagina.getCodice():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="prezzo" class="form-label">Prezzo</label>
									<input type="number" class="form-control" name="prezzo" id="prezzo" placeholder="Inserire prezzo" 
									value="<%=pastaInPagina.getPrezzo()!=null?pastaInPagina.getPrezzo():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataScadenza" class="form-label">Data di scadenza</label>
									<input class="form-control"  name="dataScadenza" id="dataScadenza" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=pastaInPagina.getDataScadenza()!=null? new SimpleDateFormat("yyyy-MM-dd").format(pastaInPagina.getDataScadenza()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-primary">Conferma</button>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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