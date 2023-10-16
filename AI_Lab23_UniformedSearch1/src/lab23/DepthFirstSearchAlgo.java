package lab23;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{
	
	@Override
    public Node execute(Node root, String goal) {
		root.setParent(null);
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			explored.add(current);
			if(current.getLabel().equals(goal)) {
				return current;
			}
			Collections.reverse(current.getChildren());
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
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getLabel().equals(goal)) {
				return current;
			}
			Collections.reverse(current.getChildren());
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
		return executeTreeSearch(execute(root, start), goal);
	}
	
	public Node execute(Node root, String goal, int limitedDepth) {
		root.setParent(null);
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if(current.getDepth() > limitedDepth) return null;
			if(current.getLabel().equals(goal));
			Collections.reverse(current.getChildren());
			for (Edge edge : current.getChildren()) {
				Node child = edge.getEnd();
				if(frontier.contains(child)) {
					Node clone = ((Node)child.clone());
					clone.setDepth(current.getDepth() + 1);
					clone.setParent(current);
					frontier.add(clone);
				}
				else {
					child.setDepth(current.getDepth() + 1);
					child.setParent(current);
					frontier.add(child);
				}
			}
		}
		return null;
	}
}
