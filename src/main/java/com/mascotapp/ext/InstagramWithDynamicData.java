package com.mascotapp.ext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class InstagramWithDynamicData extends SocialNetwork {
	
	private Set<Post> posts;

	private List<Post> allFoundPets;
	private List<Post> allLostPets;
	private List<Post> allPosts;
	
	private int postsIndex = 0;
	
	public InstagramWithDynamicData() {
		posts = new HashSet<>();
        
		allFoundPets = new ArrayList<>();
		allLostPets = new ArrayList<>();
		
		allLostPets.add(new Post("perdi mi gato siames", "https://www.instagram.com/posts/165227464"));
		allLostPets.add(new Post("se perdió mi gatito negro", "https://www.instagram.com/posts/1355259383"));
		allLostPets.add(new Post("se escapo mi gatito siames luna", "https://www.instagram.com/posts/165227464"));
		
		allFoundPets.add(new Post("vi un gato siames en la peatonal", "https://www.instagram.com/posts/1912667009"));
		allFoundPets.add(new Post("aparecio en mi casa este gatito siames que se llama luna", "https://www.instagram.com/posts/1912667010"));
		allFoundPets.add(new Post("vi un gatito negro en la estación de San Miguel", "https://www.instagram.com/posts/142502269"));
		
		allPosts.addAll(allFoundPets);
        allPosts.addAll(allLostPets);
        
        startNotificationProcess();
	}

	@Override
	public String getName() {
		return "Instagram";
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
        }, 0, 10000); // 0 delay, 10000ms period
    }
	
	private void notifyNews(int index) {
		if(index < allPosts.size()) {
			this.notifyNewPost(this.allPosts.get(index));
		}
    }
}
