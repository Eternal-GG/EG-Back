package me.powerarc.eternalgg.game;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter @Builder
@Entity @NoArgsConstructor @AllArgsConstructor
public class Equipment {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private long zero;

    @Column(nullable = false)
    private long one;

    @Column(nullable = false)
    private long two;

    @Column(nullable = false)
    private long three;

    @Column(nullable = false)
    private long four;

    @Column(nullable = false)
    private long five;
}
