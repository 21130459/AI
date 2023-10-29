

public class TestAStar {
	public static void main(String[] args) {
		Node s = new Node("S", 6);
		Node b = new Node("B", 4);
		Node a = new Node("A", 4);
		Node c = new Node("C", 4);
		Node d = new Node("D", 3.5);
		Node e = new Node("E", 1);
		Node f = new Node("F", 1);
		Node g = new Node("G", 0);
		
		s.addEdge(b, 3);
		s.addEdge(a, 2);
		a.addEdge(c, 3);
		b.addEdge(d, 3);
		b.addEdge(c, 1);
		c.addEdge(e, 3);
		c.addEdge(d, 1);
		d.addEdge(f, 2);
		f.addEdge(g, 1);
		e.addEdge(g, 2);
		System.out.println("1");
		IInformedSearchAlgo greedy1 = new GreedyBestFirstSearchAlgo();
		Node res1 = greedy1.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res1));
		
		System.out.println("2");
		IInformedSearchAlgo aStar1 = new AStarSearchAlgo();
		Node res2 = aStar1.execute(s, g.getLabel());
		System.out.println(NodeUtils.printPath(res2));
		System.out.println("3");
		
		AStarSearchAlgo aStar2 = new AStarSearchAlgo();
		System.out.println(aStar2.isAdmissibleH(s, g.getLabel()));
		
		System.out.println("4");
		IInformedSearchAlgo greedy2 = new GreedyBestFirstSearchAlgo();
		Node res3 = greedy2.execute(s, a.getLabel(), g.getLabel());
		System.out.println(NodeUtils.printPath(res3));
		
		IInformedSearchAlgo aStar3 = new AStarSearchAlgo();
		Node res4 = aStar3.execute(s, a.getLabel(), g.getLabel());
		System.out.println(NodeUtils.printPath(res4));
	}
}
