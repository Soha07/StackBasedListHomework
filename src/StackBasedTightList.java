
public class StackBasedTightList<T> extends StackBasedList<T> {
	
	private static final int INCREMENT_CONSTANT = 4;
	
	@SuppressWarnings("unchecked")
	public StackBasedTightList () {
		this.array = (T[])(new Object[0]);
	}

	@Override
	public void push(T element) {
		if (this.array.length <= this.pointer) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[])(new Object[this.array.length + INCREMENT_CONSTANT]);
			for (int i = 0; i < this.array.length; i++) {
				temp[i] = this.array[i];
			}
			this.array = temp;
		}
		this.array[pointer++] = element;
	}
}
