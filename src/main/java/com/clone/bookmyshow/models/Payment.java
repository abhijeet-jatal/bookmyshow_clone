package com.clone.bookmyshow.models;

import com.clone.bookmyshow.enums.PaymentMode;
import com.clone.bookmyshow.enums.PaymentProvider;
import com.clone.bookmyshow.enums.PaymentStatus;
import lombok.Data;

@Data
public class Payment extends BaseModel{
    private int amount;
    private String referenceNumber;
    private PaymentMode paymentMode;
    private PaymentProvider paymentProvider;
    private PaymentStatus paymentStatus;
}
