package kata.eight.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {

    @Id
    @Column
    private Integer id;
    @Column
    private String lastName;
    @Column
    private String firstName;
    @Column
    private Integer age;
    @Column
    private String email;
}
