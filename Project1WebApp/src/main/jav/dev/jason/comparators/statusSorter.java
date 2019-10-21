package dev.jason.comparators;

import java.util.Comparator;

import dev.jason.entities.Reimbursement;

public class statusSorter implements Comparator<Reimbursement> {

	@Override
	public int compare(Reimbursement o1, Reimbursement o2) {
		return o1.getStatus().compareToIgnoreCase(o2.getStatus());
	}

}
