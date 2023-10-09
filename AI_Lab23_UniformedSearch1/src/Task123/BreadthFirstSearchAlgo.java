package Task123;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo{
	
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				for (Edge edge : childrens) {
					if(edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					if (!frontier.contains(edge.getEnd()) && !explored.contains(edge.getEnd())) {
						frontier.add(edge.getEnd());
					}
				}
			}
		}
		return null;
	}
		
	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			explored.add(current);
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				for (Edge edge : childrens) {
					if (edge.getEnd().getLabel() == start){
						edge.getEnd().setParent(null);
					}
					else {
						edge.getEnd().setParent(current);
					}
					if (!frontier.contains(edge.getEnd()) && !explored.contains(edge.getEnd())) {
						frontier.add(edge.getEnd());
					}
				}
			}
		}
		return null;
	}

	@Override
	public Node excuteTreeSearch(Node root, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				for (Edge edge : childrens) {
					if(edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					frontier.add(edge.getEnd());
				}
			}
		}
		return null;
	}

	@Override
	public Node excuteTreeSearch(Node root, String start, String goal) {
		Queue<Node> frontier = new LinkedList<Node>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				for (Edge edge : childrens) {
					if (edge.getEnd().getLabel() == start){
						edge.getEnd().setParent(null);
					}
					else {
						edge.getEnd().setParent(current);
					}
					frontier.add(edge.getEnd());
				}
			}
		}
		return null;
	}
}
