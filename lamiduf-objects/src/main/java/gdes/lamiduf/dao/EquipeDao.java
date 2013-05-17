package gdes.lamiduf.dao;
import gdes.lamiduf.domain.Equipe;

import java.util.List;

import santeos.hibernate.dao.GenericDAO;


public interface EquipeDao extends GenericDAO<Equipe, Long> {

	public Equipe lireParNom(String nom);
	
	public List<Equipe> listerTousTriesParNom();
	
}
