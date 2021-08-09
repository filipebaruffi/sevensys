package com.sevensys.service;
import com.sevensys.model.RelatorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Service
public class RelatorioService {

    @Autowired
    EntityManager entityManager;

    public void atualizaRelatorio() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("{call pkg_relatorio_teste.sp_atualiza_relatorio_geral}");
        query.execute();
    }

    public List<RelatorioEmpresa> receitaEmpresa() {
        Query sql = entityManager.createNativeQuery(
                "select ID_CLIENTE, RECEITA, DT_ABERTURA, VALOR_MOVIMENTACAO" +
                " from (select cli.id id_cliente," +
                "               case" +
                "                 when count(1) < 10 then" +
                "                  to_char(count(1) * 1.00, 'FM999G999G990D00')" +
                "                 when count(1) >= 10 and count(1) <= 20 then" +
                "                  to_char(count(1) * 0.75, 'FM999G999G990D00')" +
                "                 when count(1) > 20 then" +
                "                  to_char(count(1) * 0.50, 'FM999G999G990D00')" +
                "               end receita," +
                "               dt_abertura," +
                "               to_char(sum(mov.vr_movi), 'FM999G999G990D00') valor_movimentacao" +
                "          from cliente cli" +
                "          join conta conta" +
                "            on conta.id_cliente = cli.id" +
                "          join movimentacao mov" +
                "            on mov.id_conta = conta.id" +
                "         where to_char(conta.dt_abertura, 'DD') = to_char(sysdate, 'DD')" +
                "           and trunc(mov.dt_movimentacao) >= trunc(add_months(sysdate, -1))" +
                "           and trunc(mov.dt_movimentacao) < trunc(sysdate)" +
                "         group by cli.id, dt_abertura)", RelatorioEmpresa.class);

        List<RelatorioEmpresa> x = sql.getResultList();
        return sql.getResultList();
    }
}
