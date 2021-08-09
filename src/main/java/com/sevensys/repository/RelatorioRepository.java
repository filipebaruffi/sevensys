package com.sevensys.repository;

import com.sevensys.model.Relatorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;


@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio,Long> {


    @Procedure("pkg_relatorio_teste.sp_atualiza_relatorio_geral")
    Relatorio atualizaRelatorio();

    Relatorio findByidConta(int idConta);
}

