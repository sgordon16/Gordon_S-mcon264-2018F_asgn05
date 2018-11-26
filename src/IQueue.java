
public interface IQueue<T> {
	public T dequeue() throws QueueUnderflowException;
	public boolean isEmpty();
	public boolean isFull();
}
