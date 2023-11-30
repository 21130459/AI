package game_nim_student;

import java.util.Arrays;
import java.util.List;

public class TestNode {
	public static void main(String[] args) {
		Node node = new Node();
		Integer[] data = { 7 };
		node.addAll(Arrays.asList(data));

		MinimaxAlgo algo = new MinimaxAlgo();
		System.out.println(node.isTerminal());
		System.out.println(node.getSuccessors());
		algo.execute(node);
	}
}