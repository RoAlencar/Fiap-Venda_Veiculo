package br.com.fiap.app.venda.veiculo.adapter.in.web;

import br.com.fiap.app.venda.veiculo.application.dto.request.GetStatusPagamentoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.GetStatusPagamentoResponse;
import br.com.fiap.app.venda.veiculo.application.port.GetStatusPagamentoUseCasePort;
import br.com.fiap.app.venda.veiculo.infrastructure.exception.custom.PagamentoNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/webhook")
@RequiredArgsConstructor
public class VendaWebHookController {

    private final GetStatusPagamentoUseCasePort getStatusPagamentoUseCasePort;

    @GetMapping("/status-pagamento")
    public ResponseEntity<GetStatusPagamentoResponse> getStatusPagamento(@RequestBody GetStatusPagamentoRequest request) throws PagamentoNotFoundException {
        return new ResponseEntity<>(getStatusPagamentoUseCasePort.getStatusPagamento(request), HttpStatus.OK);
    }
}
