# Projetos

Projeto de uma Api Rest com autenticação basica e cadastro de produto e usuário básicos.

Projeto desenvolvido em Spring Boot pode ser executado pela ide eclipse, ou outra de sua preferencia.
É necessario ter instalado o java e o banco MySql.

Banco em MySql Nome do banco = crud-apirest 
Autenticação do Banco usuário = root 
senha = admin 
As tabelas são criadas na execução do projeto.
Caso queria alterar a altenticação do banco, deve alterar no application.properties

Criar um usuário pelo método post para autenticar e ter acesso aos outros métodos

Model Usuário Métodos 
Get /api/usuarios = retorna todos os usuários cadastrados 
Get /api/usuario/id = retorna o usuário pelo identificador 
Post /api/usuario = salva o usuário 
Delete /api/usuario = deleta o usuário

Model Produto Métodos 
Get /api/produtos = retorna todos os produtos cadastrados 
Get /api/produto/id = retorna o produto pelo identificador 
Post /api/produto = salva o produto 
Delete /api/produto = deleta o produto
