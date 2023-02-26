package com.sweettastic.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderBill {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderBillId;

    @NotNull
    private LocalDate orderBill;
     @NotNull
    private Float totalCost;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ORDERBILLID")
    private List<SweetOrder> sweetOrderList=new ArrayList<>();


    @Override
    public String toString() {
        return "OrderBill{" +
                "orderBillId=" + orderBillId +
                ", orderBill=" + orderBill +
                ", totalCost=" + totalCost +
                '}';
    }
}
