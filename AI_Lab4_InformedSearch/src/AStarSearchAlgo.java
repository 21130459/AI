import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByF());
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
					child.setG(edge.getWeight() + current.getG());
					child.setParent(current);
					frontier.add(child);
				}
				else if(frontier.contains(child) && child.getG() > edge.getWeight() + current.getG()) {
					child.setG(edge.getWeight() + current.getG());
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

	public boolean isAdmissibleH(Node root, String goal) {
		double h = root.getH();
		double hStar = execute(root, goal).getG();
		System.out.println("h:" + h + " " + "h*:" + hStar);
		return h <= hStar ;
	}
}
