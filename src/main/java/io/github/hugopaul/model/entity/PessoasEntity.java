package io.github.hugopaul.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O campo NOME é obrigatório.")
    private String nome;

    @Column(name = "guerra", nullable = false, length = 50)
    @NotEmpty(message = "O campo NOME DE GUERRA é obrigatório." )
    private String guerra;

    @Column(nullable = false, length = 14)
    @NotEmpty(message = "O campo IDENTIDADE MILITAR é obrigatório.")
    private String idtMil;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "O campo SEÇÃO é obrigatório.")
    private String secao;

    @Column(length = 20)
    private String telefone;

    @Column( length = 4)
    private Integer ramal;

    @Column(name= "data_cadastro", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCadastro;

    @PrePersist
    public void prePersist() {
        setDataCadastro(LocalDate.now());
    }
}
