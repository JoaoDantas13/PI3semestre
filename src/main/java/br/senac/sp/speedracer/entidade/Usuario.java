package br.senac.sp.speedracer.entidade;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Vinicius-Hilário
 */

@Getter
@Setter

public class Usuario {
    
    private final String PGerente = "Gerente";
    
    private String nome;
    private String login;
    private String senha;
    private String perfil;
    private int filial;
    
    public boolean isGerente(){
        
        return perfil.equalsIgnoreCase(PGerente);
        
    }
}
