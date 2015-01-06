package twittimes.com;


import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class SearchUsers {
	
/*
 * Provides a simple, relevance-based search interface to public user accounts on Twitter.
 *  Try querying by topical interest, full name, company name, location, or other criteria.
 *   Exact match searches are not supported.
 *   Only the first 1,000 matching results are available.
 */
	
	public void searchUsers(String[] args){
		ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("4vMadT2ADh3I3nhHXyUFHiPzO")
    	  .setOAuthConsumerSecret("QKXRk0gbFSRBFCzeUP0udEon6CSVlwQAhcVskf5D1voUL99WEz")
    	  .setOAuthAccessToken("238483217-PDd9wadGNtAeT2snJUkNN25Q2cPL9w85n4bN4NyV")
    	  .setOAuthAccessTokenSecret("BDhY9pF0tn9hRlgAg8miVOVmV3fEzYwxeJ0uoJAvkax6v");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
    	if (args.length < 1) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
    	
    	try {
            int page = 1;
            ResponseList<User> users;
            do {
                users = twitter.searchUsers(args[0], page);
                for (User user : users) {
                    if (user.getStatus() != null) {
                        System.out.println("@" + user.getScreenName() + " - " + user.getStatus().getText());
                    } else {
                        // the user is protected
                        System.out.println("@" + user.getScreenName());
                    }
                }
                page++;
            } while (users.size() != 0 && page < 50);
            System.out.println("done.");
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search users: " + te.getMessage());
            System.exit(-1);
        }
    	
    	
	}

}
