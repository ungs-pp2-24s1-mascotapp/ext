package com.mascotapp.ext;

import java.util.HashSet;
import java.util.Set;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.dataprovider.PetDataProvider;

public class Instagram implements PetDataProvider {
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	public Instagram() {
        Set<Post> founds = new HashSet<>();
        Set<Post> losts = new HashSet<>();

		losts.add(new Post("perdi mi perro labrador", "https://www.instagram.com/posts/165227464"));
		losts.add(new Post("se perdió mi gatito negro", "https://www.instagram.com/posts/1355259383"));
		
		founds.add(new Post("vi un gato siames en la peatonal", "https://www.instagram.com/posts/1912667009"));
        founds.add(new Post("vi un perro pug en la estación de San Miguel", "https://www.instagram.com/posts/142502269"));
        
		this.foundPets = founds;
		this.lostPets = losts;
	}

	@Override
	public Set<Post> getLostPets() {
		return lostPets;
	}

	@Override
	public Set<Post> getFoundPets() {
		return foundPets;
	}
}