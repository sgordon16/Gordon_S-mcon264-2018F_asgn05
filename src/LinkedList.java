
public class LinkedList<T> implements IList<T> {
	
	private Node<T> head = null;
	private int size = 0;
	
	@Override
	public void insertAtHead(T data) {		
		Node<T> newNode = new Node<T>(data);
		newNode.setNext(head);
		head = newNode;
		size++;
	}

	@Override
	public void insertAt(T data, int index) throws InvalidIndexException {
		// TODO Auto-generated method stub
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (index >= size)
			throw new InvalidIndexException();
		
		
		if (index == 0)
			insertAtHead(data);
		else {
			Node<T> newNode = new Node<T>(data);
			Node<T> currNode = head;
			Node<T> prevNode = null;
			for (int i = 0; i < index; i++)
			{
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext(newNode);
			newNode.setNext(currNode);
			size++;
		}
	}

	@Override
	public void insertAtTail(T data) {
		if (isEmpty())
			insertAtHead(data);
		else {
			Node<T> currNode = head;
			Node<T> prevNode = null;
			while (currNode != null) {
				prevNode = currNode;
				currNode = currNode.getNext();
			}
			prevNode.setNext(new Node<T>(data));
			size++;
		}
	}

	@Override
	public void deleteHead() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();
		
		head = head.getNext();
		size--;
	}

	@Override
	public void deleteAt(int index) throws InvalidIndexException {
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (index == 0)
			try { deleteHead();}
			catch(EmptyListException e) {throw new InvalidIndexException();}
		
		if (index >= size)
			throw new InvalidIndexException();
		
		Node currNode = head;
		Node prevNode = null;
		
		for (int i = 0; i < index; i++)
		{
			prevNode = currNode;
			currNode = currNode.getNext();
		}
		prevNode.setNext(currNode.getNext());
		size--;
	}

	@Override
	public void deleteTail() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();
		
		if (head.getNext() == null)
			head = null;
		
		Node currNode = head;
		
		while (currNode.getNext().getNext() != null)
			currNode = currNode.getNext();
		
		currNode.setNext(null);
		
		size--;
	}

	@Override
	public T getHead() throws EmptyListException {
		if (isEmpty())
			throw new EmptyListException();
		return head.getData();
	}

	@Override
	public T getAt(int index) throws EmptyListException, InvalidIndexException {
		// TODO Auto-generated method stub
		if (index < 0)
			throw new InvalidIndexException("Negative index specified");
		
		if (isEmpty())
			throw new InvalidIndexException();
		
		if (index >= size)
			throw new InvalidIndexException();
		
		Node<T> currNode = head;
		for (int i = 0; i < index; i++)
			currNode = currNode.getNext();	
		
		return currNode.getData();
	}

	@Override
	public T getTail() throws EmptyListException {
		// TODO Auto-generated method stub
		if (isEmpty())
			throw new EmptyListException();
		Node<T> curr = head;
		
		while (curr.getNext() != null)
			curr = curr.getNext();
		
		return curr.getData();
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}

}
