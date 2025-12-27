package com.backend.yowyob.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "app_business_settings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppBusinessSettings {

    @Id
    @Column(name = "tenant_id", nullable = false)
    private String tenantId;

    @Column(name = "app_options_id")
    private UUID appOptionsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organization_id", nullable = false)
    private Tenant organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_agency_id")
    private Agency agency;

    // Pricing & sales
    @Column(name = "negotiate_selling_price")
    private Boolean negotiateSellingPrice;

    @Column(name = "selling_price_include_vat")
    private Boolean sellingPriceIncludeVat;

    @Column(name = "authorize_exceptional_discount")
    private Boolean authorizeExceptionalDiscount;

    @Column(name = "grantable_discount_rate")
    private Float grantableDiscountRate;

    // Printing
    @Column(name = "is_print_logo")
    private Boolean isPrintLogo;

    @Column(name = "is_print_rc")
    private Boolean isPrintRc;

    @Column(name = "is_print_rcc")
    private Boolean isPrintRcc;

    @Column(name = "paper_format", columnDefinition = "TEXT")
    private String paperFormat;

    @Column(name = "orientation")
    private Short orientation;

    // Invoice numbering
    @Column(name = "length_of_vat_invoice_number")
    private Short lengthOfVatInvoiceNumber;

    @Column(name = "prefix_of_vat_invoice_number", columnDefinition = "TEXT")
    private String prefixOfVatInvoiceNumber;

    @Column(name = "suffix_of_vat_invoice_number", columnDefinition = "TEXT")
    private String suffixOfVatInvoiceNumber;

    // Cash register
    @Column(name = "cash_register_module")
    private Integer cashRegisterModule;

    @Column(name = "cash_register_auto_validation")
    private Integer cashRegisterAutoValidation;

    // Technician
    @Column(name = "technician_margin_rate")
    private Float technicianMarginRate;

    @Column(name = "authorize_technician_invoice")
    private Boolean authorizeTechnicianInvoice;

    // System
    @Column(name = "nb_of_decimal_digit")
    private Short nbOfDecimalDigit;

    @Column(name = "date_format", columnDefinition = "TEXT")
    private String dateFormat;

    @Column(name = "server_ip_address", columnDefinition = "TEXT")
    private String serverIpAddress;

    @Column(name = "real_time_sale_notification")
    private Boolean realTimeSaleNotification;

    @Column(name = "low_stock_alert")
    private Boolean lowStockAlert;

    @Column(name = "system_failure_notification")
    private Boolean systemFailureNotification;
}
