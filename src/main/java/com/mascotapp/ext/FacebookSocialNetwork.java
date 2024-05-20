package com.mascotapp.ext;
import java.util.HashSet;
import java.util.Set;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class FacebookSocialNetwork implements SocialNetwork {
	
	private Set<Post> foundPets;
	private Set<Post> lostPets;
	
	public FacebookSocialNetwork() {
        Set<Post> founds = new HashSet<>();
        Set<Post> losts = new HashSet<>();

        losts.add(new Post("Se perdio mi perro tito en la estacion de polvorines", "www.facebook.com/posts/1"));
        losts.add(new Post("Si alguien vio a mi gata Lila me avisa por favor? Gracias", "www.facebook.com/posts/2"));

        founds.add(new Post("encontre un perro que tiene en la chapita el nombre tito por Villa de Mayo", "www.facebook.com/posts/3"));

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

	@Override
	public String getName() {
		return "Facebook Social Network";
	}

}