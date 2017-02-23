import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.Endpoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		for(i=0;i<10;i++)
		{
			Endpoint a[i]=new Endpoint(i,null);
		}
		// TODO Auto-generated method stub
		System.out.println("Hello world!");
		Map requestsend = new HashMap();
		Map requestsendb= new HashMap();
		Map requestsendc= new HashMap();
        requestend.put(a[2],924);
        requestend.put(a[9],837);
        requestend.put(a[8],167);
		Video vid=new Video(0,20,requestend);
        requestendb.put(a[6],988);
        requestendb.put(a[8],300);
        requestendb.put(a[7],552);
        Video vidb=new Video(1,11,requestendb);
        requestendc.put(a[2],924);
        requestendc.put(a[9],837);
        requestendc.put(a[8],167);
        Video vidc=new Video(2,50,requestend);

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
    	
    	endpointsToPopularVideos.put(endpoint, allVideos);
	    
	  }
	  return endpointsToPopularVideos;
	}

}
