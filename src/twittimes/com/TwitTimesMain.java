package twittimes.com;

import java.sql.SQLException;



public class TwitTimesMain {

	public static void main(String[] args) throws SQLException {
		

    	
		//SearchTwitter search = new SearchTwitter();
		//search.getSearchTwitter(args);
		
		//GetFriendIds friends = new GetFriendIds();
		//friends.getFriendsIds(args);
		
		//SaveRawJSON rawdata = new SaveRawJSON();
		//rawdata.saveRawJson(args);
		
		//AvailableTrends trends = new AvailableTrends();
		//trends.getTrends();
		
		SearchUsers userlist = new SearchUsers();
		userlist.searchUsers(args);
		
		

	}

}
