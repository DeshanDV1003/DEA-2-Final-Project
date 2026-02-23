package com.inventory.inventory_base.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "asset")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Asset extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; [cite: 296]

    @Column(nullable = false)
    private String name; [cite: 300]

    @Column(unique = true, nullable = false)
    private String assetTag; [cite: 301]

    private LocalDate purchaseDate; [cite: 302]

    private String warranty; [cite: 304]

    private String status; [cite: 305]


    private Long companyId;
    private Long departmentId;
    private Long warehouseId;
}
