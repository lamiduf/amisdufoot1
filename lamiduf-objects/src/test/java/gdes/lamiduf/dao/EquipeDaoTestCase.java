package gdes.lamiduf.dao;

import gdes.lamiduf.domain.Equipe;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.santeos.springutilities.dbunit.AbstractTransactionalJUnit4DbUnitSpringContextTests;
import com.santeos.springutilities.dbunit.DbUnitDataSet;

@ContextConfiguration(value = { "/META-INF/applicationContext-lamiduf-objects-config.xml", "/META-INF/applicationContext-lamiduf-objects.xml" })
@DbUnitDataSet(useHostPreceding = false, flatXmlDataset = true)
@TransactionConfiguration(defaultRollback=false)
public class EquipeDaoTestCase extends AbstractTransactionalJUnit4DbUnitSpringContextTests{

	@Autowired
	protected EquipeDao equipeDao;
	
	@Test
	public void testPersist() {
		Equipe eq = new Equipe();
		eq.setNom("Cocker 1");
		eq.setResponsable("N.Damamni");
		eq.setTelResponsable("0606060606");
		equipeDao.persist(eq);
		Assert.assertNotNull(eq.getId());	
	}
	
	@Test
	public void testLireParNom() {
		Equipe eq1 = equipeDao.lireParNom("LES AMIS DU FOOT");
		Assert.assertNotNull(eq1);
		Assert.assertEquals("Moby", eq1.getResponsable());
		Equipe eq2 = equipeDao.lireParNom("INCONNUS");
		Assert.assertNull(eq2);
		
	}
}
