package twittimes.com;

import java.sql.SQLException;

import twitter4j.Trend;



public class TwitTimesMain {

	public static void main(String[] args) throws SQLException {

		
		//GetFriendIds friends = new GetFriendIds();
		//friends.getFriendsIds(args);
		
		//SaveRawJSON rawdata = new SaveRawJSON();
		//rawdata.saveRawJson(args);
		
		AvailableTrends trends = new AvailableTrends();
		Trend[] trTrends = trends.getTrends();

		SearchTwitter search = new SearchTwitter();
		for(Trend trend:trTrends){
			System.out.println("---------Trend Topic----------");
			System.out.println(trend.getName());
			search.getSearchTwitter(trend.getName());
		}

		//		SearchUsers userlist = new SearchUsers();
		//		userlist.searchUsers(args);

	}

}
