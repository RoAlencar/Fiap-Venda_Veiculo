package br.com.fiap.app.venda.veiculo.infrastructure.exception;

import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GlobalExceptionHandlerTest {

    GlobalExceptionHandler globalExceptionHandler = new GlobalExceptionHandler();

    @Test
    public void handlerPagamentoNotFoundException(){
        PagamentoNotFoundException exception = new PagamentoNotFoundException();

        ObjectNode mockObjectNode = mock(ObjectNode.class);
        when(mockObjectNode.asText()).thenReturn("Não foi possivel encontrar o pagamento");

        globalExceptionHandler = Mockito.spy(globalExceptionHandler);
        doReturn(mockObjectNode).when(globalExceptionHandler).converterMensagem(anyString());

        ResponseEntity<ObjectNode> response = globalExceptionHandler.handlepagamentoNotFoundException(exception);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());

        assertEquals(mockObjectNode,response.getBody());

        verify(globalExceptionHandler).converterMensagem("Não foi possivel encontrar o pagamento");
    }

    @Test
    public void testConverterMensagem() {
        GlobalExceptionHandler exceptionHandler = new GlobalExceptionHandler();
        String mensagem = "Mensagem de teste";
        ObjectNode resultado = exceptionHandler.converterMensagem(mensagem);
        assertEquals(mensagem, resultado.get("mensagem").asText());
    }

}
