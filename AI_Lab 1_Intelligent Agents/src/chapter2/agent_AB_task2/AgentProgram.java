package chapter2.agent_AB_task2;

import java.util.Random;
import chapter2.agent_AB_task2.Environment.LocationState;

public class AgentProgram {
	
	private Action getDynamicAction(int index) {
		if (index == getIndex("left")) {
			return Environment.MOVE_LEFT;
		}
		if (index == getIndex("right")) {
			return Environment.MOVE_RIGHT;
		}
		if (index == getIndex("up")) {
			return Environment.MOVE_UP;
		}
		else return Environment.MOVE_DOWN;
	}

	public int getIndex(String direction) {
		if(direction == "left") {
			return 1;
		}
		else if(direction == "right") {
			return 2;
		}
		else if(direction == "up") {
			return 3;
		}
		else if(direction == "down") {
			return 4;
		}
		else return 0;
	}

	public int createRandom() {		
		Random random = new Random();
		return random.nextInt(4);
	}
	
	public Action execute(Percept p) {// location, status
		if (p.getLocationState()==LocationState.DIRTY) {
			return Environment.SUCK_DIRT;	
		}
		else {
			int resultRandom = createRandom();
			return getDynamicAction(resultRandom);
		}
	}	
}