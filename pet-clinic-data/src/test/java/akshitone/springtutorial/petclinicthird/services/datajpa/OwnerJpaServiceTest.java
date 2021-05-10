package akshitone.springtutorial.petclinicthird.services.datajpa;

import akshitone.springtutorial.petclinicthird.model.Owner;
import akshitone.springtutorial.petclinicthird.repositories.OwnerRepository;
import akshitone.springtutorial.petclinicthird.repositories.PetRepository;
import akshitone.springtutorial.petclinicthird.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Johnson";

    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    Owner savedOwner;

    @BeforeEach
    void setUp() {
        Owner savedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(savedOwner);
        Owner owner = ownerJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME,owner.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}