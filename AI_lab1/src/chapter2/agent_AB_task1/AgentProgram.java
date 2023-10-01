package chapter2.agent_AB_task1;

import chapter2.agent_AB_task1.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		if (p.getLocationState()==LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
		else if (p.getAgentLocation() == Environment.LOCATION_A){
			return Environment.MOVE_RIGHT;
		}
		else if (p.getAgentLocation() == Environment.LOCATION_B){
			return Environment.MOVE_LEFT;
		}
		else return NoOpAction.NO_OP;
	}
}