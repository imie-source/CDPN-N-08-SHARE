package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "don" database table.
 * 
 */
@Entity
@Table(name="don")
@NamedQuery(name="Don.findAll", query="SELECT d FROM Don d")
public class Don implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="projet_uri")
	private String projetUri;

	@Column(name="valeur")
	private int valeur;

	//bi-directional many-to-one association to Personne
	@ManyToOne
	@JoinColumns({@JoinColumn(name = "personne_id", referencedColumnName = "id")
		})
	private Personne personne;

	public Don() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getProjetUri() {
		return this.projetUri;
	}

	public void setProjetUri(String projetUri) {
		this.projetUri = projetUri;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Personne getPersonne() {
		return this.personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

}