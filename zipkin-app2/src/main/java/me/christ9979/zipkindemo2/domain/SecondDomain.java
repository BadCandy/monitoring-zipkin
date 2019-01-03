package me.christ9979.zipkindemo2.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString   // dependency가 있는 필드는 exclude 시키자.
@Entity
public class SecondDomain {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
}
