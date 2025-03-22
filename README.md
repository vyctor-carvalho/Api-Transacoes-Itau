# API de Transações e Estatísticas

Esta API foi desenvolvida para um desafio do Itaú, utilizando Java 21, Spring Boot e Maven. Ela permite o gerenciamento de transações e a obtenção de estatísticas em tempo real.

## Endpoints

### `/transacao`
- `POST /transacao` → Registra uma nova transação.
- `DELETE /transacao` → Remove todas as transações.

### `/estatistica`
- `GET /estatistica` → Retorna estatísticas das transações registradas em 60 segundos.

## Tecnologias utilizadas
- **Java 21**
- **Spring Boot**
- **Maven**
- **Docker** (contém um `Dockerfile` na raiz do projeto)

## Como executar

### Via Maven
1. Clone o repositório:
   ```sh
   git clone https://github.com/vyctor-carvalho/Api-Transacoes-Itau
   ```
2. Acesse a pasta do projeto:
   ```sh
   cd seu-diretorio
   ```
3. Compile e execute a aplicação:
   ```sh
   mvn spring-boot:run
   ```

### Via Docker
1. **Construir a imagem Docker**  
   Navegue até a raiz do projeto e execute:
   ```sh
   docker build -t api-transacoes .
   ```

2. **Executar o container**  
   Execute o seguinte comando para iniciar o container:
   ```sh
   docker run -p 8080:8080 api-transacoes
   ```

3. **Verificar se a API está rodando**  
   Acesse no navegador ou via cURL:
   ```sh
   curl http://localhost:8080/estatistica
   ```

4. **Parar o container**  
   Liste os containers em execução:
   ```sh
   docker ps
   ```
   Copie o ID do container e pare-o com:
   ```sh
   docker stop <CONTAINER_ID>
   ```

## Autor
[Vyctor Carvalho](https://github.com/vyctor-carvalho)

