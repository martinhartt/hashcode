import java.util.Map;

public class Video {

	private int size;
	private int id;

	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Map<Endpoint, Integer> requestsForEndpoint;
}
