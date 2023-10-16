package lab23;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
		root.setParent(null);
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
					child.setPathCost(edge.getWeight() + current.getPathCost());
					child.setParent(current);
					frontier.add(child);
				}
				else if(child.getPathCost() > edge.getWeight() + current.getPathCost()) {
					child.setPathCost(edge.getWeight() + current.getPathCost());
					child.setParent(current);
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
		return null;
	}

	@Override
	public Node executeTreeSearch(Node root, String start, String goal) {
		return null;
	}
}
