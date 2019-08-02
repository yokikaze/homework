package com.ke.lisijia.spring_boot_demo;

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
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockMvcTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    private MockHttpSession mockHttpSession;

    @Autowired
    private MybatisService mybatisService;

    @Before
    public void mockMvcInit() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        mockHttpSession = new MockHttpSession();
    }

    /**
     * 查询
     * @throws Exception
     */
    @Test
    public void findByIdTest() throws Exception {
        //String json = "{\"id\":1,\"name\":\"zs\",\"gender\":\"男\",\"grade\":1,\"classroom\":3,\"score\":40}";
        mockMvc.perform(MockMvcRequestBuilders.get("/findById/3")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                //.content(json.getBytes())
                //.session(mockHttpSession)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 插入
     * @throws Exception
     */
    @Test
    @Transactional
    public void insertStudent() throws Exception {
        String jsonStudent = "{\"id\":10,\"name\":\"qop\",\"gender\":\"男\",\"grade\":1,\"classroom\":3,\"score\":40}";
        mockMvc.perform(MockMvcRequestBuilders.post("/insertStudent")
            //.contentType(MediaType.APPLICATION_JSON_UTF8)
            .accept(MediaType.APPLICATION_JSON_UTF8)
            .content(jsonStudent.getBytes())
            .session(mockHttpSession)
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 修改
     * @throws Exception
     */
    @Test
    public void updateGenderTest() throws Exception {
        String string = "女";
        mockMvc.perform(MockMvcRequestBuilders.post("/updateStudentGender")
                .contentType(MediaType.ALL_VALUE)
                .content(string)
                .session(mockHttpSession)
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    /**
     * 删除
     */
    @Test
    public void deleteById() throws Exception {
        String id ="11";
        mockMvc.perform(MockMvcRequestBuilders.post("/deleteStudent")
                .contentType(MediaType.ALL)
                .content(id)
                .session(mockHttpSession)
        ).andExpect(MockMvcResultMatchers.status().isOk())
         .andDo(MockMvcResultHandlers.print());
    }

    /**
     * assertThat断言
     */
    @Test
    public void assertThatTest() throws Exception {
        String studentString = mybatisService.findById(1);
        int num = 900;
        assertThat(studentString, notNullValue());
        assertThat(studentString, is(123));
        assertThat(studentString, not(is("234")));
        assertThat(num, allOf(greaterThan(100), lessThan(1000)));
        assertThat(num, anyOf(greaterThan(900), lessThan(100)));
    }
}
