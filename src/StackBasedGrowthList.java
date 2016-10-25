
public class StackBasedGrowthList<T> extends StackBasedList<T> {

	@SuppressWarnings("unchecked")
	public StackBasedGrowthList () {
		this.array = (T[])(new Object[1]);
	}
	
	@Override
	public void push(T element) {
		if (this.array.length <= this.pointer) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[])(new Object[this.array.length * 2]);
			for (int i = 0; i < this.array.length; i++) {
				temp[i] = this.array[i];
			}
			this.array = temp;
		}
		this.array[pointer++] = element;
	}
}
