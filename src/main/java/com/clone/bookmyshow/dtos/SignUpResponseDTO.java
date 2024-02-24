package com.clone.bookmyshow.dtos;

import com.clone.bookmyshow.enums.ResponseStatus;
import lombok.Data;

@Data
public class SignUpResponseDTO {
    private ResponseStatus responseStatus;
    private Long userId;
}