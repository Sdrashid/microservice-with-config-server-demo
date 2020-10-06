package microservicefdcalculator.fdcalculator;

import microservicefdcalculator.fdcalculator.beans.FDEntities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class CalculatorController {

    @Value("${interestRate}")
    float interestRate;

    @GetMapping("/fdCalculator/amount/{amount}/years/{years}")
    public String getMaturityAmount(@PathVariable long amount, @PathVariable int years){
        FDEntities obj = new FDEntities(amount,years,interestRate);
        return "Maturity amount would be: "+obj.getMaturityAmount();
    }
}
