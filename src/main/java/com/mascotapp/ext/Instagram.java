package com.mascotapp.ext;

import java.util.HashSet;
import java.util.Set;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class Instagram extends SocialNetwork {
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	public Instagram() {
        Set<Post> founds = new HashSet<>();
        Set<Post> losts = new HashSet<>();

		losts.add(new Post("perdi mi gato siames", "https://www.instagram.com/posts/165227464"));
		losts.add(new Post("se perdió mi gatito negro", "https://www.instagram.com/posts/1355259383"));
		
		founds.add(new Post("vi un gato siames en la peatonal", "https://www.instagram.com/posts/1912667009"));
        founds.add(new Post("vi un gatito negro en la estación de San Miguel", "https://www.instagram.com/posts/142502269"));
        
		this.foundPets = founds;
		this.lostPets = losts;
	}

	@Override
	public String getName() {
		return "Instagram";
	}

	@Override
	public Set<Post> getPosts() {
		Set<Post> posts = new HashSet<>();
		posts.addAll(foundPets);
		posts.addAll(lostPets);
		return posts;
	}
}