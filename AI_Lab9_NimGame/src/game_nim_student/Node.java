package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		// Enter your code here
		Set<Node> successsors = new HashSet<Node>();
		if (!isTerminal()) {
//			Collections.sort(this.data, DESCOMPARATOR);
			int index = this.data.get(0) / 2;
			for (int i = 1; i < index + 1; i++) {
				Node child = new Node();
				child.data.add(((Integer)this.data.get(0)-i));
				child.data.add(((Integer)i));
				for (int j = 1; j < this.data.size(); j++) {
					child.add(this.data.get(j));
				}
				Collections.sort(child.data, DESCOMPARATOR);
				successsors.add(child);
			}
			
		}
		List<Node> re = new ArrayList<Node>();
		for(Node n : successsors) {
			re.add(n);
		}
		return re;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		Collections.sort(this.data, DESCOMPARATOR);
		return (this.data.get(0) <= 2);
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}
	
}
