package br.com.projeto.apiclinica.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto.apiclinica.domain.models.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

    boolean existsByCrm(String crm);

    boolean existsByEmail(String email);
    
}
