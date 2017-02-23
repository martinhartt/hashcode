import java.util.Map;

public class Endpoint {

	
//	check commit
	public Endpoint(int id, Map<Video, Integer> requestsForVideo) {
		super();
		this.id = id;
		this.requestsForVideo = requestsForVideo;
	}

	private int id;
	public Map<Video, Integer> requestsForVideo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Map<Video, Integer> getRequestsForVideo() {
		return requestsForVideo;
	}

	public void setRequestsForVideo(Map<Video, Integer> requestsForVideo) {
		this.requestsForVideo = requestsForVideo;
	}
	
	
}
