package com.yassine.lafryhi.jee.seance5.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20, name = "role_name", unique = true)
    private String roleName;
    @Column(name = "description", length = 50)
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "users_roles")
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ToString.Exclude
    private List<User> users = new ArrayList<>();
}
