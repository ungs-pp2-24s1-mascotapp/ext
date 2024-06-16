package com.mascotapp.ext;

import java.util.HashSet;
import java.util.Set;
import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class Facebook extends SocialNetwork {
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	public Facebook() {
        Set<Post> founds = new HashSet<>();
        Set<Post> losts = new HashSet<>();

		losts.add(new Post("perdí a mi caniche", "https://www.facebook.com/posts/164026166"));
		losts.add(new Post("perdi mi perro labrador", "https://www.facebook.com/posts/1654397464"));
		losts.add(new Post("Ayer a las 22hs se escapó mi perro Rocky", "https://www.facebook.com/posts/172024136"));
		losts.add(new Post("estoy buscando a mi caniche blanco perdido", "https://www.facebook.com/posts/16272773"));
		
        founds.add(new Post("se encontró un perro labrador", "https://www.facebook.com/posts/161893467"));
        founds.add(new Post("encontre un perro mestizo", "https://www.facebook.com/posts/165097290"));
        founds.add(new Post("encontre un perro caniche color blanco", "https://www.facebook.com/posts/13280141"));
        founds.add(new Post("encontré un perro con chapita de nombre Rocky", "https://www.facebook.com/posts/150314080"));
        founds.add(new Post("vi un perro de raza labrador en Perón y Paunero", "https://www.facebook.com/posts/142402269"));
        
		this.foundPets = founds;
		this.lostPets = losts;
	}

	@Override
	public String getName() {
		return "Facebook";
	}

	@Override
	public Set<Post> getPosts() {
		Set<Post> posts = new HashSet<>();
		posts.addAll(foundPets);
		posts.addAll(lostPets);
		return posts;
	}
}