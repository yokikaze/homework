package com.ke.lisijia.spring_boot_demo;


import com.ke.lisijia.spring_boot_demo.model.Teacher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.hamcrest.Matchers.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValueTest {

    @Autowired
    private Teacher teacher;

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockHttpSession session;
    private MockMvc mock;

    @Before
    public void init() {
        mock = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
    }

    @Test
    public void ConfigurationTest() {
        assertThat(teacher.toString(), notNullValue());
        assertThat(teacher.getName(), is("\"mayoumi\""));
    }

}
