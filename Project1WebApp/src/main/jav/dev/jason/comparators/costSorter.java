package dev.jason.comparators;
import java.util.Comparator;

import dev.jason.entities.Reimbursement;

public class costSorter implements Comparator<Reimbursement>{

	@Override
	public int compare(Reimbursement o1, Reimbursement o2) {
		
		 return (int) (o2.getCost() - o1.getCost()); 
	}

}
