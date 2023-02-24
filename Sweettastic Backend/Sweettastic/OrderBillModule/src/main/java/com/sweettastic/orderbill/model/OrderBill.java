package com.sweettastic.orderbill.model;

import com.sweettastic.sweetorder.model.SweetOrder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private LocalDate orderBill;

    private Float totalCost;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="ORDERBILLID")
    private List<SweetOrder> sweetOrderList=new ArrayList<>();


}
