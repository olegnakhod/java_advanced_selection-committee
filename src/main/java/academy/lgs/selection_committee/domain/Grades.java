package academy.lgs.selection_committee.domain;

public enum Grades {
	A(5),B(4),C(3),D(2),E(1);
	
	private int value;
	
	private Grades(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
