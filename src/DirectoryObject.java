
import java.util.ArrayList;
import java.util.Date;

public class DirectoryObject extends DiskObject {
	
	ArrayList<DiskObject> children = new ArrayList<DiskObject>();
	public DirectoryObject(String name) {
		this.name = name;
		this.creator = System.getProperty("user.name");
		this.created = new Date();
		this.diskLocation = 1;
	}
	public void addDirectory(DirectoryObject d) {
		children.add(d);
		this.lastAccessed = new Date();
		this.lastModified = new Date();
	}
	public void addFile(FileObject f) {
		children.add(f);
		this.lastAccessed = new Date();
		this.lastModified = new Date();
	}
	public ArrayList getChildren() {
		return children;
	}
	@Override
	public String toString() {
		return "Directory Name: " + name;
	}
	@Override
	int size() {
		int size = 0;
		for(int x = 0; x < children.size(); x++) {
			size += children.get(x).size();
		}
		return size;
	}

}
