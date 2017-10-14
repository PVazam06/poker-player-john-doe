package org.leanpoker.player.request;

import java.util.List;

public class RankHelper {

	public static int getReturnValue(int rank, GameRequest req)
	{
		if (rank > 0)
		{
			if (rank > 2)
			{
				List<PlayerJson> players = req.getPlayers();
				return players.get(req.getIn_action()).getStack();
			}
			else
			{
				return req.getMinimum_raise();
			}
		}
		else if (req.getCurrentBuyIn() <= 10 * req.getSmallBlind())
		{
			return req.getCurrentBuyIn();
		}
		
		return 0;
	}

}
