CREATE TABLE IF NOT EXISTE CORE_VENDA (
    ID SERIAL PRIMARY KEY,
    ID_VEICULO LONG NOT NULL,
    CPF_CLIENTE VARCHAR(50) NOT NULL,
    STATUS_VENDA VARCHAR(20) CHECK (STATUS_VENDA IN ('PENDENTE','CONCLUIDO', 'CANCELADO')),
    CODIGO_PAGAMENTO VARCHAR(50) NOT NULL,
    DATA_VENDA DATE NOT NULL);

-- INSERE UMA VENDA

INSERT INTO CORE_VENDA (
    ID_VEICULO,
    CPF_CLIENTE,
    STATUS_VENDA,
    CODIGO_PAGAMENTO,
    DATA_VENDA
) VALUES (
             2,
             '123.456.789-00',
             'CONCLUIDO',
             '1QADZAQEWQ/QEWQ',
             CURRENT_DATE
         )

-- Cria a tabela core_veiculo se não existir
CREATE TABLE IF NOT EXISTS core_veiculo (
                                            id SERIAL PRIMARY KEY,
                                            ano INT NOT NULL,
                                            cor VARCHAR(50) NOT NULL,
    data_atualizacao DATE NOT NULL,
    data_cadastro DATE NOT NULL,
    descricao TEXT,
    marca VARCHAR(50) NOT NULL,
    modelo VARCHAR(50) NOT NULL,
    numero_portas VARCHAR(20) CHECK (numero_portas IN ('DUAS', 'TRES', 'QUATRO', 'NAO_SE_APLICA')),
    placa VARCHAR(10) UNIQUE NOT NULL,
    preco DECIMAL(10, 2) NOT NULL,
    quilometragem INT NOT NULL,
    status VARCHAR(20) CHECK (status IN ('VENDIDO', 'DISPONIVEL', 'RESERVADO')),
    tipo VARCHAR(20) CHECK (tipo IN ('HATCH', 'SEDAN', 'SUV', 'PICAPE', 'CROSSOVER', 'PERUA', 'MINIVAN', 'ESPORTIVO', 'FURGAO')),
    tipo_combustivel VARCHAR(20) CHECK (tipo_combustivel IN ('ETANOL', 'GASOLINA', 'FLEX', 'DIESEL', 'GNV', 'ELETRICO'))
    );

-- Insere três registros de veículos
INSERT INTO core_veiculo (
    ano,
    cor,
    data_atualizacao,
    data_cadastro,
    descricao,
    marca,
    modelo,
    numero_portas,
    placa,
    preco,
    quilometragem,
    status,
    tipo,
    tipo_combustivel
) VALUES
      (
          2024,
          'Preto',
          CURRENT_DATE,
          CURRENT_DATE,
          'Veículo de teste 1',
          'Toyota',
          'Corolla',
          'QUATRO',
          'ABC1234',
          35000.00,
          5000,
          'DISPONIVEL',
          'SEDAN',
          'FLEX'
      ),
      (
          2022,
          'Branco',
          CURRENT_DATE,
          CURRENT_DATE,
          'Veículo de teste 2',
          'Ford',
          'Fiesta',
          'TRES',
          'XYZ5678',
          20000.00,
          12000,
          'RESERVADO',
          'HATCH',
          'GASOLINA'
      ),
      (
          2023,
          'Azul',
          CURRENT_DATE,
          CURRENT_DATE,
          'Veículo de teste 3',
          'Honda',
          'Civic',
          'DUAS',
          'LMN9012',
          40000.00,
          8000,
          'VENDIDO',
          'SEDAN',
          'DIESEL'
      );
