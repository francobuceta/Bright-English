package com.nocountry.backend.dto;

import com.nocountry.backend.utils.enums.PaymentType;
import com.nocountry.backend.utils.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {

    private Long id;

    private PaymentType type;

    private Double amount;

    private String expiration;

    private PaymentStatus status;
}
