package Task123;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo{
	
	@Override
    public Node execute(Node root, String goal) {
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			explored.add(current);
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				List<Edge> copy = new ArrayList<>(childrens);
				Collections.reverse(copy);
				for (Edge edge : copy) {
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
    	Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			explored.add(current);
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				List<Edge> copy = new ArrayList<>(childrens);
				Collections.reverse(copy);
				for (Edge edge : copy) {
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
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				List<Edge> copy = new ArrayList<>(childrens);
				Collections.reverse(copy);
				for (Edge edge : copy) {
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
		Stack<Node> frontier = new Stack<>();
		frontier.add(root);
		while (!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel() == goal) {
				return current;
			}
			else {
				List<Edge> childrens = current.getChildren();
				List<Edge> copy = new ArrayList<>(childrens);
				Collections.reverse(copy);
				for (Edge edge : copy) {
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
