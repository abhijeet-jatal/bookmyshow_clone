package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.PaymentMode;
import com.clone.bookmyshow.enums.PaymentProvider;
import com.clone.bookmyshow.enums.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel{
    private int amount;
    private String referenceNumber;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMode paymentMode;
    @Enumerated(EnumType.ORDINAL)
    private PaymentProvider paymentProvider;
    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}