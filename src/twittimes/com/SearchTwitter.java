package twittimes.com;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class SearchTwitter {

    public void getSearchTwitter(String[] args) {
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("4vMadT2ADh3I3nhHXyUFHiPzO")
    	  .setOAuthConsumerSecret("QKXRk0gbFSRBFCzeUP0udEon6CSVlwQAhcVskf5D1voUL99WEz")
    	  .setOAuthAccessToken("238483217-PDd9wadGNtAeT2snJUkNN25Q2cPL9w85n4bN4NyV")
    	  .setOAuthAccessTokenSecret("BDhY9pF0tn9hRlgAg8miVOVmV3fEzYwxeJ0uoJAvkax6v");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	
        try {
        	String queryString= "'#EnBüyükTeröristNetanyahu favorite_count>2";
            Query query = new Query(queryString);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + 
                    					tweet.getText() + " fav count "+ tweet.getFavoriteCount() + 
                    					" retweet count " + tweet.getRetweetCount() +
                    					" tweet id -" + tweet.getId() + " tweet location - "+ tweet.getGeoLocation()
                    					+ " lang -" + tweet.getLang() );
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
    }
}
