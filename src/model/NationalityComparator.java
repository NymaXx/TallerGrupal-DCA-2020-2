package model;

import java.util.Comparator;

public class NationalityComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getNationality().compareTo(c2.getNationality());
	}

}
