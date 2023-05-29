package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.factory.OperationFactory;
import by.tms.service.CalculatorOperation;
import by.tms.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/calc")
public class OperationController {
    @Autowired
    private final CalculatorService calculatorService = CalculatorService.getInstance();

    @GetMapping
    public String calc(){
        return "calc";
    }
    @PostMapping
    public String calc(Operation operation, Model model){
        Optional<CalculatorOperation> operation1 = OperationFactory.createOperation(operation);
        if (operation1.isPresent()){
            double result = calculatorService.calculate(operation1.get()).get().getResult();
            model.addAttribute("result", result);
            return "calc";
        } else {
            model.addAttribute("error");
            return "calc";
        }
    }
}
