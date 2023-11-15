package lab_7;



public class Test {
public static void main(String[] args) {
	GA_NQueenAlgo ga = new GA_NQueenAlgo();
	Node result = new Node();
	
	//reproduce()
	System.out.println("reproduce()");
	System.out.println("x");
	Node x = new Node();
    x.displayBoard();
    System.out.println("y");
    Node y = new Node();
    y.displayBoard();
    System.out.println("child");
    result = new Node(ga.reproduce(x, y));
    result.displayBoard();
    
    //mutate()
    System.out.println("mutate()");
    ga.mutate(result);
    result.displayBoard();
    
    //getParentByTournamentSelection()
    System.out.println("getParentByTournamentSelection()");
    ga.initPopulation();
    result = new Node(ga.getParentByTournamentSelection());
    result.displayBoard();
    System.out.println("H of result:" + result.getH());
    
    //getParentByRandomSelection()
    System.out.println("getParentByRandomSelection()");
    result = new Node(ga.getParentByRandomSelection());
    result.displayBoard();
    
    //excute()
    System.out.println("excute()");
    result = new Node(ga.execute());
    result.displayBoard();
    System.out.println(result.getH());
}
}
