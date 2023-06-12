package by.tms.service;

import by.tms.dao.HibernateOperationDao;
import by.tms.dao.HibernateUserDao;
import by.tms.dto.OperationDto;
import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.factory.OperationFactory;
import by.tms.mapper.OperationDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CalculatorService {
    @Autowired
    private HibernateOperationDao hibernateOperationDao;
    @Autowired
    private HibernateUserDao hibernateUserDao;
    public Optional<Operation> calculate(OperationDto operationDto) {

        Operation operation = OperationDTOMapper.operationDtoToOperation(operationDto);
        User user = hibernateUserDao.findById(operationDto.getUserId());
        operation.setUser(user);

        Optional<CalculatorOperation> optionalCalculatorOperation = OperationFactory.createOperation(operation);

        if (optionalCalculatorOperation.isPresent()) {

            CalculatorOperation calculatorOperation = optionalCalculatorOperation.get();
            calculatorOperation.process();
            if (operation.getUser() != null){
               hibernateOperationDao.save(operation);
            }
            return Optional.of(calculatorOperation.getFinalResult());

        }
        return Optional.empty();
    }
}
