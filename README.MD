
# Desafio Muralis - Comércio SA!

## 1. Estrutura do Projeto

O projeto foi organizado utilizando o padrão MVC (Model-View-Controller) para garantir uma estrutura bem definida e fácil de manter. As camadas estão dispostas da seguinte forma:

- **Model**: Contém as entidades e define a estrutura do banco de dados, incluindo regras de negócio relacionadas a cada tabela.
- **Repository**: Responsável pela comunicação direta com o banco de dados, utilizando o JpaRepository para operações de CRUD.
- **Service**: Define os principais métodos de processamento de dados do sistema.
- **Service Implementation**: Implementa os métodos do Service, aplicando a lógica do sistema.
- **Controller**: Gerencia as requisições HTTP, redirecionando-as para os serviços apropriados.

## 2. Banco de Dados e Scripts

Para testar a aplicação, as tabelas do banco de dados precisam ser criadas com os seguintes comandos SQL:

### Criação do Banco de Dados:
```sql
CREATE DATABASE muralis;
```

### Criação das Tabelas:
```sql
CREATE TABLE cliente (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    nome            VARCHAR(100) NOT NULL,
    cpf             VARCHAR(14) NOT NULL UNIQUE,
    data_nascimento DATE NOT NULL,
    endereco        VARCHAR(255)
);

CREATE TABLE contato (
    id         INT PRIMARY KEY AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    tipo       VARCHAR(50) NOT NULL,
    valor      VARCHAR(100) NOT NULL,
    observacao VARCHAR(255),
    FOREIGN KEY (cliente_id) REFERENCES cliente (id)
);
```

### População da Tabela Cliente:
```sql
INSERT INTO cliente (nome, cpf, data_nascimento, endereco) VALUES
('Ingmar', '9783928651', '2024-11-29', '37 Tennessee Point'),
('Chandal', '0339119071', '2024-11-29', '92024 Grayhawk Hill'),
('Pierre', '1158413661', '2025-01-26', '2792 Kipling Trail'),
('Tailor', '6912153410', '2025-02-08', '71150 Bluejay Way'),
('Lindy', '9258921364', '2024-12-19', '16754 Hoard Circle'),
```

### População da Tabela Contato:
```sql
INSERT INTO contato (cliente_id, tipo, valor, observacao) VALUES
(2, 'Telefone', '11987654321', 'Número pessoal'),
(4, 'Telefone', '21988776655', 'Contato de emergência'),
(6, 'E-mail', 'joao@email.com', 'E-mail principal'),
(1, 'E-mail', 'maria@email.com', 'E-mail alternativo'),
(5, 'Telefone', '31991234567', 'Número comercial'),
(6, 'Telefone', '41999887766', 'WhatsApp'),
(2, 'E-mail', 'pedro@email.com', 'E-mail de trabalho'),
(3, 'Telefone', '51995544332', 'Contato secundário'),
(5, 'E-mail', 'ana@email.com', 'E-mail pessoal'),
(2, 'Telefone', '61993322110', 'Número residencial'),
(1, 'Telefone', '71991112233', 'Celular'),
```

## 3. Instruções para Execução do Projeto

### Configuração do Backend

1. Instale o Java Development Kit (JDK) versão 21 ou superior.
2. Instale o MySQL e inicie o servidor. Se estiver usando o XAMPP, lembre-se de iniciar o MySQL.
3. Verifique as configurações do banco de dados no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/muralis
   spring.datasource.username=root
   spring.datasource.password=senha_aqui
   spring.jpa.hibernate.ddl-auto=update
   ```

Para rodar o backend, execute o seguinte comando:
```bash
mvn spring-boot:run
```