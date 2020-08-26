package com.example.board.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.board.Service.IBoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles({"local"})
class BoardControllerTest {

  @Autowired MockMvc mvc;
//  @Autowired private IBoardService service;

  @Value("${spring.datasource.url}")
  String datasourceURL;

  @Test
  void getBoardList() throws Exception {
    System.out.println("####### START :Moc Mvc Test ###########");
    System.out.println("######### getBoardList()  #############");
    System.out.println(datasourceURL);
    mvc.perform(get("/api/board"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andDo(print());

    System.out.println("######## END :Moc Mvc Test ############");
  }
}
