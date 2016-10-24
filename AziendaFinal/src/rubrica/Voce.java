package rubrica;

import javax.persistence.*;
import util.IsValid;

@Entity
public class Voce implements IsValid {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_voce;
	private String nome;
	private String cognome;
	private String telefono;

	@ManyToOne
	private Rubrica rubrica;

	public Voce() {
	}

	public Voce(String nome, String cognome, String telefono) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
	}

	public long getId_Voce() {
		return id_voce;
	}

	public void setId_Voce(long id_voce) {
		this.id_voce = id_voce;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Rubrica getRubrica() {
		return rubrica;
	}

	public void setRubrica(Rubrica rubrica) {
		this.rubrica = rubrica;
	}
	
	@Override
	public boolean isValid() {

		boolean res = false;
		
		if(!nome.isEmpty() && nome!=null && 
				!cognome.isEmpty() && cognome!=null &&
				!telefono.isEmpty() && telefono!=null) {
			res = true;
		}
		
		return res;
	}
}