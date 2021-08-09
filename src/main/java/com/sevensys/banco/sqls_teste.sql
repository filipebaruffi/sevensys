-- Create sequence 
create sequence SQ_TESTE
start with 1
increment by 1;

-- Create table
create table CLIENTE
(
  id              INTEGER default SQ_TESTE.NEXTVAL not null,
  nome            VARCHAR2(20),
  telefone        VARCHAR2(20),
  endereco        VARCHAR2(20),
  nr_doc          VARCHAR2(20),
  data_nascimento DATE,
  tipo_pessoa     VARCHAR2(20)
);

-- Create/Recreate primary, unique and foreign key constraints 
alter table CLIENTE
  add constraint PK_CLI_TESTE primary key (ID);



-- Create sequence 
create sequence SQ_TESTE_CONTA
start with 1
increment by 1;

-- Create table
create table CONTA
(id          INTEGER default SQ_TESTE_CONTA.NEXTVAL not null,
  id_cliente  INTEGER not null,
  empresa     VARCHAR2(20) not null,
  saldo       NUMBER,
  dt_abertura DATE default sysdate not null
);

alter table CONTA
  add constraint PK_ID_CONTA_TESTE primary key (ID)
  using index;
alter table CONTA
  add constraint FK_ID_CLI_TESTE foreign key (ID_CLIENTE)
  references CLIENTE (ID);

-- Create table

-- Create sequence 
create sequence SQ_TESTE_MOVI
start with 1
increment by 1;

create table MOVIMENTACAO
(
  id                INTEGER default SQ_TESTE_MOVI.NEXTVAL not null,
  id_conta          INTEGER,
  tipo_movimentacao VARCHAR2(10),
  vr_movi           NUMBER,
  dt_movimentacao   DATE
);
alter table MOVIMENTACAO
  add constraint PK_RELATORIO primary key (ID);
  
  
  
-- relatorio

-- Create sequence 
create sequence SQ_RELATORIO_TESTE
start with 1
increment by 1;


-- Create table
create table RELATORIO
(
  id                 INTEGER default SQ_RELATORIO_TESTE.NEXTVAL not null,
  id_cliente         INTEGER,
  id_conta           INTEGER,
  total_movimentacao NUMBER,
  tipo_movimentacao  VARCHAR2(10),
  mesano             VARCHAR2(7),
  qnt_movi           NUMBER
);
-- Create/Recreate primary, unique and foreign key constraints 
alter table RELATORIO
  add primary key (ID);
---- pkg e procedure

create or replace package PKG_RELATORIO_TESTE is

  procedure sp_atualiza_relatorio_geral;

end PKG_RELATORIO_TESTE;

create or replace package body PKG_RELATORIO_TESTE is

  procedure sp_atualiza_relatorio_geral is
  
  begin
  
    merge into relatorio rel
    using (select cli.id,
                  mov.id_conta,
                  sum(vr_movi) total_movimentacao,
                  tipo_movimentacao,
                  to_char(dt_movimentacao, 'MM/RRRR') mesano,
                  count(1) qnt_movi
             from conta cont
             join cliente cli
               on cli.id = cont.id_cliente
            inner join movimentacao mov
               on cont.id = mov.id_conta
           
            group by tipo_movimentacao,
                     dt_movimentacao,
                     mov.id_conta,
                     dt_movimentacao,
                     cli.telefone,
                     cli.endereco,
                     cli.id) cli
    on (cli.id_conta = rel.id_conta)
    when matched then
      update
         set rel.total_movimentacao = cli.total_movimentacao,
             rel.tipo_movimentacao  = cli.tipo_movimentacao,
             rel.mesano             = cli.mesano,
             rel.qnt_movi           = cli.qnt_movi
    when not matched then
      insert
        (ID_CLIENTE,
         ID_CONTA,
         TOTAL_MOVIMENTACAO,
         TIPO_MOVIMENTACAO,
         MESANO,
         QNT_MOVI)
      values
        (cli.id,
         cli.id_Conta,
         cli.total_movimentacao,
         cli.tipo_movimentacao,
         cli.mesano,
         cli.qnt_movi);
    commit;
  end;

end PKG_RELATORIO_TESTE;

  

