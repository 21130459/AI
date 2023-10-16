package lab23;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
	
	@Override
	public Node execute(Node root, String goal) {
		root.setParent(null);
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}
			for (Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if (!frontier.contains(child) && !explored.contains(child)) {
					child.setParent(current);
					frontier.add(child);
				}
			}
		}
		return null;
	}
		
	@Override
	public Node execute(Node root, String start, String goal) {
		return execute(execute(root, start), goal);
	}
	@Override
	public Node executeTreeSearch(Node root, String goal) {
		root.setParent(null);
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			for (Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(frontier.contains(child)) {
					Node clone = ((Node)child.clone());
					clone.setParent(current);
					frontier.add(clone);
				}
				else {
					child.setParent(current);
					frontier.add(child);
				}
			}
		}
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String start, String goal) {
		return executeTreeSearch(executeTreeSearch(root, start), goal);
	}
}
