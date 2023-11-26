package game_alphabeta_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int alpha = Integer.MIN_VALUE;
		int beta = Integer.MAX_VALUE;
		int v = maxValue(node, alpha, beta);
		System.out.println(v);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		int result = Integer.MIN_VALUE;
		if (node.isTerminal()) result = node.getValue();
		else {
			for (Node child : node.getChildren()) {
				result = Math.max(result, minValue(child, alpha, beta));
				if(result >= beta) return result;
				else alpha = Math.max(result, alpha);
			}
		}
		return result;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		int result = Integer.MAX_VALUE;
		if (node.isTerminal()) result = node.getValue();
		else {
			for (Node child : node.getChildren()) {
				result = Math.min(result, minValue(child, alpha, beta));
				if(result <= alpha) return result;
				else beta = Math.min(result, beta);
			}
		}
		return result;
	}
}
