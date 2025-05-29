package br.senai.sp.romvc.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O Nome deve ser informado")
    private String nome;


    @NotNull(message = "A data de nascimento deve ser informado")
    @DateTimeFormat(pattern = "ddMMyyyy")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date dataNascimento;
    // mascara não tá funcionando

    @NotEmpty(message = "O CPF deve ser informado")
    @CPF(message = "O CPF informado é inválido")
    private String cpf;

    @NotEmpty(message = "O telefone deve ser informado")
    // a de telefone tambem não tá funcionando

    private String telefone;

    @NotEmpty(message = "O e-mail deve ser informado")
    @Email(message = "O e-mail informado é inválido")
    private String email;

}
