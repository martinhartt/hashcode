import com.sun.xml.internal.ws.util.StringUtils;
import sun.misc.IOUtils;

import java.io.*;

public class Input {

    static String everything;
    static int totVideos;
    static int totEndpoins;
    static int totCaches;
    static int totRequests;
    static int sizeOfCache;

    static int endpointCounter;

    public Input() {

    }

    public static void main(String args[]) {

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
        endpointCounter = 0;

        int counter = 3;
        for (int j = 0; j < totEndpoins ; j++) {

            String[] endpoints = allLines[2].split("\\s+");
            Endpoint e = new Endpoint(endpointCounter);
            endpointCounter++;

            e.setDataCenterLatency(Integer.parseInt(endpoints[0]));
            int noOfCaches = Integer.parseInt(endpoints[1]); // fixed position

            for (int i = 0; i < noOfCaches; i++) {

                String[] cacheLatency = allLines[i + 3].split("\\s+");
                Cache c = new Cache(Integer.parseInt(cacheLatency[0]), sizeOfCache);
            }

        }



    }
}
