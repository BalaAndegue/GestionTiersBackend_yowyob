package com.backend.yowyob.dtos;


import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClientDTO extends TiersBaseDTO {
    private String segment;
    private BigDecimal plafondCredit;
    private String canalAquisition;
}

