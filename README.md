# CLIENTE
___

API Cliente - CRUD desenvolvido com tecnologia Spring Boot / JDBC / H2 

Aplicação irá efetuar a gravação ,edição ,deleção e consulta de clientes
Ao inserir uma cliente novo será inserido um registo na tabela clima com os dados do clima 
da região de onde foi feito o request

O retorno dos métodos de consulta será em JSON

Observação: Os dados climáticos são baseados no IP requisitante, Sendo assim ao executar o teste local 
o IP para localhost será 0:0:0:0:0:0:0:1 ou 127.0.0.1  que levará a divergencia nos valores na hora do teste.

## REPOSITORIO?
Para consultar o banco de dados da aplicação deve iniciar a aplicação e acessar:
{host}/h2-console/
Garantir que o JDBC URL  = dbc:h2:mem:testdb
Irá abrir o console do H2 onde será possível consultar o banco de dados tanto de cliente 
quanto do clima.
 

## Como funciona?
Para todos os serviços disponíveis nesse sistema é necessário utilizar um dos domínios específicos:


**OBS:** O domínio vai depender de qual local será chamado o serviço:


### CLIENTE

Endpoints: 
- Criar um Cliente 
	Efetuar com chamada POST para o enpoint "{host}/cliente"
	com o seguinte body (JSON ) exemplo:
	{"nome":"Marcelo", "idade": 25 }

- Alterar um Cliente
	Efetuar com chamada PUT para o enpoint "{host}/cliente"
	com o seguinte body (JSON ) exemplo: 
	{"id":2, "nome":"Maria", "idade": 28 }

- Consultar um Cliente por id 
	Efetuar com chamada GET para o enpoint "{host}/cliente/{idCliente}"

- Listar todos os Clientes salvos 
	Efetuar com chamada GET para o enpoint "{host}/cliente/all

- Remover Cliente por id
	Efetuar com chamada DELETE para o enpoint "{host}/cliente/{idCliente}"

# cliente
