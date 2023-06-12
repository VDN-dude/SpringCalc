package by.tms.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class OperationDto {

    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The num1 is not a number, try again")
    private String num1;

    @Pattern(regexp = "^\\d+\\.?\\d*", message = "The num2 is not a number, try again")
    private String num2;

    private String type;

    private long userId;
}
