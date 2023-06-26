package br.com.projeto.apiclinica.domain.repository;

import br.com.projeto.apiclinica.domain.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
