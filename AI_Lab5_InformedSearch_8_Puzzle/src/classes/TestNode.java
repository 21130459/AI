package classes;

import java.util.Arrays;

public class TestNode {
	public static void main(String[] args) {
		Puzzle p = new Puzzle();
		p.readInput("D:\\CODE\\AI_Lab5_InformedSearch_8_Puzzle\\src\\txt\\PuzzleMap.txt", "D:\\CODE\\AI_Lab5_InformedSearch_8_Puzzle\\src\\txt\\PuzzleGoalState.txt");
		Node initialState = p.getInitialState();
		Node tmp = new Node(initialState);
		System.out.println(initialState.equals(tmp));
		Node goalState = p.getGoalState();
		System.out.println("Initial state:");
		System.out.println(tmp);
		System.out.println("Goal state:");
		System.out.println(goalState);
		
		// Compute H1
		System.out.println("H1: " + p.computeH1(tmp));
		
		// Compute H2
		System.out.println("H2: " + p.computeH2(tmp));
		System.out.println();
		
		System.out.println("Move right while tile from initial state:");
		Node right = p.moveWhiteTile(tmp, 'r');
		System.out.println(right);
		
		System.out.println("Move  left tile from initial state:");
		Node left = p.moveWhiteTile(tmp, 'l');
		System.out.println(left);
		
		System.out.println("Move up while tile from initial state:");
		Node up = p.moveWhiteTile(tmp, 'u');
		System.out.println(up);

		System.out.println("Move down while tile from initial state:");
		Node down = p.moveWhiteTile(tmp, 'd');
		System.out.println(down);
		
		Node execGreedy = p.executeGreedyBFS(p);
		System.out.println(execGreedy);
		System.out.println("AStars");
		Node execAStar = p.executeAStar(p);
		System.out.println(execAStar);
	}
}
