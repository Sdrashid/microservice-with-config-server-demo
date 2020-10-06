package microservicerdcalculator.rdcalculator;

import microservicerdcalculator.rdcalculator.beans.RDEntities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @Value("${interestRate}")
    float interestRate;

    @GetMapping("/rdCalculator/amount/{amount}/years/{years}")
    public String getMaturityAmount(@PathVariable long amount, @PathVariable int years){
        RDEntities obj = new RDEntities(amount,years,interestRate);
        return "Maturity amount would be: "+obj.getMaturityAmount();
    }
}
