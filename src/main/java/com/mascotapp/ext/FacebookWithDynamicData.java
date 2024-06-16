package com.mascotapp.ext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class FacebookWithDynamicData extends SocialNetwork {
	
	private Set<Post> posts;

	private List<Post> allFoundPets;
	private List<Post> allLostPets;
	private List<Post> allPosts;
	
	private int postsIndex = 0;
	
	public FacebookWithDynamicData() {
		posts = new HashSet<>();
        
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
        
        allPosts.addAll(allFoundPets);
        allPosts.addAll(allLostPets);
        
        startNotificationProcess();
	}

	@Override
	public String getName() {
		return "Facebook";
	}

	@Override
	public Set<Post> getPosts() {
		return posts;
	}
	
	private void startNotificationProcess() {
        Timer timer = new Timer(true); // Daemon thread
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyNews(postsIndex);
                postsIndex++;
            }
        }, 0, 5000); // 0 delay, 5000ms period
    }
	
	private void notifyNews(int index) {
		if(index < allPosts.size()) {
			this.notifyNewPost(this.allPosts.get(index));
		}
    }
	
}
