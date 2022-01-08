insert into cozinha (nome) values('Carnes');
insert into cozinha (nome) values('Japonesa');
insert into cozinha (nome) values('Mineira');

insert into estado (nome) values ('Paraná');
insert into estado (nome) values ('Bahia');
insert into estado (nome) values ('São Paulo');
insert into estado (nome) values ('Minas Gerais');

insert into cidade (nome, estado_id) values ('Umuarama', 1);
insert into cidade (nome, estado_id) values ('Salvador', 2);
insert into cidade (nome, estado_id) values ('Araraquara', 3);
insert into cidade (nome, estado_id) values ('Belo Horizonte', 4);

insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao, endereco_cidade_id, endereco_cep, endereco_logradouro, endereco_numero, endereco_complemento, endereco_bairro) values ('Churrasquero', 15.00, 1, utc_timestamp, utc_timestamp, 1, '87500800', 'Rua OffShore', '4550', null ,'Limão');
insert into restaurante (nome, taxa_frete, cozinha_id, data_cadastro, data_atualizacao) values ('Ebisu', 10.50, 2, utc_timestamp, utc_timestamp);
insert into restaurante (nome, taxa_frete, cozinha_id,data_cadastro, data_atualizacao) values ('Manara', 0, 3, utc_timestamp, utc_timestamp);


insert into forma_pagamento (descricao) values ('Cartão de Crédito'), ('Cartão de Débito'), ('Dinheiro');

insert into restaurante_forma_pagamento(restaurante_id, forma_pagamento_id) values (1,1), (1,2), (1,3),(2,1), (2,2), (2,3), (3,1), (3,2), (3,3);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Batata Doce', 'Culinária Maromba', 20.00, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Costelinha', 'Costelinha de porco Assada', 38.00, true, 1);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('T-Bone', 'Corte T-Bone assado', 48.00, false, 1);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Rodizio Sushi', 'Pratos diversos', 88.00, true, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Temaki Diversos', 'Recheios variados', 12.00, true, 2);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Surpresa de Maracuja', 'Sobremesa', 39.00, true, 2);

insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Self Service', 'Almoço', 48.00, true, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Coca-Cola 600ml', 'Bebidas', 6.00, true, 3);
insert into produto (nome, descricao, preco, ativo, restaurante_id) values ('Marmita G', 'Almoço', 23.00, true, 3);






