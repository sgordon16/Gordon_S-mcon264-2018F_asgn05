import java.util.Date;

public class FileObject extends DiskObject {

	String data;
	public FileObject(String name, String data) {
		this.name = name;
		this.data = data;
		this.creator = System.getProperty("user.name");
		this.created = new Date();
		this.diskLocation = 2;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "File Name: " + name + "\n" + data + "\nSize: " + data.length();
	}
	
	@Override
	int size() {
		// TODO Auto-generated method stub
		return data.length();
	}
	
}
