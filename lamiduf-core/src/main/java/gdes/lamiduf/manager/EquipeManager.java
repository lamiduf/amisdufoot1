package gdes.lamiduf.manager;

import gdes.lamiduf.domain.Equipe;
import gdes.lamiduf.exception.LamidufException;

import java.util.List;

public interface EquipeManager {
	
	public void ajouterEquipe(Equipe eq) throws LamidufException;
	
	public void modifierEquipe(Equipe eq) throws LamidufException;
	
	public void supprimerEquipe(Equipe eq) throws LamidufException;
	
	public List<Equipe> listerEquipes() throws LamidufException;

}
