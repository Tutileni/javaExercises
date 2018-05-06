package question;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Monnaie {
	long piece2=0;
	long piece5=0;
	long piece10=0;
}
class Soluction{
	
	static Monnaie monnaieOptimale(int s){
		Monnaie m=new Monnaie();
		List<Integer> change=makeChangeUsingMap(s);
	    m.piece2=Collections.frequency(change, 2);
	    m.piece5=Collections.frequency(change, 5);
	    m.piece10=Collections.frequency(change, 10);
		return m;
	}
	// How many cents in a dollar.
	private static final int EUR = 1;
	// In cents.
	private static final int[] denominations = {
	    // $100
	    10 * EUR,
	    // $50
	    5 * EUR,
	    // $20
	    2 * EUR,
	};
	// All the best lists I've seen so far.
	static Map<Integer, List<Integer>> memory = new HashMap<>();

	static List<Integer> makeChangeUsingMap(int value) {
	    // If we've seen this one before, use it.
	    if (memory.containsKey(value)) {
	        return memory.get(value);
	    }
	    // Null means none found so far.
	    List<Integer> change = null;
	    System.out.println("Make change for " + value);
	    // For all denomination.
	    for (int i : denominations) {
	        // that is less than the value
	        if (i <= value) {
	            // Build a new candidate.
	            List<Integer> newChange = new LinkedList<>();
	            // Remember it.
	            newChange.add(i);
	            // If we are at zero we're done.
	            if (i < value) {
	                // Make change from the remaining value.
	                List<Integer> theRest = makeChangeUsingMap(value - i);
	                if (theRest != null) {
	                    // Gode more.
	                    newChange.addAll(theRest);
	                }
	            }
	            // Is it shorter?
	            if (change == null || newChange.size() < change.size()) {
	                // Better.
	                change = newChange;
	                System.out.println("Better change for " + value + " = " + change);
	                // Remember it.
	                memory.put(value, change);
	            }
	        }
	    }
	    return change;
	}
	
}