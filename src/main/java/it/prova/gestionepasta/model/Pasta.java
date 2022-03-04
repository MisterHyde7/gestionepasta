package it.prova.gestionepasta.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "pasta")
public class Pasta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "marca")
	private String marca;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	@Column(name = "prezzo")
	private Integer prezzo;
	@Column(name = "datascadenza")
	private Date dataScadenza;

	// campi per le time info del record
	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Pasta() {
	}

	public Pasta(String marca, String descrizione, String codice) {
		super();
		this.marca = marca;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Pasta(String marca, String descrizione, String codice, Integer prezzo, Date dataScadenza) {
		super();
		this.marca = marca;
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzo = prezzo;
		this.dataScadenza = dataScadenza;
	}

	public Pasta(Long id, String marca, String descrizione, String codice, Integer prezzo, Date dataScadenza) {
		super();
		this.id = id;
		this.marca = marca;
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzo = prezzo;
		this.dataScadenza = dataScadenza;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

}
