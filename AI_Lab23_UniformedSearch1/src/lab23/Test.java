package lab23;

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
	System.out.println("Task 1, 2: Graph search");
	
	System.out.println("BFS root->goal");
	ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
	Node result1 = algo1.execute(nodeS, "G");
	System.out.println(NodeUtils.printPath(result1));
	
	System.out.println();
	System.out.println("BFS start->goal");
	ISearchAlgo algo2 = new BreadthFirstSearchAlgo();
	Node result2 = algo2.execute(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result2));
	
	System.out.println();
	System.out.println("DFS root->goal");
	ISearchAlgo algo3 = new DepthFirstSearchAlgo();
	Node result3 = algo3.execute(nodeS,"G");
	System.out.println(NodeUtils.printPath(result3));
	
	System.out.println();
	System.out.println("DFS start->goal");
	ISearchAlgo algo4 = new DepthFirstSearchAlgo();
	Node result4 = algo4.execute(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result4));
	
	System.out.println("------");
	System.out.println("Task 3: Tree search");
	System.out.println("BFS root->goal");
	ISearchAlgo algo5 = new BreadthFirstSearchAlgo();
	Node result5 = algo5.executeTreeSearch(nodeS, "G");
	System.out.println(NodeUtils.printPath(result5));
	
	System.out.println();
	System.out.println("BFS start->goal");
	ISearchAlgo algo6 = new BreadthFirstSearchAlgo();
	Node result6 = algo6.executeTreeSearch(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result6));
	
	System.out.println();
	System.out.println("DFS root->goal");
	ISearchAlgo algo7 = new DepthFirstSearchAlgo();
	Node result7 = algo7.executeTreeSearch(nodeS,"G");
	System.out.println(NodeUtils.printPath(result7));
	
	System.out.println();
	System.out.println("DFS start->goal");
	ISearchAlgo algo8 = new DepthFirstSearchAlgo();
	Node result8 = algo8.executeTreeSearch(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result8));
	
	System.out.println("------");
	System.out.println("Task 4: UninformCostSearch root->goal");
	ISearchAlgo algo9 = new UniformCostSearchAlgo();
	Node result9 = algo9.execute(nodeS, "G");
	System.out.println(NodeUtils.printPath(result9));
	System.out.println("Path cost: " + result9.getPathCost());
	
	System.out.println("------");
	System.out.println("Task 5: UninformCostSearch start->goal");
	ISearchAlgo algo10 = new UniformCostSearchAlgo();
	Node result10 = algo10.execute(nodeS, "A", "G");
	System.out.println(NodeUtils.printPath(result10));
	System.out.println("Path cost : " + result10.getPathCost());
	
	System.out.println("------");
	System.out.println("Depth-limited search");
	DepthFirstSearchAlgo alg11 = new DepthFirstSearchAlgo();
	Node result11 = alg11.execute(nodeS, "G", 4);
	System.out.println(NodeUtils.printPath(result11));
}
}
