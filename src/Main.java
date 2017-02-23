import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		
		ArrayList<Endpoint> endpoints = new ArrayList<>();
		ArrayList<Video> videos = new ArrayList<>();
		
		sortVideosForEachEndpoint(endpoints, videos);
	}

	
	public static Map<Endpoint, ArrayList<Video>> sortVideosForEachEndpoint(ArrayList<Endpoint> endpoints, ArrayList<Video> videos) {
	  Map<Endpoint, ArrayList<Video>> endpointsToPopularVideos = new HashMap<>();
	  for (Endpoint endpoint: endpoints) {
	    ArrayList<Video> allVideos = null;
	    
	    
		Collections.copy(allVideos, videos);
    	Collections.sort(allVideos, new Comparator<Video>() {

			@Override
			public int compare(Video v1, Video v2) {
				// TODO Auto-generated method stub
				
				int requestsV1 = v1.requestsForEndpoint.get(endpoint);
				int requestsV2 = v2.requestsForEndpoint.get(endpoint);
				
				return Integer.compare(requestsV1, requestsV2);
			}
    		
    	});

        endpoint.setVideosSortedByRequests(allVideos);
    	endpointsToPopularVideos.put(endpoint, allVideos);
	    
	  }
	  return endpointsToPopularVideos;
	}

    public static Map<Endpoint, ArrayList<Cache>> sortCacheForEachEndpointByLatency(ArrayList<Endpoint> endpoints, ArrayList<Cache> cache) {
        Map<Endpoint, ArrayList<Cache>> endpointsToPopularVideos = new HashMap<>();

        for (Endpoint endpoint: endpoints) {
            ArrayList<Cache> allCache = null;

            Collections.copy(allCache, cache);
            Collections.sort(allCache, new Comparator<Cache>() {

                @Override
                public int compare(Cache c1, Cache c2) {
                    // TODO Auto-generated method stub

                    int latencyV1 = c1.getLatencyForEndpoints().get(endpoint);
                    int latencyV2 = c1.getLatencyForEndpoints().get(endpoint);

                    return Integer.compare(latencyV1, latencyV2);
                }

            });

            endpoint.setCachesSortedByMinimalLatencies(allCache);
            endpointsToPopularVideos.put(endpoint, allCache);

        }


        return endpointsToPopularVideos;
    }

    public static Map<Endpoint, ArrayList<Cache>> sortCacheForEachEndpointByImprovedLatency(
            ArrayList<Endpoint> endpoints,
            ArrayList<Cache> cache,
            Map<Endpoint, Integer> dataCenterLatencyForEndpoint
    ) {
        Map<Endpoint, ArrayList<Cache>> endpointsToPopularVideos = new HashMap<>();

        for (Endpoint endpoint: endpoints) {
            ArrayList<Cache> allCache = null;

            int dataCenterLatency = endpoint.getDataCenterLatency();

            Collections.copy(allCache, cache);
            Collections.sort(allCache, new Comparator<Cache>() {

                @Override
                public int compare(Cache c1, Cache c2) {
                    // TODO Auto-generated method stub

                    int latencyV1 = dataCenterLatency - c1.getLatencyForEndpoints().get(endpoint);
                    int latencyV2 = dataCenterLatency - c1.getLatencyForEndpoints().get(endpoint);

                    return Integer.compare(latencyV1, latencyV2);
                }

            });

            endpoint.setCachesSortedByMinimalLatencies(allCache);
            endpointsToPopularVideos.put(endpoint, allCache);

        }


        return endpointsToPopularVideos;
    }
}
