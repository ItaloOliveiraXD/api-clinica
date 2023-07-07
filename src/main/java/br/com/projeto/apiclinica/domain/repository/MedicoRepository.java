package br.com.projeto.apiclinica.domain.repository;

import br.com.projeto.apiclinica.domain.models.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.projeto.apiclinica.domain.models.Medico;

import java.time.LocalDateTime;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

    boolean existsByCrm(String crm);

    boolean existsByEmail(String email);

    @Query("""
            select m from Medico m
            where
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c 
                where
                c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico ecolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);
}
