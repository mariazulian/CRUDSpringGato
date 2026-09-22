package com.frajola.cadastro_gato.infrastructure.entitys;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "gato")
@Entity

public class Gato {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "idade")
    private Integer idade;

    @Column(name = "raça")
    private String raca;

    @Column(name = "pelagem")
    private String pelagem;

    @Column(name = "sexo")
    private String sexo;
}
