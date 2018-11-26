
public interface IStack<T> { 
	
	void pop() throws StackUnderflowException;
	T top() throws StackUnderflowException;
	boolean isEmpty();
}
