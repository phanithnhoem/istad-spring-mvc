package com.istad.demo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Supplier {
    private Integer id;
    private String company;
    private LocalDate since;
    private Boolean status;
}
