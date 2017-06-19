--------- EX1

Create table Log_Aposta (

  IDLog_Aposta   integer not null,
  
  Usuario        varchar2(30),
  
  Data           date default sysdate,
  
  Operacao       char(1) not null,
  
  IDAposta       integer not null,
    constraint PK_LogAposta 
       primary key (IDLog_Aposta)
);


Create table Log_Numero_Aposta (
  IDLog_Numero_Aposta  integer not null,
  Usuario        varchar2(30),
  Data           date default sysdate,  
  Operacao       char(1) not null,
  IDNumeroAposta       integer not null,
    constraint PK_LogNumeroAposta 
       primary key (ID_Log_Numero_Aposta)
);

Create sequence sqLogAposta;

Create sequence sqLogNumeroAposta;






create or replace
trigger TR_AUD1_LOG_NUMERO_APOSTA
    after insert or update or delete on NUMERO_APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDNumero_Aposta number;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDNumero_Aposta := :new.IDNumero_Aposta;
  elsif UPDATING then
     v_operacao := 'U';  
     v_IDNumero_Aposta := :old.IDNumero_Aposta;     
  else
     v_operacao := 'D';
     v_IDNumero_Aposta := :old.IDNumero_Aposta;
  end if;
  Insert into Log_Numero_Aposta (IDLOG_NUMERO_APOSTA, data, usuario, operacao, IDNumeroAposta)
      values (sqLogAposta.nextval, sysdate, user, v_operacao, v_IDNumero_Aposta);

End TR_AUD1_LOG_NUMERO_APOSTA;





create or replace
trigger TR_AUD1_LOG_APOSTA
    after insert or update or delete on APOSTA
    for each row
Declare
  v_operacao char(1);
  v_IDAposta number;
Begin

  if INSERTING then
     v_operacao := 'I';
     v_IDAposta := :new.IDAposta;
  elsif UPDATING then
     v_operacao := 'U';
     v_IDAposta := :old.IDAposta;       
  else
     v_operacao := 'D';
     v_IDAposta := :old.IDAposta;
  end if;
  Insert into Log_Aposta (idlog_aposta, data, usuario, operacao, IDAposta)
      values (sqLogNumeroAposta.nextval, sysdate, user, v_operacao, v_IDAposta);

End TR_AUD1_LOG_APOSTA;




------ EX2


select count(*) as Quantia, cid.UF, IDConcurso
FROM APOSTA apo
INNER JOIN CIDADE cid on apo.IDCidade = cid.IDCidade
group by UF, IDConcurso
order by IDConcurso, Quantia desc;



select sum(Valor) as ValorTotal, cid.UF, IDConcurso
FROM APOSTA apo
INNER JOIN CIDADE cid on apo.IDCidade = cid.IDCidade
group by UF, IDConcurso
order by IDConcurso, ValorTotal desc;

select count(*) as TotalAcertadores, cid.UF , sum (apopre.Valor) as ValorPremiacao
from aposta_premiada apopre
inner join APOSTA apos on apopre.IDAPOSTA = apos.IDAPOSTA
inner join CIDADE cid on apos.IDCIDADE = cid.IDCIDADE
group by cid.UF
order by TotalAcertadores desc, ValorPremiacao desc;


-----  EX3


select logapo.IDAPOSTA, concur.IDConcurso, logapo.DATA ,concur.DATA_SORTEIO 
from log_aposta logapo
INNER JOIN aposta apo on apo.IDAPOSTA = logapo.IDAPOSTA
INNER JOIN Concurso concur on concur.IDConcurso = apo.IDConcurso
WHERE logapo.DATA > concur.DATA_SORTEIO
AND logapo.OPERACAO = 'I'
OR  logapo.OPERACAO = 'U'

UNION ALL


select  numapo.IDAPOSTA, concur.IDConcurso, lognumapo.DATA ,concur.DATA_SORTEIO 
from log_numero_aposta lognumapo
INNER JOIN NUMERO_APOSTA numapo on numapo.IDNUMERO_APOSTA = lognumapo.IDNUMEROAPOSTA
INNER JOIN aposta apo on apo.IDAPOSTA = numapo.IDAPOSTA
INNER JOIN Concurso concur on concur.IDConcurso = apo.IDConcurso
WHERE lognumapo.DATA > concur.DATA_SORTEIO
AND lognumapo.OPERACAO = 'I'
OR  lognumapo.OPERACAO = 'U';










