package twittimes.com;

import twitter4j.*;
import twitter4j.Query.ResultType;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;


public class SearchTwitter {

    public void getSearchTwitter(String queryText) {
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("4vMadT2ADh3I3nhHXyUFHiPzO")
    	  .setOAuthConsumerSecret("QKXRk0gbFSRBFCzeUP0udEon6CSVlwQAhcVskf5D1voUL99WEz")
    	  .setOAuthAccessToken("238483217-PDd9wadGNtAeT2snJUkNN25Q2cPL9w85n4bN4NyV")
    	  .setOAuthAccessTokenSecret("BDhY9pF0tn9hRlgAg8miVOVmV3fEzYwxeJ0uoJAvkax6v");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	
        try {
        	//String queryString= "#OramıÇekmeBuramıÇek lang:tr filter:links";
        	String queryString = queryText + " lang:tr";
        	Query query = new Query(queryString);
            query.setResultType(ResultType.popular);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
	                System.out.println("\t@" + tweet.getUser().getScreenName() + " - " + 
	                					tweet.getText() + "\n\tfavCount "+ tweet.getFavoriteCount() + 
	                					"\n\tretweetCount " + tweet.getRetweetCount() );
	                System.out.println("************************************");
                }
            } while ((query = result.nextQuery()) != null);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
        }
    }
}
