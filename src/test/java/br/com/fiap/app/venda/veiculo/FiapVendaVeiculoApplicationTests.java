package br.com.fiap.app.venda.veiculo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalManagementPort;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FiapVendaVeiculoApplicationTests {

	@LocalManagementPort
	private int port;

	private TestRestTemplate restTemplate = new TestRestTemplate();

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
		assertThat(applicationContext).isNotNull();
	}

	@Test
	public void testApplicationMain() {
		String baseUrl = "http://localhost:" + port;

		String response = restTemplate.getForObject(baseUrl, String.class);

		assertThat(response).isNotNull();
		assertThat(response).contains("timestamp");
		assertThat(response).contains("status");

	}
}

