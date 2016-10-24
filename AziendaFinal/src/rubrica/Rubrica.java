package rubrica;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Rubrica {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id_rubrica;
	private String nomeRubrica;
	@OneToMany(mappedBy="rubrica",fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@NotFound(action=NotFoundAction.IGNORE)
	private Set<Voce> elencoVoci = new HashSet<Voce>();
	
	public Rubrica() {
	}

	public Rubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public long getId_Rubrica() {
		return id_rubrica;
	}

	public void setId_Rubrica(long id_rubrica) {
		this.id_rubrica = id_rubrica;
	}

	public String getNomeRubrica() {
		return nomeRubrica;
	}

	public void setNomeRubrica(String nomeRubrica) {
		this.nomeRubrica = nomeRubrica;
	}

	public Set<Voce> getElencoVoci() {
		return elencoVoci;
	}

	public void setElencoVoci(Set<Voce> elencoVoci) {
		this.elencoVoci = elencoVoci;
	}

	public void addVoce(Voce v){
		this.elencoVoci.add(v);
}

}