package gdes.lamiduf.manager.impl;

import java.util.List;

import gdes.lamiduf.dao.EquipeDao;
import gdes.lamiduf.domain.Equipe;
import gdes.lamiduf.exception.LamidufException;
import gdes.lamiduf.manager.EquipeManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("equipeManager")
public class EquipeManagerImpl implements EquipeManager {
	
	protected static final Logger LOG = LoggerFactory.getLogger(EquipeManagerImpl.class);
	
	@Autowired
	protected  EquipeDao equipeDao;

	public void ajouterEquipe(Equipe eq) throws LamidufException {
		
		String what = null;
		String nom = eq.getNom();
		verifierNom(nom);

		Equipe eqExistante = equipeDao.lireParNom(nom);
		
		if (eqExistante != null) {
			what = "l'équipe ["+nom+"] existe déjà";
			LOG.error(what);
			throw new LamidufException(what);
		}
		
		equipeDao.persist(eq);

	}

	public void modifierEquipe(Equipe eq) throws LamidufException {

		Equipe eqExistante = verifierExistenceEquipe(eq.getNom());
		
		// TODO : mettre à jour les dates de modifs 
		eqExistante.setResponsable(eq.getResponsable());
		eqExistante.setTelResponsable(eq.getTelResponsable());
		

	}

	public void supprimerEquipe(Equipe eq) throws LamidufException {

		Equipe eqExistante = verifierExistenceEquipe(eq.getNom());
		equipeDao.delete(eqExistante);
		
	}

	private void verifierNom(String nom) throws LamidufException {
		String what = null;
		if (nom == null) {
			what = "le nom de l'équipe est obligatoire";
			LOG.error(what);
			throw new LamidufException(what);
		}
	}
	
	private Equipe verifierExistenceEquipe(String nom) throws LamidufException {

		String what = null;
		verifierNom(nom);

		Equipe eqExistante = equipeDao.lireParNom(nom);
		
		if (eqExistante == null) {
			what = "l'équipe ["+nom+"] n'existe pas";
			LOG.error(what);
			throw new LamidufException(what);
		}
		
		return eqExistante;

	}

	public List<Equipe> listerEquipes() throws LamidufException {
		return equipeDao.listerTousTriesParNom();
	}
	
}
