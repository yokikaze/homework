package com.ke.lisijia.spring_boot_demo;

import com.alibaba.fastjson.JSON;
import com.ke.lisijia.spring_boot_demo.model.Student;
import com.ke.lisijia.spring_boot_demo.service.MongoDBService;
import com.ke.lisijia.spring_boot_demo.service.MybatisService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {

    @Autowired
    private MongoDBService mongoDBService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    private MockHttpSession session;

    @Before
    public void mockMvcInit() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        session = new MockHttpSession();
    }

    @Test
    @Transactional
    public void mongodbTest(){
        Student student = MybatisService.randomStudent();
        student.setId(39);
        System.out.println(student.toString());
        assertThat(mongoDBService.insertStudent(student), is(student));
        Student s = mongoDBService.findAll().get(0);
        assertThat(s, is(student));
        mongoDBService.deleteStudent(39);
        assertThat(mongoDBService.findById(39), is(student));
    }

    @Test
    public void mongoDBUpdateTest() throws Exception {
        Student student = MybatisService.randomStudent();
        student.setId(9);
        mockMvc.perform(MockMvcRequestBuilders.post("/mongo/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(student))
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void mongoDBInsertTest() throws Exception {
        Student student = MybatisService.randomStudent();
        student.setId(78);
        mockMvc.perform(MockMvcRequestBuilders.post("/mongo/insert")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(student))
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print());
    }
}
