package com.pocspringboot.model.request;

import com.pocspringboot.enumeration.Gender;
import com.pocspringboot.enumeration.Race;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCharacterBatchRequest {

    @NotBlank(message = "filePath is mandatory")
    private String filePath;

}
