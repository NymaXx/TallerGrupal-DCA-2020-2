package model;

import java.util.Comparator;

public class PhoneComparator implements Comparator<Contact>{

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getPhone().compareTo(c2.getPhone());
	}

}
