CREATE TABLE tb_usuario
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    tipo_usuario      VARCHAR(255)                            NOT NULL,
    documento         VARCHAR(255)                            NOT NULL,
    nome              VARCHAR(255)                            NOT NULL,
    senha             VARCHAR(255)                            NOT NULL,
    email             VARCHAR(255)                            NOT NULL,
    endereco          VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_tb_usuario PRIMARY KEY (cod)
);

CREATE TABLE tb_termo_aceite
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    cod_usuario       BIGINT                                  NOT NULL,
    aceito            BOOLEAN                                 NOT NULL,
    descricao         VARCHAR(255)                            NOT NULL,
    CONSTRAINT pk_tb_termo_aceite PRIMARY KEY (cod)
);

ALTER TABLE tb_termo_aceite
    ADD CONSTRAINT uc_tb_termo_aceite_cod_usuario UNIQUE (cod_usuario);

ALTER TABLE tb_termo_aceite
    ADD CONSTRAINT FK_TB_TERMO_ACEITE_ON_COD_USUARIO FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod);

CREATE TABLE tb_notificacao
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    mensagem          VARCHAR(255)                            NOT NULL,
    tipo_notificacao  SMALLINT                                NOT NULL,
    cod_usuario       BIGINT,
    CONSTRAINT pk_tb_notificacao PRIMARY KEY (cod)
);

ALTER TABLE tb_notificacao
    ADD CONSTRAINT uc_tb_notificacao_cod_usuario UNIQUE (cod_usuario);

ALTER TABLE tb_notificacao
    ADD CONSTRAINT FK_TB_NOTIFICACAO_ON_COD_USUARIO FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod);

CREATE TABLE tb_reserva
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    usuario_cod       BIGINT,
    descricao         VARCHAR(255),
    restaurante_cod   BIGINT,
    CONSTRAINT pk_tb_reserva PRIMARY KEY (cod)
);

ALTER TABLE tb_reserva
    ADD CONSTRAINT uc_tb_reserva_usuario_cod UNIQUE (usuario_cod);

ALTER TABLE tb_reserva
    ADD CONSTRAINT FK_TB_RESERVA_ON_RESTAURANTE_COD FOREIGN KEY (restaurante_cod) REFERENCES tb_usuario (cod);

ALTER TABLE tb_reserva
    ADD CONSTRAINT FK_TB_RESERVA_ON_USUARIO_COD FOREIGN KEY (usuario_cod) REFERENCES tb_usuario (cod);


CREATE TABLE tb_avaliacao
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    nota              INT                                     NOT NULL,
    cod_reserva       BIGINT,
    cod_notificacao   BIGINT,
    CONSTRAINT pk_tb_avaliacao PRIMARY KEY (cod)
);

ALTER TABLE tb_avaliacao
    ADD CONSTRAINT uc_tb_avaliacao_cod_notificacao UNIQUE (cod_notificacao);

ALTER TABLE tb_avaliacao
    ADD CONSTRAINT uc_tb_avaliacao_cod_reserva UNIQUE (cod_reserva);

ALTER TABLE tb_avaliacao
    ADD CONSTRAINT FK_TB_AVALIACAO_ON_COD_NOTIFICACAO FOREIGN KEY (cod_notificacao) REFERENCES tb_notificacao (cod);

ALTER TABLE tb_avaliacao
    ADD CONSTRAINT FK_TB_AVALIACAO_ON_COD_RESERVA FOREIGN KEY (cod_reserva) REFERENCES tb_reserva (cod);


CREATE TABLE tb_mesa
(
    cod               BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    data_de_inclusao  TIMESTAMP,
    data_de_alteracao TIMESTAMP,
    qtd_cadeira       INT                                     NOT NULL,
    cod_restaurante   BIGINT                                  NOT NULL,
    CONSTRAINT pk_tb_mesa PRIMARY KEY (cod)
);

ALTER TABLE tb_mesa
    ADD CONSTRAINT FK_TB_MESA_ON_COD_RESTAURANTE FOREIGN KEY (cod_restaurante) REFERENCES tb_usuario (cod);




