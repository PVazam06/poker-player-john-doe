
package org.leanpoker.player.request;

import java.util.List;

import org.leanpoker.player.model.Card;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerJson {

    @SerializedName("name")
    @Expose
    private String name;
    
    @SerializedName("stack")
    @Expose
    private Integer stack;
    
    @SerializedName("status")
    @Expose
    private String status;
    
    @SerializedName("bet")
    @Expose
    private Integer bet;
    
    @SerializedName("hole_cards")
    @Expose
    private List<Card> holeCards = null;
    
    @SerializedName("version")
    @Expose
    private String version;
    
    @SerializedName("id")
    @Expose
    private Integer id;
    
//	private JsonObject playerJson;
//
//    public PlayerJson(JsonElement player) {
//    	playerJson = player.getAsJsonObject();
//		this.name = getStringField("name");
//		this.stack = getIntegerField("stack");
//		this.status = getStringField("status");
//		this.bet = getIntegerField("bet");
//		// this. holeCards
//		this.version = getStringField("version");
//		this.id = getIntegerField("id");
//	}
//
//	private Integer getIntegerField(String field) {
//		return playerJson.get(field).getAsInt();
//	}
//
//	private String getStringField(String field) {
//		return playerJson.get(field).getAsString();
//	}
    
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStack() {
        return stack;
    }

    public void setStack(Integer stack) {
        this.stack = stack;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getBet() {
        return bet;
    }

    public void setBet(Integer bet) {
        this.bet = bet;
    }

    public List<Card> getHoleCards() {
        return holeCards;
    }

    public void setHoleCards(List<Card> holeCards) {
        this.holeCards = holeCards;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
