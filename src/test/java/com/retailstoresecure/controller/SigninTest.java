package com.retailstoresecure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class SigninTest {



    @Autowired
    private MockMvc mvc;



    @Test()
    @WithAnonymousUser
    public void givenUnauthenticated_whenHomeRequest_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/")                                                             )
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring" , roles = "WORKER")
    @Test
    public void givenAuthRequestOnHome_AndWorkerRole_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/")                                                             )
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring" , roles = "MANAGER")
    @Test
    public void givenAuthRequestOnHome_AndManagerRole_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/")                                                             )
                .andExpect(status().isOk());
    }






    @WithMockUser(value = "spring" , roles = "WORKER")
    @Test
    public void givenAuthRequestOnEmployeeSchedule_AndWorkerRole_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/employee/timetable")                                                             )
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring" , roles = "MANAGER")
    @Test
    public void givenAuthRequestOnEmployeeSchedule_AndManagerRole_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/employee/timetable")                                                             )
                .andExpect(status().isOk());
    }


    @Test()
    @WithAnonymousUser
    public void givenUnauthenticated_whenEmployeeSchedule_thenThrowsException() throws Exception {
        mvc.perform(get("/employee/timetable")                                                             )
                .andExpect(status().isUnauthorized());
    }



    @WithMockUser(value = "spring" , roles = "MANAGER")
    @Test
    public void givenAuthRequestOnEmployeePay_AndManagerRole_shouldSucceedWith200() throws Exception {
        mvc.perform(get("/admin/workerpay")                                                             )
                .andExpect(status().isOk());
    }

    @WithMockUser(value = "spring" , roles = "Worker")
    @Test
    public void givenAuthRequestOnEmployeePay_AndWorkerRole_ThenUnAuthorised() throws Exception {
        mvc.perform(get("/admin/workerpay")                                                             )
                .andExpect(status().isUnauthorized());
    }


    @Test()
    @WithAnonymousUser
    public void givenUnauthenticated_whenEmployeePay_thenThrowsException() throws Exception {
        mvc.perform(get("/admin/pay")                                                             )
                .andExpect(status().isUnauthorized());
    }

}