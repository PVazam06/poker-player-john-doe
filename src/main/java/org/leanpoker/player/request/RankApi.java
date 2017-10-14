package org.leanpoker.player.request;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import org.leanpoker.player.model.Card;
import org.leanpoker.player.tools.JHttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

public class RankApi {
	private Gson jsonHelper = new Gson();

	private JHttpClient client = new JHttpClient();

	public int GetRank(Collection<Card> cards) throws IOException {
		
		String json = jsonHelper.toJson(cards);
		json = "cards=" + json;
		InputStream res;
		try {
			res = client.Post("http://rainman.leanpoker.org/rank", json);
		} catch (IOException e) {
			System.out.println("rank api faid");
			e.printStackTrace();
			throw e;
		}

		JsonElement rankObject = jsonHelper.toJsonTree(res);

		int rank = rankObject.getAsJsonObject().get("rank").getAsInt();
		return rank;
	}

}