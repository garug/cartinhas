package br.com.cartinhas.service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.com.cartinhas.entity.Card;
import br.com.cartinhas.entity.CardDeserializer;

@Service
public class APIService {
	private static String BASE_URL = "https://api.magicthegathering.io/v1";
	
	public List<Card> getFromSet(String set) {
		RestTemplate rt = new RestTemplate();
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL)
				.path("/cards/")
				.queryParam("set", set);
		ResponseEntity<String> response;
		Type type = new TypeToken<ArrayList<Card>>(){}.getType();
		Gson gson = new GsonBuilder().registerTypeAdapter(type, new CardDeserializer()).create();
		List<Card> cards = new ArrayList<Card>();
		
		int page = 1;
		do {
			response = rt.exchange(
					uriBuilder
						.queryParam("page", page++)
						.toUriString(),
					HttpMethod.GET,
					this.getEntity(),
					String.class);
//			System.out.println(response.getBody());
			cards.addAll(gson.fromJson(response.getBody(), type));
		} while (response.getHeaders().get("Link").toString().contains("next"));
		return cards;
	}
	
	private HttpEntity<String> getEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		return new HttpEntity<String>("parameters", headers);
	}
}
