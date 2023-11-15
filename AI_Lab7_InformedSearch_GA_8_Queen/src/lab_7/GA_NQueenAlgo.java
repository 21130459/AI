package lab_7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.naming.ldap.Rdn;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;//Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}
	
	public Node execute() {
		// chua cac node co H nho nhat cua moi quan the moi
		Node result = new Node();
		List<Node> newPopulation = new ArrayList<Node>();
		for (int i = 0; i < MAX_ITERATIONS; i++) {
			for (int j = 0; j < POP_SIZE; j++) {
				Node child = reproduce(getParentByTournamentSelection(), getParentByTournamentSelection());
				if(child.getH() == 0) {
					System.out.println(i);
					return child;
				}
				newPopulation.add(child);
			}
			Collections.sort(newPopulation);
			if(newPopulation.get(0).getH() < this.population.get(0).getH()) result = new Node(newPopulation.get(0));
			this.population = newPopulation;
		}
		return result;
	}
	// Mutate an individual by selecting a random Queen and
	//move it to a random row.
	public void mutate(Node node) {
		int i = rd.nextInt(Node.N);
//		System.out.println("queen thu" + i);
		int r = rd.nextInt(Node.N);
		node.setRow(i, r);
	}
	//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
//		System.out.println("c:" + c);
		Node result = new Node();
		for (int i = 0; i < Node.N; i++) {
			if(i <= c) result.setRow(i, x.getRow(i));
			else result.setRow(i, y.getRow(i));
		}
		return result;
	}
	// Select K individuals from the population at random and
	//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		// Enter your code here
		//k=3
		Node result = new Node(getParentByRandomSelection());
		for (int i = 2; i < 4; i++) {
			Node temp = new Node(getParentByRandomSelection());
			if(temp.getH() < result.getH()) result = new Node(temp);
//			System.out.println("Invidual " + i + ":"+ this.population.get(index).getH());
		}
		return result;
	}
	//Select a random parent from the population
	public Node getParentByRandomSelection() {
		// Enter your code here
		int index = rd.nextInt(POP_SIZE);
		return this.population.get(index);
	}
}
