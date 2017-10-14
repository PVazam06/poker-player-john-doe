package org.leanpoker.player.request;

import java.util.List;

public class RankHelper {

	public static int getReturnValue(int rank, GameRequest req)
	{
		System.out.println("Rank Helper entered");
		System.out.println("rank: " + rank);
		if (rank > 0)
		{
			System.out.println("entered rank  > 0");
			if (rank > 2)
			{
				System.out.println("entered rank > 2");
				List<PlayerJson> players = req.getPlayers();
				return players.get(req.getIn_action()).getStack();
			}
			else
			{
				System.out.println("entered rank = 1");
				return req.getCurrentBuyIn() - req.getPlayers().get(req.getIn_action()).getBet() + req.getMinimum_raise() + 1;
			}
		}
		else if (req.getCurrentBuyIn() <= 10 * req.getSmallBlind())
		{
			System.out.println("entered currentbuyin < 10 * smallblind");
			return req.getCurrentBuyIn() - req.getPlayers().get(req.getIn_action()).getBet();
		}
		
		return 0;
	}

}
