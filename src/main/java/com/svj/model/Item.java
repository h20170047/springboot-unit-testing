package com.svj.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TBL_Item")
public class Item {
    @Id
    private String name;
    private int id;
    private double price;
    private int quantity;

    @Transient
    private double value;
}
