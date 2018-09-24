README

Backend

1) Instalar e configurar uma instância do MySQL (localhost)
2) Localizar e executar o script sql /jsd-customer/backend/jsd-customer/db/create_objects.sql;
3) Instalar um servidor de aplicação (Tomcat, Jboss, etc.)
4) Alterar as configurações de banco de dados no arquivo persistence.xml /jsd-customer/backend/jsd-customer/src/main/resources/META-INF/persistence.xml;
5) Executar um clean install no maven para gerar o arquivo jsd-customer.war;
6) Realizar o deployment do WAR no servidor de aplicação;
7) Acessar os serviços REST disponíveis na url http://localhost:8080/jsd-customer/rest/customers

Frontend

1) Instalar a última versão do Node JS;
2) Instalar a última versão do NPM;
3) Instalar a última versão do Angular CLI;
4) No diretório do frontend, executar o comando npm install;
5) Executar o comando ng serve
6) A aplicação estará disponível na url http://localhost:4200/