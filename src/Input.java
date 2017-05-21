import com.sun.xml.internal.ws.util.StringUtils;
import sun.misc.IOUtils;
import sun.misc.Regexp;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Input {

    static String everything;
    static int totVideos;
    static int totEndpoins;
    static int totCaches;
    static int totRequests;
    static int sizeOfCache;

    public ArrayList<Video> Xvideos = new ArrayList<>();
    public ArrayList<Cache> Xcaches = new ArrayList<>();
    public ArrayList<Endpoint> Xendpoints = new ArrayList<>();


    static int endpointCounter;

    public Input() {

    }

    public static void main(String args[]) {



    }

    public void doStuff() {

        try(BufferedReader br = new BufferedReader(new FileReader("me_at_the_zoo.in"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        //System.out.println(everything);

        String[] allLines = everything.split("\\n");

        String[] initialLine = allLines[0].split("\\s+");
        totVideos = Integer.parseInt(initialLine[0]);
        totEndpoins = Integer.parseInt(initialLine[1]);
        totRequests = Integer.parseInt(initialLine[2]);
        totCaches = Integer.parseInt(initialLine[3]);
        sizeOfCache = Integer.parseInt(initialLine[4]);

        String[] allVideos = allLines[1].split("\\s+");
        int[] allVideoSizes = new int[allVideos.length];
        for (int i = 0; i < allVideos.length; i++) {
            allVideoSizes[i] = Integer.parseInt(allVideos[i]);
        }

        for (int p = 0; p < totCaches; p++) {
            Xcaches.add(new Cache(p, sizeOfCache, new HashMap<Endpoint, Integer>()));
        }

        for (int e = 0; e < totEndpoins; e++) {
            Xendpoints.add(new Endpoint(e, new HashMap<>()));
        }

        for (int v = 0; v < totVideos; v++) {
            Xvideos.add(new Video(v, allVideoSizes[v], null));
        }
        int counter = 2;

        for (int j = 0; j < totEndpoins ; j++) {

            String[] endpoints = allLines[counter].split("\\s+");
            Endpoint e = Xendpoints.get(j);

            e.setDataCenterLatency(Integer.parseInt(endpoints[0]));
            int noOfCaches = Integer.parseInt(endpoints[1]); // fixed position

            for (int i = 0; i < noOfCaches; i++) {

                String[] cacheLatency = allLines[i + 3].split("\\s+");

                int id = Integer.parseInt(cacheLatency[0]);
                int lat = Integer.parseInt(cacheLatency[1]);

                if (id >= Xcaches.size()) {
                    break;
                }
                counter++;

                Xcaches.get(id).getLatencyForEndpoints().put(e, lat);

            }

        }


        int newCounter = 0;



        for (int k = 0; k < totRequests; k++) {
            String[] requestInfo = allLines[counter].split("\\s+");

            counter++;

            if (requestInfo == null || requestInfo.length < 3) {
                continue;
            }
            System.out.println("HELLO");

            int video = Integer.parseInt(requestInfo[0]);
            int endpoint = Integer.parseInt(requestInfo[1]);
            int requests = Integer.parseInt(requestInfo[2]);

            Video v = Xvideos.get(video);
            Xendpoints.get(endpoint).getRequestsForVideo().put(v, requests);
        }



    }
}
