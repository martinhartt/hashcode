import java.util.Map;

public class Cache {
	private int id;
	private int size;
	private Map<Endpoint, Integer> latencyForEndpoints;

	public Cache(int id, int size, Map<Endpoint, Integer> latencyForEndpoints) {
		super();
		this.id = id;
		this.size = size;
		this.latencyForEndpoints = latencyForEndpoints;
	}

	public Map<Endpoint, Integer> getLatencyForEndpoints() {
		return latencyForEndpoints;
	}

	public void setLatencyForEndpoints(Map<Endpoint, Integer> latencyForEndpoints) {
		this.latencyForEndpoints = latencyForEndpoints;
	}
}
