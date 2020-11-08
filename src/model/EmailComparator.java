package model;

import java.util.Comparator;

public class EmailComparator implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getEmail().compareTo(c2.getEmail());
	}

}
