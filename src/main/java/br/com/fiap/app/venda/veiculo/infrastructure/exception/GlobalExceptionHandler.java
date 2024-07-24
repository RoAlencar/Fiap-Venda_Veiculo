package br.com.fiap.app.venda.veiculo.infrastructure.exception;

import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PagamentoNotFoundException.class)
    public ResponseEntity<?> pagamentoNotFound(PagamentoNotFoundException ex) {
        log.warn("Não foi possivel encontrar o pagamento");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(converterMensagem("Não foi possivel encontrar o pagamento"));
    }

    ObjectNode converterMensagem(String mensagem) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode json = mapper.createObjectNode();
        json.put("mensagem", mensagem);
        return json;
    }

}
