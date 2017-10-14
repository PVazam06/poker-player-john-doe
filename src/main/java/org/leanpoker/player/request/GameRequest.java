
package org.leanpoker.player.request;

import java.util.ArrayList;
import java.util.List;

import org.leanpoker.player.PlayerServlet;
import org.leanpoker.player.model.Card;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameRequest {

    @SerializedName("players")
    @Expose
    private List<PlayerJson> players = null;
    
    @SerializedName("tournament_id")
    @Expose
    private String tournamentId;
    
    @SerializedName("game_id")
    @Expose
    private String gameId;
    
    private int in_action;
    
    private int minimum_raise;
    
    @SerializedName("round")
    @Expose
    private Integer round;
    
    @SerializedName("bet_index")
    @Expose
    private Integer betIndex;
    
    @SerializedName("small_blind")
    @Expose
    private Integer smallBlind;
    
    @SerializedName("orbits")
    @Expose
    private Integer orbits;
    
    @SerializedName("dealer")
    @Expose
    private Integer dealer;
    
    @SerializedName("community_cards")
    @Expose
    private List<Card> communityCards = null;
    
    @SerializedName("current_buy_in")
    @Expose
    private Integer currentBuyIn;
    
    @SerializedName("pot")
    @Expose
    private Integer pot;
    
//	private final JsonObject requestJson;

//    public GameRequest(JsonElement request) {
//    	requestJson = request.getAsJsonObject();
//		this.players = getPlayerArray("players");
//		this.tournamentId = getStringField("tournament_id");
//		this.gameId = getStringField("game_id");
//		this.round = getIntegerField("round");
//		this.betIndex = getIntegerField("bet_index");
//		this.smallBlind = getIntegerField("small_blind");
//		this.orbits = getIntegerField("orbits");
//		this.dealer = getIntegerField("dealer");
//		
//		this.currentBuyIn = getIntegerField("current_buy_in");
//		this.pot = getIntegerField("pot");
//	}
//    
//    private List<PlayerJson> getPlayerArray(String field) {
//    	List<PlayerJson> playerList = new ArrayList<PlayerJson>();
//		JsonArray playersArray = requestJson.get("players").getAsJsonArray();
//		for (JsonElement player : playersArray) {
//			PlayerJson p = new PlayerJson(player);
//			playerList.add(p);
//		}	
//		return playerList;
//	}
//
//	private Integer getIntegerField(String field) {
//		return requestJson.get(field).getAsInt();
//	}
//
//	private String getStringField(String field) {
//		return requestJson.get(field).getAsString();
//	}

	public List<PlayerJson> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerJson> players) {
        this.players = players;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Integer getBetIndex() {
        return betIndex;
    }

    public void setBetIndex(Integer betIndex) {
        this.betIndex = betIndex;
    }

    public Integer getSmallBlind() {
        return smallBlind;
    }

    public void setSmallBlind(Integer smallBlind) {
        this.smallBlind = smallBlind;
    }

    public Integer getOrbits() {
        return orbits;
    }

    public void setOrbits(Integer orbits) {
        this.orbits = orbits;
    }

    public Integer getDealer() {
        return dealer;
    }

    public void setDealer(Integer dealer) {
        this.dealer = dealer;
    }

    public List<Card> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Card> communityCards) {
        this.communityCards = communityCards;
    }

    public Integer getCurrentBuyIn() {
        return currentBuyIn;
    }

    public void setCurrentBuyIn(Integer currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
    }

    public Integer getPot() {
        return pot;
    }

    public void setPot(Integer pot) {
        this.pot = pot;
    }

	public int getIn_action() {
		return in_action;
	}

	public void setIn_action(int in_action) {
		this.in_action = in_action;
	}

	public int getMinimum_raise() {
		return minimum_raise;
	}

	public void setMinimum_raise(int minimum_raise) {
		this.minimum_raise = minimum_raise;
	}

}
