
public class Program {
	
	public static void main(String[] args) throws QueueUnderflowException, StackUnderflowException {
		DirectoryObject root = new DirectoryObject("root");
		root.getChildren().add(new DirectoryObject("Dir A"));
		root.getChildren().add(new FileObject("File 1", "conceived in liberty "));
		root.getChildren().add(new FileObject("File 2", "and dedicated to the proposition "));
		root.getChildren().add(new DirectoryObject("Dir B"));
		
		((DirectoryObject)(root.getChildren().get(0))).getChildren().add(new FileObject("File 3", "Four score and seven years ago "));
		((DirectoryObject)(root.getChildren().get(0))).getChildren().add(new FileObject("File 4", "our fathers brought forth on this continent "));
		((DirectoryObject)(root.getChildren().get(0))).getChildren().add(new DirectoryObject("Dir C"));
		((DirectoryObject)(root.getChildren().get(3))).addFile(new FileObject("File 5", "that all men are created equal."));
		((DirectoryObject)
			((DirectoryObject)
				((DirectoryObject)(root.getChildren().get(0))).getChildren().get(2))).addFile(new FileObject("File 6", "a new nation "));
				
		// Calls to the custom methods:
		System.out.println("Recursive:");
		displayInfoRecursive(root);
		System.out.println("Total size: " + root.size() + "\n");
		System.out.println("\n\nStack:");
		displayInfoStack(root);
		System.out.println("Total size: " + root.size() + "\n");
		System.out.println("\n\nQueue:");
		displayInfoQueue(root);
		System.out.println("Total size: " + root.size() + "\n");
		System.out.println("\n\nUpdating...\n\n");
		updateFilesRecursive(root);
		System.out.println("Recursive:");
		displayInfoRecursive(root);
		System.out.println("Total size: " + root.size() + "\n");
		System.out.println("\n\nStack:");
		displayInfoStack(root);
		System.out.println("Total size: " + root.size() + "\n");
		System.out.println("\n\nQueue:");
		displayInfoQueue(root);
		System.out.println("Total size: " + root.size() + "\n");
	}
	
	public static void displayInfoStack(DiskObject d) throws StackUnderflowException {
		UnboundedStack<DiskObject> stack = new UnboundedStack<DiskObject>();
		stack.push(d);
		while(!stack.isEmpty()) {
			DiskObject disk = stack.top();
			stack.pop();
			if(disk instanceof FileObject) {
				System.out.println(disk.toString());
			}
			if(disk instanceof DirectoryObject) {
				DirectoryObject directory = (DirectoryObject) disk;
				System.out.println(directory.toString());
				for(int i = 0; i < directory.getChildren().size(); i++) {
					stack.push((DiskObject) directory.getChildren().get(i));
				}
			}
		}
	}
	public static void displayInfoQueue(DiskObject d) throws QueueUnderflowException {
		UnboundedQueue<DiskObject> queue = new UnboundedQueue<DiskObject>();
		queue.enqueue(d);
		while(!queue.isEmpty()) {
			DiskObject disk = queue.dequeue();
			if(disk instanceof FileObject) {
				System.out.println(disk.toString());
			}
			if(disk instanceof DirectoryObject) {
				DirectoryObject directory = (DirectoryObject) disk;
				System.out.println(directory.toString());
				for(int i = 0; i < directory.getChildren().size(); i++) {
					queue.enqueue((DiskObject) directory.getChildren().get(i));
				}
			}
		}
	}
	public static void displayInfoRecursive(DiskObject d) {
		if(d instanceof FileObject) 
			System.out.println(d.toString());
		if(d instanceof DirectoryObject) {
			DirectoryObject directory = (DirectoryObject) d;
			System.out.println(directory.toString());
			for(int i = 0; i < directory.getChildren().size(); i++) 
				displayInfoRecursive((DiskObject) directory.getChildren().get(i));
		}
	}
	public static void updateFilesStack(DiskObject d) throws StackUnderflowException {
		UnboundedStack<DiskObject> stack = new UnboundedStack<DiskObject>();
		stack.push(d);
		while(!stack.isEmpty()) {
			DiskObject disk = stack.top();
			stack.pop();
			if(disk instanceof FileObject) {
				FileObject file = (FileObject) d;
				file.setData(file.getData().substring(0, (file.getData().length() > 25) ?
						file.getData().length() - (file.getData().length() - 25) : 
							file.getData().length()));
				file.setName("Fixed - " + file.getName());
			}
		}
		if(d instanceof DirectoryObject) {
			DirectoryObject directory = (DirectoryObject) d;
			for(int i = 0; i < directory.getChildren().size(); i++) 
				stack.push((DiskObject) directory.getChildren().get(i));
			directory.setName("Fixed - " + directory.getName());
		}
	}
	public static void updateFilesQueue(DiskObject d) throws QueueUnderflowException {
		UnboundedQueue<DiskObject> queue = new UnboundedQueue<DiskObject>();
		queue.enqueue(d);
		while(!queue.isEmpty()) {
			DiskObject disk = queue.dequeue();
			if(disk instanceof FileObject) {
				FileObject file = (FileObject) d;
				file.setData(file.getData().substring(0, (file.getData().length() > 25) ?
						file.getData().length() - (file.getData().length() - 25) : 
							file.getData().length()));
				file.setName("Fixed - " + file.getName());
			}
		}
		if(d instanceof DirectoryObject) {
			DirectoryObject directory = (DirectoryObject) d;
			for(int i = 0; i < directory.getChildren().size(); i++) 
				queue.enqueue((DiskObject) directory.getChildren().get(i));
			directory.setName("Fixed - " + directory.getName());
		}
	}
	public static void updateFilesRecursive(DiskObject d) {
		if(d instanceof FileObject) {
			FileObject file = (FileObject) d;
			file.setData(file.getData().substring(0, (file.getData().length() > 25) ?
					file.getData().length() - (file.getData().length() - 25) : 
						file.getData().length()));
			file.setName("Fixed - " + file.getName());
		}
		if(d instanceof DirectoryObject) {
			DirectoryObject directory = (DirectoryObject) d;
			for(int i = 0; i < directory.getChildren().size(); i++) 
				updateFilesRecursive((DiskObject) directory.getChildren().get(i));
			directory.setName("Fixed - " + directory.getName());
		}
	}
	
}


