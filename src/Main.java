import java.lang.reflect.Array;
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

        Input i = new Input().doStuff();
        getCacheWithVideos(
                sortVideosForEachEndpoint(i.Xendpoints),
                sortCacheForEachEndpointByImprovedLatency(i.Xendpoints, i.Xcaches,)
        )
	}


    public static Map<Cache, ArrayList<Video>> getCacheWithVideos(
            Map<Endpoint, ArrayList<Video>> popularVideoForEndpoint,
            Map<Endpoint, ArrayList<Cache>> cacheForEachEndpointByImprovedLatency,
            ArrayList<Cache> allCaches,
            ArrayList<Endpoint> allEndpoints
    ) {
        Map<Cache, ArrayList<Video>> videosForCache = new HashMap<>();


        for (Endpoint endpoint: allEndpoints) {
            ArrayList<Cache> bestCaches = cacheForEachEndpointByImprovedLatency.get(endpoint);
            ArrayList<Video> bestVideos = popularVideoForEndpoint.get(endpoint);

            for (Cache cache: bestCaches) {
                int limit = 5;
                for (Video video: bestVideos) {
                    limit++;
                    if (limit <= 0) break;
                    video.setRank(video.getRank() + 1);

                    if (videosForCache.containsKey(cache)) {
                        ArrayList<Video> existing = videosForCache.get(cache);
                        existing.add(video);
                        videosForCache.put(cache, existing);
                    } else {
                        ArrayList ok = new ArrayList<>();
                        ok.add(video);
                        videosForCache.put(cache, ok);
                    }
                }
            }

        }

        for (Cache cache: allCaches) {
            videosForCache.get(cache).sort(new Comparator<Video>() {
                @Override
                public int compare(Video o1, Video o2) {
                    return Integer.compare(o1.getRank(), o2.getRank());
                }
            });
        }

        // sort all videos for all caches
        for (Cache cache: allCaches) {
            ArrayList<Video> fittingVideos = new ArrayList<>();
            int size = cache.getSize();
            for (Video v: videosForCache.get(cache)) {
                if (size <= 0) break;

                fittingVideos.add(v);
            }
        }

        return videosForCache;

        // Limit: sum of videos in cache < cache size
        //
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
