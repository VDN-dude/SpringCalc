package by.tms.service;

import by.tms.entity.Operation;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CalculatorService {
    private static CalculatorService instance;

    private CalculatorService() {

    }

    public static CalculatorService getInstance() {
        if (instance == null) {
            instance = new CalculatorService();
        }
        return instance;
    }

    public Optional<Operation> calculate(CalculatorOperation operation) {
        operation.process();
        return Optional.ofNullable(operation.getFinalResult());
    }
}
