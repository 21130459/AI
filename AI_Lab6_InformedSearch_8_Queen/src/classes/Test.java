package classes;

public class Test {
	public static void main(String[] args) {
		Node initialState = new Node();
        initialState.generateBoard();

        System.out.println("Initial State:");
        initialState.displayBoard();
        System.out.println("Initial Heuristic: " + initialState.getH());

        Node finalState = initialState.executeHillClimbingWithRandomRestart(initialState, 100);

        System.out.println("\nFinal State:");
        finalState.displayBoard();
        System.out.println("Final Heuristic: " + finalState.getH());
	}
}
