package hu.test.dynamic.dynamictables.domain2;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long id;
    String name;
}
