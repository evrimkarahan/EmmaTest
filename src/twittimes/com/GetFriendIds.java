package twittimes.com;


import twitter4j.IDs;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


public final class GetFriendIds {
   
    public  void getFriendsIds(String[] args) {
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    	  .setOAuthConsumerKey("4vMadT2ADh3I3nhHXyUFHiPzO")
    	  .setOAuthConsumerSecret("QKXRk0gbFSRBFCzeUP0udEon6CSVlwQAhcVskf5D1voUL99WEz")
    	  .setOAuthAccessToken("238483217-PDd9wadGNtAeT2snJUkNN25Q2cPL9w85n4bN4NyV")
    	  .setOAuthAccessTokenSecret("BDhY9pF0tn9hRlgAg8miVOVmV3fEzYwxeJ0uoJAvkax6v");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	Twitter twitter = tf.getInstance();
    	
        try {
            //Twitter twitter = new TwitterFactory().getInstance();
            long cursor = -1;
            IDs ids;
            System.out.println("Listing following ids.");
            do {
                if (0 < args.length) {
                    ids = twitter.getFriendsIDs(args[0], cursor);
                } else {
                    ids = twitter.getFriendsIDs(cursor);
                }
                for (long id : ids.getIDs()) {
                    System.out.println(id );
                }
            } while ((cursor = ids.getNextCursor()) != 0);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get friends' ids: " + te.getMessage());
            System.exit(-1);
        }
    }
}
