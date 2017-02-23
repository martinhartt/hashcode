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
	  Map<Endpoint, ArrayList<Video>> endpointsToPopularVideos = new HashMap<Endpoint, ArrayList<Video>>();
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

    public static Map<Cache, ArrayList<Endpoint>> sortCacheForEachEndpointByLatency(ArrayList<Endpoint> endpoints, ArrayList<Cache> cache) {
        return new HashMap<>();
    }

    public static Map<Cache, ArrayList<Endpoint>> sortCacheForEachEndpointByImprovedLatency(ArrayList<Endpoint> endpoints, ArrayList<Cache> cache) {
        return new HashMap<>();
    }
}
