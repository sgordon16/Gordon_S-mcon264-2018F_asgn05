
public interface IList<T> {
	void insertAtHead(T data);
	void insertAt(T data, int index) throws InvalidIndexException;
	void insertAtTail(T data);
	void deleteHead() throws EmptyListException;
	void deleteAt(int index) throws InvalidIndexException;
	void deleteTail() throws EmptyListException;
	T getHead() throws EmptyListException;
	T getAt(int index) throws EmptyListException, InvalidIndexException;
	T getTail() throws EmptyListException;
	int length();
	boolean isEmpty();
}
