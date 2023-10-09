package Task123;

public class Test {
public static void main(String[] args) {
	Node nodeS = new Node("S");
	Node nodeA = new Node("A"); Node nodeB = new Node("B");
	Node nodeC = new Node("C"); Node nodeD = new Node("D");
	Node nodeE = new Node("E"); Node nodeF = new Node("F");
	Node nodeG = new Node("G"); Node nodeH = new Node("H");
	nodeS.addEdge(nodeA, 5); nodeS.addEdge(nodeB, 2);
	nodeS.addEdge(nodeC, 4); nodeA.addEdge(nodeD, 9);
	nodeA.addEdge(nodeE, 4); nodeB.addEdge(nodeG, 6);
	nodeC.addEdge(nodeF, 2); nodeD.addEdge(nodeH, 7);
	nodeE.addEdge(nodeG, 6); nodeF.addEdge(nodeG, 1);
	System.out.println("Graph search:");
	
	System.out.println("BreadthFirst excute tu root");
	ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
	Node result1 = algo1.execute(nodeS, "G");
	System.out.println(NodeUtils.printPath(result1));
	
	System.out.println("BreadthFirst excute tu start");
	ISearchAlgo algo2 = new BreadthFirstSearchAlgo();
	Node result2 = algo2.execute(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result2));
	
	System.out.println("DepthFirst excute tu root");
	ISearchAlgo algo3 = new DepthFirstSearchAlgo();
	Node result3 = algo3.execute(nodeS,"G");
	System.out.println(NodeUtils.printPath(result3));
	
	System.out.println("DepthFirst excute tu start");
	ISearchAlgo algo4 = new DepthFirstSearchAlgo();
	Node result4 = algo4.execute(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result4));
	
	System.out.println("------");
	System.out.println("Tree search");
	System.out.println("BreadthFirst excute tu root");
	ISearchAlgo algo5 = new BreadthFirstSearchAlgo();
	Node result5 = algo5.excuteTreeSearch(nodeS, "G");
	System.out.println(NodeUtils.printPath(result5));
	
	System.out.println("BreadthFirst excute tu start");
	ISearchAlgo algo6 = new BreadthFirstSearchAlgo();
	Node result6 = algo6.excuteTreeSearch(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result6));
	
	System.out.println("DepthFirst excute tu root");
	ISearchAlgo algo7 = new DepthFirstSearchAlgo();
	Node result7 = algo7.excuteTreeSearch(nodeS,"G");
	System.out.println(NodeUtils.printPath(result7));
	
	System.out.println("DepthFirst excute tu start");
	ISearchAlgo algo8 = new DepthFirstSearchAlgo();
	Node result8 = algo8.excuteTreeSearch(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result8));
}
}
