
public class UnboundedQueue<T> implements IUnboundedQueue<T> {

	LinkedList<T> list = new LinkedList<T>();
	
	@Override
	public T dequeue() throws QueueUnderflowException {
		if (list.isEmpty())
			throw new QueueUnderflowException();
		try {
			T data = list.getHead();
			list.deleteHead();
			return data;
		}
		catch(EmptyListException e) {
			throw new QueueUnderflowException();
		}
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public void enqueue(T data) {
		list.insertAtTail(data);
		
	}

}
