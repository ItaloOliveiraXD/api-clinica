package br.com.projeto.apiclinica.domain.models;

import br.com.projeto.apiclinica.api.dto.medico.AtualizacaoDeMedicoDto;
import br.com.projeto.apiclinica.api.dto.medico.MedicoDto;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Medico")
@Table(name = "medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nome;
    
    private String email;
    
    private String telefone;
    
    private String crm;
    
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;

    public Medico(MedicoDto medicoDto) {

        this.nome = medicoDto.nome();
        this.email = medicoDto.email();
        this.telefone = medicoDto.telefone();
        this.crm = medicoDto.crm();
        this.especialidade = Especialidade.valueOf(medicoDto.especialidade());
        this.endereco = new Endereco(medicoDto.endereco());
    }

    public void atualizarMedico(AtualizacaoDeMedicoDto medicoDto) {

        if (medicoDto.nome() != null) {
            this.nome = medicoDto.nome();
        }
        if (medicoDto.email() != null) {
            this.email = medicoDto.email();
        }
        if (medicoDto.telefone() != null) {
            this.telefone = medicoDto.telefone();
        }
        if (medicoDto.endereco() != null) {
            this.endereco = new Endereco(medicoDto.endereco());
        }
    }
}
