package divinerpg.capability;

public class SoulTrapCount {
	public int count;
	public SoulTrapCount() {
		count = 0;
	}
	public SoulTrapCount(int i) {
		count = i;
	}
	public void add() {
		count++;
	}
	public void remove() {
		count--;
		if(count < 0) count = 0;
	}
}