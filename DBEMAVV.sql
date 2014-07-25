CREATE TABLE tb_alunos (
  fd_aluno SERIAL,
  fd_nome VARCHAR(100) NOT NULL,
  fd_cpf CHAR(11) NULL UNIQUE,
  fd_rg VARCHAR(30) NULL,
  fd_data_nasc DATE NOT NULL CHECK (fd_data_nasc > '1900-01-01' AND fd_data_nasc < NOW()),
  fd_sexo char(1) NOT NULL CHECK (fd_sexo IN ('F','M')),
  fd_endereco VARCHAR(50) NOT NULL,
  fd_numero VARCHAR(5) NOT NULL DEFAULT 'S/N',
  fd_bairro VARCHAR(30) NOT NULL,
  fd_cidade VARCHAR(30) NOT NULL,
  fd_cep CHAR(9) NOT NULL,
  fd_uf CHAR(2) NOT NULL,
  fd_telefone CHAR(11) NULL,
  fd_celular CHAR(11) NULL,
  fd_email VARCHAR(90) NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,	
  PRIMARY KEY(fd_aluno)
);

CREATE TABLE tb_funcionarios (
  fd_funcionario SERIAL,
  fd_nome VARCHAR(100) NOT NULL,
  fd_cpf CHAR(11) NULL UNIQUE,
  fd_rg VARCHAR(30) NULL,
  fd_data_nasc DATE NOT NULL CHECK (fd_data_nasc > '1900-01-01' AND fd_data_nasc < NOW()),
  fd_sexo char(1) NOT NULL CHECK (fd_sexo IN ('F','M')),
  fd_endereco VARCHAR(50) NOT NULL,
  fd_numero VARCHAR(5) NOT NULL DEFAULT 'S/N',
  fd_bairro VARCHAR(30) NOT NULL,
  fd_cidade VARCHAR(30) NOT NULL,
  fd_cep CHAR(9) NOT NULL,
  fd_uf CHAR(2) NOT NULL,
  fd_telefone CHAR(11) NULL,
  fd_celular CHAR(11) NULL,
  fd_email VARCHAR(90) NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY(fd_funcionario)
);
--CRIAÇÃO DO USUÁRIO PADRÃO DO SISTEMA ---------------------------------------------------------------------------------------------
INSERT into tb_funcionarios (
  fd_nome,fd_cpf,fd_rg, fd_data_nasc,fd_sexo,fd_endereco,fd_numero,fd_bairro,fd_cidade,fd_cep,fd_uf,fd_telefone,fd_celular,fd_email,fd_status )
values
('Supervisor do Sistema',NULL,NULL,'2014-05-21','M','RUA SOFTWARE',DEFAULT,'TERRA','FORTALEZA','000000000','CE',NULL,NULL,NULL,'A');
--FIM DA CRIAÇÃO DO USUARIO PADRÃO --------------------------------------------------------------------------------------------------

CREATE TABLE tb_cargos (
  fd_cargo SERIAL,
  fd_descricao VARCHAR(40) NOT NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')), 
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY(fd_cargo)
);

CREATE TABLE tb_cursos (
  fd_curso SERIAL,
  fd_descricao VARCHAR(255) NOT NULL,
  fd_valor NUMERIC(14,6) NOT NULL CHECK (fd_valor > 0),
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,  
  PRIMARY KEY(fd_curso)
);

CREATE TABLE tb_disciplinas (
  fd_disciplina SERIAL,
  fd_descricao VARCHAR(50) NOT NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_curso INT NOT NULL REFERENCES tb_cursos(fd_curso),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY(fd_disciplina)
);

CREATE TABLE tb_cursos_disciplinas (
  fd_curso INTEGER REFERENCES tb_cursos(fd_curso),
  fd_disciplina INTEGER REFERENCES tb_disciplinas(fd_disciplina),
  PRIMARY KEY(fd_curso, fd_disciplina)
);

CREATE TABLE tb_despesas (
  fd_despesa SERIAL,
  fd_descricao CHAR(255) NOT NULL,
  PRIMARY KEY(fd_despesa)
);

