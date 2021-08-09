Sistema teste para sevensys

    A aplicação é uma API Rest desenvolvida no padrao MVC utilizando SpringBoot e pra camada de 
    persistência foi utilizado Hibernate nas especificações do JPA. Foi utilizado
    as melhores práticas de desenvolvimento como: clean code (codigo otimizado e endentado 
    e auto explicativo sem sujar o código com comentários), divisão de responsábilidades, tratamento 
    de erros etc.

    Para utilizar a aplicação é necessario que execute o sqls_teste.sql no banco de dados da Oracle
    e o maven será responsavel por fazer a injeção das outras dependencias.
    
    Para os testes utilizei uma carga de dados em Json integrando a API com o Postman.

A API possui as seguintes funcionalidades: 

Cliente (/cliente)

GET: /cliente/busca?id={id} retorna um json das informações de cadastro do cliente {id}

POST: /cliente/novoCliente esse método é invocado fazer uma requisição POST e é necessario passar um body.json completo das informações do cliente que estará sendo cadastrado.
esse método automaticamente cria uma conta ao cliente na empresa XPTO e também obriga o mesmo a ter uma movimentação inicial que também foi setada como padrão o valor de R$ 100,00


Conta (/conta)

GET: /conta/getConta?id={id} retorna um json das informações da conta de um cliente.


Movimentacao (/movimentacao)

GET: /movimentacao/getMovimentacao?id{id} retorna um json com informações da movimentação feita pela conta {id}

POST: movimentacao/novaMovimentacao esse método é invocado ao fazer uma requisição POST e é necessário passar um body.json completo das informações da movimentacao de uma determinada conta.


Relatorio (/relatorio)

GET: relatorio/getRelatorioCliente?idConta={idConta} método responsável por retornar o relatório de movimentações de uma determinada conta.
O metodo executa uma procedure no banco que faz um merge na tabela de relatório alimentado-a caso existir novas movimentações e atualizando as movimentações caso existir alteração.

GET: relatorio/getRelatorioEmpresa método responsável por retornar o relatório de receita para a empresa XPTO.
