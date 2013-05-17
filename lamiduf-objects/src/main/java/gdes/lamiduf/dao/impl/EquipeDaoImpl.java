package gdes.lamiduf.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import gdes.lamiduf.dao.EquipeDao;
import gdes.lamiduf.domain.Equipe;
import santeos.hibernate.dao.impl.GenericDAOImpl;

@Repository
public class EquipeDaoImpl extends GenericDAOImpl<Equipe, Long>implements EquipeDao {

	public static final Logger LOG = LoggerFactory.getLogger(EquipeDaoImpl.class);

	public EquipeDaoImpl() {
		super(Equipe.class);
	}

	public Equipe lireParNom(String nom) {
		Equipe eq = null;
		try {
		eq = (Equipe)getEntityManager().createNamedQuery("equipe.lireParNom").setParameter("nom", nom).getSingleResult();
		}
		catch (NoResultException e) {
			LOG.warn("pas d'�quipe avec le nom["+nom+"]");
		}
		return eq;
		
	}

	@SuppressWarnings("unchecked")
	public List<Equipe> listerTousTriesParNom() {
		return getEntityManager().createNamedQuery("equipe.listerTousTriesParNom").getResultList();
	}
	
	

}
