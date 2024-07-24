package br.com.fiap.app.venda.veiculo.adapter.in.web;

import br.com.fiap.app.venda.veiculo.application.dto.request.ReservaVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.request.VenderVeiculoRequest;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaStatusVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.BuscaVendaClienteResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.ReservaVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.dto.response.VenderVeiculoResponse;
import br.com.fiap.app.venda.veiculo.application.port.BuscaVendaClienteUseCasePort;
import br.com.fiap.app.venda.veiculo.application.port.BuscaVendaVeiculoUseCasePort;
import br.com.fiap.app.venda.veiculo.application.port.VendaVeiculoUseCasePort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/venda-veiculo")
@RequiredArgsConstructor
public class VendasController {

    private final BuscaVendaVeiculoUseCasePort buscaVendaVeiculoUseCasePort;
    private final BuscaVendaClienteUseCasePort buscaVendaClienteUseCasePort;
    private final VendaVeiculoUseCasePort vendaVeiculoUseCasePort;

    @GetMapping("/veiculos/disponiveis")
    public ResponseEntity<List<BuscaStatusVeiculoResponse>> buscaTodosVeiculosAVendaOrdenadosPorMenorPreco() throws Exception {
        log.info("[Venda Veiculo - Busca todos os veiculos a venda por menor preço] Iniciando processo.");
        return new ResponseEntity<>(buscaVendaVeiculoUseCasePort.buscaVeiculosAVendaPorMenorPreco(), HttpStatus.OK);
    }

    @GetMapping("/veiculos/vendidos")
    public ResponseEntity<List<BuscaStatusVeiculoResponse>> buscaTodosVeiculosAVendidosPorMenorPreco(){
        log.info("[Venda Veiculo - Busca todos os veiculos vendidos por menor preço] Iniciando processo.");
        return new ResponseEntity<>(buscaVendaVeiculoUseCasePort.buscaVeiculosVendidosPorMenorPreco(), HttpStatus.OK);
    }

    @GetMapping("/vendas")
    public ResponseEntity<List<BuscaVendaClienteResponse>> buscaTodasVendasCliente(){
        log.info("[Venda Veiculo - Busca todas as vendas do cliente] Iniciando processo.");
        return new ResponseEntity<>(buscaVendaClienteUseCasePort.buscaTodasVendasCliente(), HttpStatus.OK);
    }

    @PostMapping("/vender")
    public  ResponseEntity<VenderVeiculoResponse> venderVeiculo(@RequestBody VenderVeiculoRequest request){
        log.info("[Venda Veiculo - Vender Veiculo] Iniciando processo.");
        return new ResponseEntity<>(vendaVeiculoUseCasePort.vendaVeiculo(request), HttpStatus.OK);
    }

    @PostMapping("/reservar")
    public ResponseEntity<ReservaVeiculoResponse> reservaVeiculo(@RequestBody ReservaVeiculoRequest request){
        log.info("[Venda Veiculo - Reserva Veiculo] Iniciando processo.");
        return new ResponseEntity<>(vendaVeiculoUseCasePort.reservaVeiculo(request), HttpStatus.OK);
    }
}
