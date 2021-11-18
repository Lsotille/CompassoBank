package com.example.compassobank.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "gerente")
public class Gerente extends Banqueiro{

}
