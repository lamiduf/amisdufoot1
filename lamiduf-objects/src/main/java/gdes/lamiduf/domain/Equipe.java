package gdes.lamiduf.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "equipe")
@Entity
@NamedQueries({
		@NamedQuery(name = "equipe.lireParNom", query = "from Equipe a where a.nom=:nom") ,
		@NamedQuery(name = "equipe.listerTousTriesParNom", query = "from Equipe order by nom") })
public class Equipe extends LamidufGenericEntity implements Serializable{

	private static final long serialVersionUID = 199283347769649025L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	private String nom;

	private String responsable;
	
	private String telResponsable;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getResponsable() {
		return responsable;
	}


	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}


	public String getTelResponsable() {
		return telResponsable;
	}


	public void setTelResponsable(String telResponsable) {
		this.telResponsable = telResponsable;
	}


	public String toString() {
		return nom;
	}

}
