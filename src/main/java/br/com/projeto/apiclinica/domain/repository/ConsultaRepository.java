package br.com.projeto.apiclinica.domain.repository;

import br.com.projeto.apiclinica.domain.models.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
