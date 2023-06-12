package by.tms.mapper;

import by.tms.dto.OperationDto;
import by.tms.entity.Operation;
import by.tms.entity.OperationType;

public class OperationDTOMapper {
    public static Operation operationDtoToOperation(OperationDto operationDto){
        Operation operation = new Operation();
        operation.setNum1(Double.parseDouble(operationDto.getNum1()));
        operation.setNum2(Double.parseDouble(operationDto.getNum2()));
        operation.setType(OperationType.valueOf(operationDto.getType()));
        return operation;
    }
}
