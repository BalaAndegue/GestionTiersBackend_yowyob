package com.backend.yowyob.dtos;

import lombok.Data;
import java.util.UUID;

@Data
public class AppBusinessSettingsDTO {
    private String tenantId;
    private UUID appOptionsId;
    private UUID organizationId;
    private UUID orgAgencyId;
    private Boolean negotiateSellingPrice;
    private Boolean sellingPriceIncludeVat;
    private Boolean authorizeExceptionalDiscount;
    private Float grantableDiscountRate;
    private Boolean isPrintLogo;
    private Boolean isPrintRc;
    private Boolean isPrintRcc;
    private String paperFormat;
    private Short orientation;
    private Short lengthOfVatInvoiceNumber;
    private String prefixOfVatInvoiceNumber;
    private String suffixOfVatInvoiceNumber;
    private Integer cashRegisterModule;
    private Integer cashRegisterAutoValidation;
    private Float technicianMarginRate;
    private Boolean authorizeTechnicianInvoice;
    private Short nbOfDecimalDigit;
    private String dateFormat;
    private String serverIpAddress;
    private Boolean realTimeSaleNotification;
    private Boolean lowStockAlert;
    private Boolean systemFailureNotification;
}
