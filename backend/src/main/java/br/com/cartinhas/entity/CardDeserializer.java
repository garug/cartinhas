package br.com.cartinhas.entity;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import br.com.cartinhas.enuns.ERarity;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;

import br.com.cartinhas.enuns.EColor;

public class CardDeserializer implements  Serializable, JsonDeserializer<List<Card>> {
	
	private static final long serialVersionUID = 1L;

	@Override
	public List<Card> deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
		JsonObject jObject = (JsonObject) json;
		JsonArray jArray = (JsonArray) jObject.get("cards");
		List<Card> cards =  new ArrayList<Card>();
		String anim= "|/-\\";
		for (int i = 0; i<jArray.size(); i++) {
			JsonObject ele = (JsonObject) jArray.get(i);
			Card card = new Card(
					ele.get("id").getAsString(),
					this.getCardNames(ele),
					this.getColors(ele),
					this.getTypes(ele),
					ele.get("manaCost") != null ? ele.get("manaCost").getAsString() : null,
					ele.get("rarity") != null ? ERarity.getByDescription(ele.get("rarity").getAsString()) : null,
					ele.get("set") != null ? ele.get("set").getAsString() : null
				);
			cards.add(card);

			String data = "\r" + "import status set "+ele.get("set")+":"+ anim.charAt(i % anim.length()) + " " + i + "-" +jArray.size();
			try {
				System.out.write(data.getBytes());
				Thread.sleep(100);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("");
		return cards;
	}

	private List<CardName> getCardNames(JsonObject card) {
		List<CardName> list = new ArrayList<CardName>();
		// Add English by default
		list.add(new CardName(
					card.get("name").getAsString(),
					"English",
					card.get("imageUrl") != null ? card.get("imageUrl").getAsString() : null)
				);
		// Add the rest of languages available for that card
		if (card.get("foreignNames") != null) {
			JsonArray jArray = card.get("foreignNames").getAsJsonArray();
			for (int i = 0; i<jArray.size(); i++) {
				JsonObject ele = (JsonObject) jArray.get(i);
				list.add(new CardName(
							ele.get("name").getAsString(),
							ele.get("language").getAsString(),
							ele.get("imageUrl") != null ? ele.get("imageUrl").getAsString() : null)
						);
			}
		}
		return list;
	}

	private List<EColor> getColors(JsonObject card) {
		if(card.get("colors") != null) {
			JsonArray jArray = card.get("colors").getAsJsonArray();
			List<EColor> list = new ArrayList<EColor>();
			for (int i = 0; i<jArray.size(); i++) {
				JsonPrimitive ele = (JsonPrimitive) jArray.get(i);
				list.add(EColor.valueOf(ele.getAsString()));
			}
			return list;
		} else {
			return null;
		}
	}

	private List<String> getTypes(JsonObject card) {
		if (card.get("types") != null) {
			JsonArray jArray = card.get("types").getAsJsonArray();
			List<String> list = new ArrayList<String>();
			for (int i = 0; i<jArray.size(); i++) {
				JsonPrimitive ele = (JsonPrimitive) jArray.get(i);
				list.add(ele.getAsString());
			}
			return list;
		} else {
			return null;
		}
	}

}
