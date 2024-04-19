package com.mascotapp.ext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mascotapp.core.entities.Post;
import com.mascotapp.core.service.dataprovider.PetDataProvider;

public class FacebookPetDataProviderTest {

    private PetDataProvider petDataProvider;

    @BeforeEach
    public void setUp() {
        petDataProvider = new FacebookPetDataProvider();
    }

    @Test
    public void testGetLostPets() {
        Set<Post> lostPets = petDataProvider.getLostPets();
        assertNotNull(lostPets);
        assertEquals(2, lostPets.size()); // Assuming you've added 2 lost pets in the constructor
    }

    @Test
    public void testGetFoundPets() {
        Set<Post> foundPets = petDataProvider.getFoundPets();
        assertNotNull(foundPets);
        assertEquals(1, foundPets.size()); // Assuming you've added 1 found pet in the constructor
    }
}
