package de.antonafanasjew.projects.nerdstreasury.misc.methodinjections;

import java.text.DateFormat;
import java.util.Date;

/**
 * Note: Nowhere in the code is any implementation of this abstract class.
 * Spring will create it on the fly with the means of the method injection.
 */
public abstract class CurrentDateFormatter {

	public String currentDateRepresentation() {
		Date date = createDate();
		return DateFormat.getDateInstance().format(date);
	}

	protected abstract Date createDate();
	
}
