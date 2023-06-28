package br.com.projeto.apiclinica.infra.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CamposErros {
    
    private String campo;
    private String mensagem;
}
