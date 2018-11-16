
public class Program {
	
	public static void main(String[] args) {
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
		displayInfo(root);
		System.out.println("Total size: " + root.size() + "\n");
		updateFiles(root);
		displayInfo(root);
		System.out.println("Total size: " + root.size() + "\n");
	}

	public static void displayInfo(DiskObject d) {
		if(d instanceof FileObject) 
			System.out.println(d.toString());
		if(d instanceof DirectoryObject) {
			DirectoryObject directory = (DirectoryObject) d;
			System.out.println(directory.toString());
			for(int i = 0; i < directory.getChildren().size(); i++) 
				displayInfo((DiskObject) directory.getChildren().get(i));
		}
	}
	public static void updateFiles(DiskObject d) {
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
				updateFiles((DiskObject) directory.getChildren().get(i));
			directory.setName("Fixed - " + directory.getName());
		}
	}
	
}


