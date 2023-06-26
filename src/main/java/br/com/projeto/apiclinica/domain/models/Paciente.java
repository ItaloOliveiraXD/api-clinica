package br.com.projeto.apiclinica.domain.models;

import br.com.projeto.apiclinica.api.dto.paciente.PacienteDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Paciente")
@Table(name = "pacientes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    
    @Embedded
    private Endereco endereco; 

    public Paciente(PacienteDto pacienteDto) {

        this.nome = pacienteDto.nome();
        this.telefone = pacienteDto.telefone();
        this.email = pacienteDto.email();
        this.cpf = pacienteDto.cpf();
        this.endereco = new Endereco(pacienteDto.endereco());
    }
}
