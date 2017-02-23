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
		Map requestsend = new HashMap();
		Map requestsendb= new HashMap();
		Map requestsendc= new HashMap();
        requestend.put(a[0],500);
        requestend.put(a[1],800);
        requestend.put(a[2],1000);
		Video vid=new Video(1,20,requestend);
        requestendb.put(a[0],600);
        requestendb.put(a[1],300);
        requestendb.put(a[2],500);
        Video vidb=new Video(2,11,requestendb);
        requestendc.put(a[0],200);
        requestendc.put(a[1],100);
        requestendc.put(a[2],500);
        Video vidc=new Video(3,50,requestendc);
        
		
		Map endvidrequest=new HashMap();
		endvidrequest.put(1,500);
		endvidrequest.put(2, 600);
		endvidrequest.put(3, 200);
		Map endvidrequestb=new HashMap();
		endvidrequestb.put(1,800);
		endvidrequestb.put(2, 300);
		endvidrequestb.put(3, 100);
		Map endvidrequestc=new HashMap();
		endvidrequestc.put(1,1000);
		endvidrequestc.put(2,10000);
		endvidrequestc.put(3,500);
		Map endvidrequestc=new HashMap();
		
		for(i=0;i<3;i++)
		{	if(i==0){
			Endpoint a[i]=new Endpoint(i,envidrequestend);
		}
		else if(i==1){
			Endpoint a[i]=new Endpoint(i,envidrequestendb);
		}
		else if(i==2){
			Endpoint a[i]=new Endpoint(i,envidrequestendc);
		}
			
		}
		// TODO Auto-generated method stub
		
        
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
