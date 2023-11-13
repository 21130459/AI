package classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Node {
	public static final int N = 8;
	private Queen[] state;

	public Node() {
		// generateBoard();
		state = new Queen[N];
	}

	public Node(Queen[] state) {
		this.state = new Queen[N];
		for (int i = 0; i < state.length; i++) {
			this.state[i] = new Queen(state[i].getRow(), state[i].getColumn());
		}
	}

	public Node(Node n) {
		this.state = new Queen[N];
		for (int i = 0; i < N; i++) {
			Queen qi = n.state[i];
			this.state[i] = new Queen(qi.getRow(), qi.getColumn());
		}
	}

	public void generateBoard() {
		Random random = new Random();
		for (int i = 0; i < N; i++) {
			state[i] = new Queen(random.nextInt(N), i);
		}
	}

	public int getH() {
		int heuristic = 0;
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				if(state[i].isConflict(state[j])) heuristic++;
			}
		}
		return heuristic;
	}
	public void move(Queen q) {
		if(q.getRow() == N-1) q.setRow(0);
		else q.setRow(q.getRow()+1);
	}

	public List<Node> generateAllCandidates() {
		List<Node> result = new ArrayList<Node>();
		for (int i = 0; i < state.length; i++) {
			for (int j = 0; j < state.length; j++) {
				Node clone = new Node(this);
				clone.state[i].move();
				result.add(clone);
			}
		}
		return result;
	}

	public Node selectNextRandomCandidate() {
		Random random = new Random();
		List<Node> allCandidates = generateAllCandidates();
		return new Node(allCandidates.get(random.nextInt(allCandidates.size())));
	}

	public void displayBoard() {
		int[][] board = new int[N][N];
		// set queen position on the board
		for (int i = 0; i < N; i++) {
			board[state[i].getRow()][state[i].getColumn()] = 1;
		}
		// print board
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1) {
					System.out.print("Q" + " ");
				} else {
					System.out.print("-" + " ");
				}
			}
			System.out.println();
		}
	}
	public Node execute(Node initialState) {
		Node current = new Node(initialState);

	    while (true) {
	        int currentH = current.getH();
	        List<Node> neighbors = current.generateAllCandidates();

	        boolean noImprovement = true;

	        for (Node neighbor : neighbors) {
	            int neighborH = neighbor.getH();

	            if (neighborH < currentH) {
	                current = new Node(neighbor);
	                noImprovement = false;
	                break;
	            }
	        }

	        if (noImprovement) {
	            // Local minimum reached
	            break;
	        }
	    }

	    return current;
	}
	public Node executeHillClimbingWithRandomRestart(Node initialState,int maxRestarts) {
		Node bestState = null;
	    int bestH = Integer.MAX_VALUE;

	    for (int restart = 0; restart < maxRestarts; restart++) {
	        Node current = execute(initialState);

	        int currentH = current.getH();
	        if (currentH < bestH) {
	            bestState = new Node(current);
	            bestH = currentH;
	        }
	    }

	    return bestState;
	}
}
