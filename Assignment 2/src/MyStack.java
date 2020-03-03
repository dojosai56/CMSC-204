import java.util.ArrayList;
public class MyStack<T> implements StackInterface<T>{

	private T[] stack;
	private int size;
	private int high;
	
	public MyStack(int size) {
		this.size = size;
		stack = (T[]) new Object[this.size];
	}
	
	public MyStack() {
		this.size = 5;
		this.high = 0;
		stack = (T[]) new Object[this.size];
	}
	
	@Override
	public boolean isEmpty() {
		if (high == 0) {
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean isFull() {
		if(high == 5)
			{
			return true;
			}
		else {
			return false;
	}
}

	@Override
	public T pop() {
		T pop;
		high--;
		pop = stack[high];
		stack[high] = null;
		return pop;
	}

	@Override
	public int size() {
		return high;
	}

	@Override
	public boolean push(T entry) {

		if(!isFull()) {
			stack[high] = entry;
			high++;
			return true;
		}
		else 
			return false;
		
	}

	@Override
	public T[] toArray() {
		return stack;
	}

}
