package gdes.lamiduf.pages;

import gdes.lamiduf.domain.Equipe;
import gdes.lamiduf.exception.LamidufException;
import gdes.lamiduf.manager.EquipeManager;

import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class Equipes {
	
	@Property
	private List<Equipe> equipes;
	
	@Inject
	private EquipeManager equipeManager;
	
	@OnEvent(EventConstants.ACTIVATE)
	public void loadEquipes() throws LamidufException {
		equipes = equipeManager.listerEquipes();
	}
	
}
