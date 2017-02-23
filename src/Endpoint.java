import java.util.ArrayList;
import java.util.Map;

public class Endpoint {

	public Endpoint(int id, Map<Video, Integer> requestsForVideo) {
		super();
		this.id = id;
		this.requestsForVideo = requestsForVideo;
	}

	private int id;
	private Map<Video, Integer> requestsForVideo;
	private Map<Cache, Integer> latenciesForCache;
	private ArrayList<Video> videosSortedByRequests;

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


	public Map<Cache, Integer> getLatenciesForCache() {
		return latenciesForCache;
	}

	public void setLatenciesForCache(Map<Cache, Integer> latenciesForCache) {
		this.latenciesForCache = latenciesForCache;
	}

    public ArrayList<Video> getVideosSortedByRequests() {
        return videosSortedByRequests;
    }

    public void setVideosSortedByRequests(ArrayList<Video> videosSortedByRequests) {
        this.videosSortedByRequests = videosSortedByRequests;
    }
}
