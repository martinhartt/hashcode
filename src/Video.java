import java.util.Map;

public class Video {

	public Video(int size, int id, Map<Endpoint, Integer> requestsForEndpoint) {
		super();
		this.size = size;
		this.id = id;
		this.requestsForEndpoint = requestsForEndpoint;
	}

	private int size;
	private int id;
	private int rank = 0;

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

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
