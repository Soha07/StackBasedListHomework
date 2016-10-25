
public abstract class StackBasedList<T> implements Stack<T> {
	protected T[] array;
	protected int pointer = 0;
	
	@Override
	public abstract void push(T element);

	@Override
	public T pop() throws Exception {
		if (pointer > 0) {
			return this.array[--pointer];
		}
		else {
			throw new Exception("cannot pop from empty stack!");
		}
	}

	@Override
	public T peek() {
		return this.array[pointer - 1];
	}

	@Override
	public boolean isEmpty() {
		return this.pointer == 0;
	}

	@Override
	public int size() {
		return this.pointer;
	}
}
