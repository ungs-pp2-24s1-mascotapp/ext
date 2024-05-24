package com.mascotapp.ext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class InstagramWithDynamicData implements SocialNetwork {
	
	private int fetchFoundCount = 0;
	private int fetchLostCount = 0;
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	private List<Post> allFoundPets;
	private List<Post> allLostPets;
	
	public InstagramWithDynamicData() {
		foundPets = new HashSet<>();
		lostPets = new HashSet<>();
        
		allFoundPets = new ArrayList<>();
		allLostPets = new ArrayList<>();
		
		allLostPets.add(new Post("perdi mi gato siames", "https://www.instagram.com/posts/165227464"));
		allLostPets.add(new Post("se perdió mi gatito negro", "https://www.instagram.com/posts/1355259383"));
		allLostPets.add(new Post("se escapo mi gatito siames luna", "https://www.instagram.com/posts/165227464"));
		
		allFoundPets.add(new Post("vi un gato siames en la peatonal", "https://www.instagram.com/posts/1912667009"));
		allFoundPets.add(new Post("aparecio en mi casa este gatito siames que se llama luna", "https://www.instagram.com/posts/1912667010"));
		allFoundPets.add(new Post("vi un gatito negro en la estación de San Miguel", "https://www.instagram.com/posts/142502269"));
	}

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
		return "Instagram";
	}
}
