package de.antonafanasjew.projects.nerdstreasury.misc.customscopes;

import java.text.DateFormat;
import java.util.Date;

public class SecondScopedBean {

	public String inspect() {
		return this.toString() + " -> " + DateFormat.getTimeInstance().format(new Date());
	}
	
}
