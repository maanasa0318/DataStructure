package stack;

public class Pair {
	int value;
	int index;
	
	public Pair(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
}
