
package twittimes.com;

import java.util.ArrayList;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


public class AvailableTrends {
public Trend[] getTrends() {
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("4vMadT2ADh3I3nhHXyUFHiPzO")
    	  .setOAuthConsumerSecret("QKXRk0gbFSRBFCzeUP0udEon6CSVlwQAhcVskf5D1voUL99WEz")
    	  .setOAuthAccessToken("238483217-PDd9wadGNtAeT2snJUkNN25Q2cPL9w85n4bN4NyV")
    	  .setOAuthAccessTokenSecret("BDhY9pF0tn9hRlgAg8miVOVmV3fEzYwxeJ0uoJAvkax6v");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
        try {
        	     	
        	ResponseList<Location> locations;
        	locations = twitter.getAvailableTrends();
        	
        	//tr = 23424969
        	Trend[] trends = twitter.getPlaceTrends(23424969).getTrends();	
        	/*System.out.println("Showing available trends");
            for (Location location : locations) {
                //System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
                if(location.getWoeid() == 23424969 ){
	                for(Trend trend:trends){
	                	System.out.println("trend topic -" + trend.getName() + " trend URL -" + trend.getURL() +"\n");
	                }
                }
            }
            System.out.println("done.");
            */
            return trends;
            
        } catch (TwitterException te) {
        	te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            return null;
        }
    }
}



