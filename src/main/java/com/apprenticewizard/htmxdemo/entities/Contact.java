package com.apprenticewizard.htmxdemo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.READ_ONLY;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Contact {

    @Id
    @Column(name = "id")
    @GeneratedValue
    @JsonProperty(access = READ_ONLY)
    private Long id;

    @NotNull
    @Column(name = "full_name")
    @Length(min = 2, max = 50)
    private String fullName;

    @Email
    @NotNull
    @Length(max = 100)
    @Column(name = "email",  unique = true)
    private String email;

    @NotNull
    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;

    @Builder
    public Contact(String fullName, String email, LocalDate birthDate) {
        this.fullName = fullName;
        this.email = email;
        this.birthDate = birthDate;
    }
}
