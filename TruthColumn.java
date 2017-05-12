
public class TruthColumn {
	private boolean[] constants1;
	
	public TruthColumn(boolean[] constants1) {
		this.constants1 = constants1;
	}
	
	/**
	 * evaluates the conjunction of the constants
	 * @param constants2 the constants that are evaluated
	 * @return the conjunction of the constants
	 */
	public boolean[] and(boolean[] constants2) {
		boolean[] evaluate = new boolean[constants1.length];
		for (int i = 0; i < constants1.length; i++) {
			evaluate[i] = constants1[i] && constants2[i];
		}
		return evaluate;
	}
	
	/**
	 * evaluates the disjunction of the constants
	 * @param constants2 the constants that are evaluated
	 * @return the disjunction of the constants
	 */
	public boolean[] or(boolean[] constants2) {
		boolean[] evaluate = new boolean[constants1.length];
		for (int i = 0; i < constants1.length; i++) {
			evaluate[i] = constants1[i] || constants2[i];
		}
		return evaluate;
	}
	
	/**
	 * evaluates the negation of the constants
	 * @return the negation of the constants
	 */
	public boolean[] negate() {
		boolean[] evaluate = new boolean[constants1.length];
		for (int i = 0; i < constants1.length; i++) {
			evaluate[i] = !constants1[i];
		}
		return constants1;
	}
	
	/**
	 * evaluates the implication of the constants
	 * @param constants2 the constants that are evaluated
	 * @return the implication of the constants
	 */
	public boolean[] imply(boolean[] constants2) {
		boolean[] evaluate = new boolean[constants1.length];
		for (int i = 0; i < constants1.length; i++) {
			if ((constants1[i] == true) && (constants2[i] == false)) {
				evaluate[i] = false;
			}
			else {
				evaluate[i] = true;
			}
		}
		return evaluate;
	}
	
	/**
	 * evaluates the biconditional of the constants
	 * @param constants2 the constants that are evaluated
	 * @return the biconditional of the constants
	 */
	public boolean[] biconditional(boolean[] constants2) {
		boolean[] evaluate = new boolean[constants1.length];
		for (int i = 0; i < constants1.length; i++) {
			if (constants1[i] == constants2[i]) {
				evaluate[i] = true;
			}
			else {
				evaluate[i] = false;
			}
		}
		return evaluate;
	}
	
	/**
	 * checks if the sentence is valid
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @return true if the sentence is valid and false if the sentence is not valid
	 */
	public boolean valid(boolean[] constants2, String operator) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		for (int i = 0; i < evaluate.length; i++) {
			if (evaluate[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks if the sentence is unsatisfiable
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @return true if the sentence is unsatisfiable and false if the sentence is not unsatisfiable
	 */
	public boolean unsatisfiable(boolean[] constants2, String operator) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		for (int i = 0; i < evaluate.length; i++) {
			if (evaluate[i] == false) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks if the sentence is contingent
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @return true if the sentence is contingent and false if the sentence is not contingent
	 */
	public boolean contingent(boolean[] constants2, String operator) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < evaluate.length; i++) {
			if (evaluate[i] == true) {
				count1 = count1 + 1;
			}
			else if (evaluate[i] == false) {
				count2 = count2 + 1;
			}
		}
		return false;
	}
	
	/**
	 * checks if the sentences are equivalent
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @param constants3 the constants that are equivalent
	 * @return true if the sentences are equivalent and false if the sentences are not equivalent
	 */
	public boolean equivalent(boolean[] constants2, String operator, boolean[] constants3) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		for (int i = 0; i < evaluate.length; i++) {
			if (evaluate[i] != constants3[i]) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks if one sentence logically entails the other sentence
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @param constants3 the constants that are entailed
	 * @return true if one sentence logically entails the other sentence and false if one sentence does not logically entail the other sentence
	 */
	public boolean entails(boolean[] constants2, String operator, boolean[] constants3) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		for (int i = 0; i < evaluate.length; i++) {
			if ((evaluate[i] == true) && (constants3[i] == false)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * checks if the sentences are consistent
	 * @param constants2 the constants that are evaluated
	 * @param operator the operator that evaluates the constants
	 * @param constants3 the constants that are consistent
	 * @return true if the sentences are consistent and false if the sentences are not consistent
	 */
	public boolean consistent(boolean[] constants2, String operator, boolean[] constants3) {
		boolean[] evaluate = new boolean[constants1.length];
		if (operator.equals("&")) {
			evaluate = and(constants2);
		}
		else if (operator.equals("|")) {
			evaluate = or(constants2);
		}
		for (int i = 0; i < evaluate.length; i++) {
			if ((evaluate[i] == true) && (constants3[i] == true)) {
				return true;
			}
		}
		return false;
	}
}
