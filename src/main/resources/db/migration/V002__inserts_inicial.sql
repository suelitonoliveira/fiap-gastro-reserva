insert into TB_TERMO_ACEITE (DATA_DE_INCLUSAO, DATA_DE_ALTERACAO, DESCRICAO)
VALUES (CURRENT_TIMESTAMP, null,
        'Eu entendo e concordo que as informações fornecidas podem ser transferidas para terceiros, incluindo prestadores de serviços, afiliados e parceiros comerciais da empresa Gastro Reserva, conforme necessário para cumprir as finalidades descritas neste termo. ');

insert into TB_USUARIO (DTYPE, DATA_DE_INCLUSAO, DATA_DE_ALTERACAO, TIPO_USUARIO, CPF, NOME, SENHA, EMAIL, ENDERECO,
                        TERMO_ACEITE_COD)
VALUES (null, CURRENT_TIMESTAMP, null, 'FUNCIONARIO', '93029719022', 'teste', 'teste', 'teste@teste',
        'qualquer endereço', 1);

insert into TB_RESTAURANTE (DATA_DE_INCLUSAO, DATA_DE_ALTERACAO,NOME_RESTAURANTE)
values (CURRENT_TIMESTAMP,NULL,'RESTAURANTE TESTE');

insert into TB_MESA (DATA_DE_INCLUSAO, DATA_DE_ALTERACAO, QTD_CADEIRA, COD_RESTAURANTE)
VALUES (CURRENT_TIMESTAMP, null, 4, 1);

insert into TB_MESA (DATA_DE_INCLUSAO, DATA_DE_ALTERACAO, QTD_CADEIRA, COD_RESTAURANTE)
VALUES (CURRENT_TIMESTAMP, null, 6, 1);

insert into TB_MESA (DATA_DE_INCLUSAO, DATA_DE_ALTERACAO, QTD_CADEIRA, COD_RESTAURANTE)
VALUES (CURRENT_TIMESTAMP, null, 8, 1)