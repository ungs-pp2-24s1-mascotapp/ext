package com.mascotapp.ext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.socialNetwork.SocialNetwork;

public class FacebookPetDataProviderTest {

    private SocialNetwork socialNetwork;

    @BeforeEach
    public void setUp() {
    	socialNetwork = new FacebookSocialNetwork();
    }

    @Test
    public void testGetLostPets() {
        Set<Post> lostPets = socialNetwork.getLostPets();
        assertNotNull(lostPets);
        assertEquals(2, lostPets.size()); // Assuming you've added 2 lost pets in the constructor
    }

    @Test
    public void testGetFoundPets() {
        Set<Post> foundPets = socialNetwork.getFoundPets();
        assertNotNull(foundPets);
        assertEquals(1, foundPets.size()); // Assuming you've added 1 found pet in the constructor
    }
}
