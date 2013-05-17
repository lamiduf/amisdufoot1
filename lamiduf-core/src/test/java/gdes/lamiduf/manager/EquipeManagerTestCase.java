package gdes.lamiduf.manager;

import gdes.lamiduf.domain.Equipe;
import gdes.lamiduf.exception.LamidufException;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.santeos.springutilities.dbunit.AbstractJUnit4DbUnitSpringContextTests;
import com.santeos.springutilities.dbunit.DbUnitDataSet;


@DbUnitDataSet(flatXmlDataset = true)
public class EquipeManagerTestCase extends AbstractJUnit4DbUnitSpringContextTests{

	@Autowired
	protected EquipeManager equipeManager;
	
	@Test
	public void testAjouterEquipe() throws LamidufException {
		Equipe newEquipe = new Equipe();
		newEquipe.setNom("LOSC");
		equipeManager.ajouterEquipe(newEquipe);
		
		List<Equipe> equipes = equipeManager.listerEquipes();
		Assert.assertEquals(3, equipes.size());
	}
	
	
}
