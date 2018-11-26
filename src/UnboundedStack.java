
public class UnboundedStack<T> implements IUnboundedStack<T> {

	LinkedList<T> list = new LinkedList<T>();

	@Override
	public void pop() throws StackUnderflowException {
		if (list.isEmpty())
			throw new StackUnderflowException();
		try {
			list.deleteHead();
		}
		catch(EmptyListException e) {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() throws StackUnderflowException {
		if (list.isEmpty())
			throw new StackUnderflowException();
		try {
			T data = list.getHead();
			return data;
		}
		catch(EmptyListException e) {
			throw new StackUnderflowException();
		}
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void push(T element) {
		list.insertAtHead(element);
		
	}
	
	
}
