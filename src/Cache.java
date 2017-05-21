import java.util.ArrayList;
import java.util.Map;

public class Cache {
	private int id;
	private int size;
	private Map<Endpoint, Integer> latencyForEndpoints;
    private ArrayList<Video> chosenVideos;

	public Cache(int id, int size, Map<Endpoint, Integer> latencyForEndpoints) {
		super();
		this.id = id;
		this.size = size;
		this.latencyForEndpoints = latencyForEndpoints;
	}

	public Cache(int id, int size) {
		super();
		this.id = id;
		this.size = size;
	}


	public Map<Endpoint, Integer> getLatencyForEndpoints() {
		return latencyForEndpoints;
	}

	public void setLatencyForEndpoints(Map<Endpoint, Integer> latencyForEndpoints) {
		this.latencyForEndpoints = latencyForEndpoints;
	}

    public ArrayList<Video> getChosenVideos() {
        return chosenVideos;
    }

    public void setChosenVideos(ArrayList<Video> chosenVideos) {
        this.chosenVideos = chosenVideos;
    }

    public int getSize() {
        return size;
    }
}
