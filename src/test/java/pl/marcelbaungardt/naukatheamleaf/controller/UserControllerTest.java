package pl.marcelbaungardt.naukatheamleaf.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pl.marcelbaungardt.naukatheamleaf.error.UserNotFoundExpection;
import pl.marcelbaungardt.naukatheamleaf.model.User;
import pl.marcelbaungardt.naukatheamleaf.service.UserService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

        @Mock
        UserService userService;
        @InjectMocks
        UserController userController;

        MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

        mockMvc=MockMvcBuilders.standaloneSetup(userController).setControllerAdvice(new ControllerExceptionHandler()).build();

    }

    @Test
    public void getUsers() throws Exception {
        List<User> users= Arrays.asList(new User(),new User(), new User());

        when(userService.getAllUser()).thenReturn(users);

        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(view().name("users2"))
                .andExpect(model().attributeExists("users"));


    }

    @Test
    public void addUserForm() {
    }

    @Test
    public void addUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void showProfile() {
    }

    @Test
    public void testUserNotFoundException() throws Exception {

        when(userService.getUser(anyLong())).thenThrow(UserNotFoundExpection.class);

        mockMvc.perform(get("/users/4"))
                .andExpect(status().isNotFound())
                .andExpect(view().name("error404"));

    }
}