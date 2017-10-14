
package org.leanpoker.player.request;

import java.util.List;

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
    private List<Object> communityCards = null;
    
    @SerializedName("current_buy_in")
    @Expose
    private Integer currentBuyIn;
    
    @SerializedName("pot")
    @Expose
    private Integer pot;
    
	private final JsonObject requestJson;

    public GameRequest(JsonElement request) {
    	requestJson = request.getAsJsonObject();
		
		this.tournamentId = getStringField("tournament_id");
		this.gameId = getStringField("game_id");
		this.round = getIntegerField("round");
		this.betIndex = getIntegerField("bet_index");
		this.smallBlind = getIntegerField("small_blind");
		this.orbits = getIntegerField("orbits");
		this.dealer = getIntegerField("dealer");
		
		this.currentBuyIn = getIntegerField("current_buy_in");
		this.pot = getIntegerField("pot");
	}
    
    private Integer getIntegerField(String field) {
		return requestJson.get(field).getAsInt();
	}

	private String getStringField(String field) {
		return requestJson.get(field).getAsString();
	}

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

    public List<Object> getCommunityCards() {
        return communityCards;
    }

    public void setCommunityCards(List<Object> communityCards) {
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

}
