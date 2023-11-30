package game_nim_student;


public class MinimaxAlgo {
	public void execute(Node node) {
		int v = minValue(node);
		System.out.println(v);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
		int result = Integer.MIN_VALUE;
		if (node.isTerminal()) result = 0;
		else {
			for (Node child : node.getSuccessors()) {
				result = Math.max(result, minValue(child));
			}
		}
		System.out.print(node.toString());
		System.out.println(result);
		return result;
	}

	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v
	public int minValue(Node node) {
		int result = Integer.MAX_VALUE;
		if (node.isTerminal()) result = 1;
		else {
			for (Node child : node.getSuccessors()) {
				result = Math.min(result, maxValue(child));
			}
		}
		System.out.print(node.toString());
		System.out.println(result);
		return result;
	}
}
