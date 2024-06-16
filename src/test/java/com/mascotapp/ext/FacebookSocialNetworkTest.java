package com.mascotapp.ext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.Test;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class FacebookSocialNetworkTest {

    @Test
    public void testGetPosts() {
    	SocialNetwork socialNetwork = new FacebookSocialNetwork();
        Set<Post> posts = socialNetwork.getPosts();
        assertNotNull(posts);
        assertEquals(3, posts.size()); // Assuming you've added 3 posts in the constructor
    }
}
