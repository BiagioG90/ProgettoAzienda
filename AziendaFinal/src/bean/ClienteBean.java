package bean;

import javax.persistence.*;
import util.IsValid;

@Entity
public class ClienteBean extends UtenteBean implements IsValid  {

	private static final long serialVersionUID = 1L;
	private String ragioneSociale;
	private String partitaIVA;
	
	public ClienteBean() {
	}
	
	public ClienteBean(String nome, String cognome,String username, String password, char ruolo,String ragioneSociale, String partitaIVA) {
		super(nome,cognome,username,password,ruolo);
		this.ragioneSociale = ragioneSociale;
		this.partitaIVA = partitaIVA;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIVA() {
		return partitaIVA;
	}

	public void setPartitaIVA(String partitaIVA) {
		this.partitaIVA = partitaIVA;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public boolean isValid() {

		boolean res = false;
		
		if(!nome.isEmpty() && nome!=null && !cognome.isEmpty() && cognome!=null && !username.isEmpty() && username!=null &&
				!password.isEmpty() && password!=null && ruolo=='c' && !ragioneSociale.isEmpty() && ragioneSociale!=null &&
				!partitaIVA.isEmpty() && partitaIVA!=null) {
			
			res = true;
		}
		return res;
	}
}