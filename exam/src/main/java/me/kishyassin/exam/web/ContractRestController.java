package me.kishyassin.exam.web;

import lombok.AllArgsConstructor;
import me.kishyassin.exam.dtos.*;
import me.kishyassin.exam.services.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@AllArgsConstructor
@CrossOrigin("*")
public class ContractRestController {
    private InsuranceService insuranceService;

    @GetMapping
    public List<InsuranceContractDTO> contracts() {
        return insuranceService.listContracts();
    }

    @GetMapping("/client/{clientId}")
    public List<InsuranceContractDTO> getClientContracts(@PathVariable Long clientId) {
        return insuranceService.getClientContracts(clientId);
    }

    @PostMapping("/auto/{clientId}")
    public AutoInsuranceContractDTO saveAutoContract(@RequestBody AutoInsuranceContractDTO dto, @PathVariable Long clientId) {
        return insuranceService.saveAutoContract(dto, clientId);
    }

    @PostMapping("/home/{clientId}")
    public HomeInsuranceContractDTO saveHomeContract(@RequestBody HomeInsuranceContractDTO dto, @PathVariable Long clientId) {
        return insuranceService.saveHomeContract(dto, clientId);
    }

    @PostMapping("/health/{clientId}")
    public HealthInsuranceContractDTO saveHealthContract(@RequestBody HealthInsuranceContractDTO dto, @PathVariable Long clientId) {
        return insuranceService.saveHealthContract(dto, clientId);
    }

    @GetMapping("/{contractId}/payments")
    public List<PaymentDTO> getPayments(@PathVariable Long contractId) {
        return insuranceService.getContractPayments(contractId);
    }

    @PostMapping("/{contractId}/payments")
    public PaymentDTO savePayment(@RequestBody PaymentDTO paymentDTO, @PathVariable Long contractId) {
        return insuranceService.savePayment(paymentDTO, contractId);
    }
}
