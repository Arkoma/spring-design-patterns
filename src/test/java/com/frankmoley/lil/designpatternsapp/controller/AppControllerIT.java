package com.frankmoley.lil.designpatternsapp.controller;

import com.frankmoley.lil.designpatternsapp.factory.PetFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@RunWith(SpringRunner.class)
@DirtiesContext
@WebAppConfiguration
//TODO: find out why this test fails when run with the other tests
public class AppControllerIT {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AppController underTest;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    public void appControllerIsABean() {
        assertTrue(applicationContext.containsBean("appController"));
    }

    @Test
    public void appControllerInjectsAPetFactory() {
        PetFactory injectedPetFactory = (PetFactory) ReflectionTestUtils.getField(underTest, "petFactory");
        assertNotNull(injectedPetFactory);
    }

    @Test
    public void getEndpointRecievesMessage() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(jsonPath("$.message").value("Hello World")).andReturn();
    }

    @Test
    public void adoptPetEndpointReturnsExpectedPet() throws Exception {
        this.mockMvc.perform(post("/adopt/dog/Fido"))
                .andExpect(jsonPath("$.type").value("DOG"))
                .andExpect(jsonPath("$.name").value("Fido"))
                .andExpect(jsonPath("$.hungry").value(false))
                .andReturn();
    }

    @Test
    public void getContactsEndpointReturnsExpectedContacts() throws Exception {
        this.mockMvc.perform(get("/contacts"))
                .andExpect(jsonPath("$[0].firstName").value("Bob"))
                .andExpect(jsonPath("$[0].lastName").value("Builder"))
                .andExpect(jsonPath("$[0].email").hasJsonPath())
                .andExpect(jsonPath("$[1].firstName").value("Sue"))
                .andExpect(jsonPath("$[1].lastName").value("Builder"))
                .andExpect(jsonPath("$[1].email").hasJsonPath())
                .andReturn();
    }
}
