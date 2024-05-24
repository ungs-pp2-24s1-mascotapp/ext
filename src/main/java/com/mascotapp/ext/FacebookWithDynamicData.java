package com.mascotapp.ext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class FacebookWithDynamicData implements SocialNetwork {
	
	private int fetchFoundCount = 0;
	private int fetchLostCount = 0;
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	private List<Post> allFoundPets;
	private List<Post> allLostPets;
	
	public FacebookWithDynamicData() {
		foundPets = new HashSet<>();
		lostPets = new HashSet<>();
        
		allFoundPets = new ArrayList<>();
		allLostPets = new ArrayList<>();
		
		allFoundPets.add(new Post("labrador negro", "https://www.facebook.com/posts/161893469"));
        allFoundPets.add(new Post("encontre un perro caniche color blanco", "https://www.facebook.com/posts/13280141"));
        allFoundPets.add(new Post("se encontró un perro labrador", "https://www.facebook.com/posts/161893467"));
        allFoundPets.add(new Post("encontre un perro golden retriever ayer", "https://www.facebook.com/posts/165097290"));
        allFoundPets.add(new Post("vi un perro de raza aleman en Perón y Paunero", "https://www.facebook.com/posts/142402269"));

        allLostPets.add(new Post("perdí a mi caniche", "https://www.facebook.com/posts/164026166"));
        allLostPets.add(new Post("no soy caniche pero toy", "https://www.facebook.com/posts/164026167"));
        allLostPets.add(new Post("perdi mi perro labrador", "https://www.facebook.com/posts/1654397464"));
        allLostPets.add(new Post("Ayer a las 22hs se escapó mi perro Rocky", "https://www.facebook.com/posts/172024136"));
        allLostPets.add(new Post("estoy buscando a mi golden retriever", "https://www.facebook.com/posts/16272773"));
	}
	
	@Override
	public Set<Post> getFoundPets() {
		Set<Post> data = new HashSet<>(foundPets);
		
		if(fetchFoundCount >= allFoundPets.size()) {
			foundPets.clear();
			fetchFoundCount = 0;
		} else {
			foundPets.add(allFoundPets.get(fetchFoundCount));
			fetchFoundCount++;
		}
		
		return data;
	}

	@Override
	public Set<Post> getLostPets() {
		Set<Post> data = new HashSet<>(lostPets);
		
		if(fetchLostCount >= allLostPets.size()) {
			lostPets.clear();
			fetchLostCount = 0;
		} else {
			lostPets.add(allLostPets.get(fetchLostCount));
			fetchLostCount++;
		}
		
		return data;
	}

	@Override
	public String getName() {
		return "Facebook";
	}
}
