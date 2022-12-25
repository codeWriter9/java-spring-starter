package kata.eight.bean;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
