package com.tw.smartpool.controller;

import com.tw.smartpool.model.Location;
import com.tw.smartpool.model.User;
import com.tw.smartpool.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HomeControllerTest {
    private UserService service;
    private HomeController controller;

    @Before
    public void setUp(){
        service = mock(UserService.class);
        controller = new HomeController(service);

    }

    @Test
    public void testHome() throws Exception {
        ModelAndView modelAndView = controller.home(new MockHttpServletResponse());
        assertEquals(new ModelAndView("home").getView(),modelAndView.getView());
    }

    @Test
    public void shouldAddUser() throws Exception {
        when(service.addUser("12345","manu","viswam","tcr")).thenReturn(true);
        ModelAndView mav = controller.addUser("12345","manu","viswam","1");
        assertEquals(new ModelAndView("success").getView(), mav.getView());
    }

    @Test
    public void shouldGetUserView() throws Exception {
        User user = new User("12345","manu","viswam",new Location(1,"Test"));
        when(service.getUserListByName("manu")).thenReturn(Arrays.asList(user));
        ModelAndView mav = controller.getUser(new MockHttpServletResponse(),"manu");
        assertEquals(user,((List)mav.getModelMap().get("users")).get(0));
    }
}
