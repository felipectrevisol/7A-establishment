package br.com.sev7aura.establishment.task.httpresource;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import br.com.sev7aura.establishment.httpresource.AddTaskCardsHttpResource;
import br.com.sev7aura.establishment.task.TaskCardAdder;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AddTaskCardsHttpResource.class)
class AddTaskCardsHttpResourceTest {

	@Autowired MockMvc mockMvc;
    @MockBean TaskCardAdder adder;

    @Test void postRequest() throws Exception {
		mockMvc.perform(post("/api/v1/task")
			.contentType("application/json")
			.content("{\"title\":\"A Title.\", \"priority\":1}"))
			.andExpect(status().isCreated());
    }
}