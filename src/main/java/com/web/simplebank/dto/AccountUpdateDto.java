package com.web.simplebank.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountUpdateDto {
    @NotEmpty
    private long phoneNumber;
    @NotNull
    private String idNumber;
}