CREATE TABLE tb_formas_pagamentos(
  fd_formapagto SERIAL,
  fd_descricao VARCHAR(150) NOT NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN ('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY (fd_formapagto)	

);

CREATE TABLE tb_func_cargos (
  fd_funcionario INTEGER REFERENCES tb_funcionarios(fd_funcionario),
  fd_cargo INTEGER REFERENCES tb_cargos(fd_cargo),
  PRIMARY KEY(fd_funcionario, fd_cargo)
);

CREATE TABLE tb_itens (
  fd_item SERIAL,
  fd_descricao VARCHAR(50) NOT NULL,
  fd_valor NUMERIC(14,6) NOT NULL CHECK (fd_valor > 0),
 -- fd_qtde INT NOT NULL CHECK (fd_qtde > 0),
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY(fd_item)
);

CREATE TABLE tb_matriculas (
  fd_codigo serial not null,
  fd_matricula INTEGER NOT NULL UNIQUE,
  fd_aluno INTEGER REFERENCES tb_alunos(fd_aluno),
  fd_data_matricula DATE NOT NULL,
  fd_usuario INTEGER,
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY(fd_matricula, fd_aluno)
);

CREATE TABLE tb_matriculados (
  fd_matricula INTEGER REFERENCES tb_matriculas(fd_matricula),
  fd_curso INTEGER REFERENCES tb_cursos(fd_curso),
  fd_aluno INTEGER REFERENCES tb_alunos(fd_aluno),
    
);


CREATE TABLE tb_usuarios (
  fd_funcionario INTEGER REFERENCES tb_funcionarios(fd_funcionario),
  fd_login VARCHAR(20) NOT NULL UNIQUE,
  fd_senha VARCHAR(12) NOT NULL,
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY (fd_funcionario)
);
--CRIAÇÃO DO USUÁRIO PADRÃO DO SISTEMA ------------------------------------------------
INSERT INTO tb_usuarios (fd_funcionario,fd_login,fd_senha,fd_status)
VALUES
(1,'ADMIN','ADMIN','A');
--FIM DA CRIAÇÃO DO USUARIO PADRÃO ----------------------------------------------------

CREATE TABLE tb_mensalidades (
  fd_matricula INTEGER UNIQUE REFERENCES tb_matriculados(fd_matricula),
  fd_curso INTEGER REFERENCES tb_cursos(fd_curso),
  fd_aluno INTEGER REFERENCES tb_alunos(fd_aluno),
  fd_vencimento DATE NOT NULL,
  fd_valor NUMERIC NOT NULL CHECK (fd_valor > 0),
  fd_status CHAR(1) NOT NULL CHECK (fd_status IN ('A','I','E')),
  fd_data_cadastro timestamp default current_timestamp,
  PRIMARY KEY (fd_matricula, fd_aluno)
);

CREATE TABLE tb_pagamentos (
  fd_pagamento SERIAL,
  fd_valor NUMERIC(14,6) NOT NULL CHECK (fd_valor > 0),
  fd_despesa INTEGER NOT NULL REFERENCES tb_despesas(fd_despesa),
  fd_observacao VARCHAR(200) NULL,
  fd_data_pag DATE NOT NULL,
  fd_usuario INTEGER NOT NULL REFERENCES tb_usuarios(fd_funcionario),
  fd_funcionario INTEGER NOT NULL  REFERENCES tb_funcionarios(fd_funcionario),
  PRIMARY KEY(fd_pagamento, fd_despesa, fd_funcionario)
);

CREATE TABLE tb_saldos (
  fd_item  INTEGER REFERENCES tb_itens(fd_item),
  fd_saldo INTEGER NOT NULL,
  fd_data_atualizada DATE NOT NULL,
  PRIMARY KEY(fd_item)
  
);

CREATE TABLE tb_vendas (
  fd_venda SERIAL,
  fd_funcionario INTEGER NOT NULL REFERENCES tb_funcionarios(fd_funcionario),
  fd_aluno INTEGER NOT NULL REFERENCES tb_alunos(fd_aluno),
  fd_data DATE NOT NULL,
  fd_formapgto INTEGER NOT NULL REFERENCES tb_formas_pagamentos(fd_formapagto),
  PRIMARY KEY(fd_venda)
);

CREATE TABLE tb_vendas_itens (
  fd_venda INTEGER REFERENCES tb_vendas(fd_venda),
  fd_funcionario INTEGER NOT NULL REFERENCES tb_funcionarios(fd_funcionario),
  fd_item INTEGER NOT NULL REFERENCES tb_itens(fd_item),
  PRIMARY KEY(fd_venda, fd_funcionario, fd_item)
);



