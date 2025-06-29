package pe.edu.upc.mecanichub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pe.edu.upc.mecanichub.IAM.application.UserService;
import pe.edu.upc.mecanichub.IAM.domain.model.aggregates.User;
import pe.edu.upc.mecanichub.IAM.infrastructure.persistence.jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class IAMServiceTest {

    private UserService userService;
    private UserRepository userRepository;

    @BeforeEach
    public void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        userService = new UserService(userRepository);
    }

    @Test
    public void testGetAllUsers() {
        when(userRepository.findAll()).thenReturn(List.of(new User()));
        assertEquals(1, userService.getAllUsers().size());
    }

    @Test
    public void testGetUserById() {
        User user = new User();
        when(userRepository.findById("123")).thenReturn(Optional.of(user));
        assertTrue(userService.getUserById("123").isPresent());
    }

    @Test
    public void testRegisterUser_Success() {
        User user = new User();
        user.setEmail("test@example.com");

        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.registerUser(user);

        assertNotNull(savedUser);
        verify(userRepository).save(user);
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.existsById("123")).thenReturn(true);
        userService.deleteUser("123");
        verify(userRepository).deleteById("123");
    }
}
