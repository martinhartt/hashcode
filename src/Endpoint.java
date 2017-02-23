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
    private ArrayList<Cache> cachesSortedByMinimalLatencies; // computated
    private ArrayList<Cache> cachesSortedByImprovedInLatencies; // computated
    private int dataCenterLatency;

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

    public ArrayList<Cache> getCachesSortedByImprovedInLatencies() {
        return cachesSortedByImprovedInLatencies;
    }

    public void setCachesSortedByImprovedInLatencies(ArrayList<Cache> cachesSortedByImprovedInLatencies) {
        this.cachesSortedByImprovedInLatencies = cachesSortedByImprovedInLatencies;
    }

    public ArrayList<Cache> getCachesSortedByMinimalLatencies() {
        return cachesSortedByMinimalLatencies;
    }

    public void setCachesSortedByMinimalLatencies(ArrayList<Cache> cachesSortedByMinimalLatencies) {
        this.cachesSortedByMinimalLatencies = cachesSortedByMinimalLatencies;
    }

    public int getDataCenterLatency() {
        return dataCenterLatency;
    }

    public void setDataCenterLatency(int dataCenterLatency) {
        this.dataCenterLatency = dataCenterLatency;
    }
}
