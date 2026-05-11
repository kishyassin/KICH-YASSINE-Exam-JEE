package me.kishyassin.exam.services;

import me.kishyassin.exam.dtos.*;
import java.util.List;

public interface InsuranceService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();
    ClientDTO getClient(Long id);

    AutoInsuranceContractDTO saveAutoContract(AutoInsuranceContractDTO dto, Long clientId);
    HomeInsuranceContractDTO saveHomeContract(HomeInsuranceContractDTO dto, Long clientId);
    HealthInsuranceContractDTO saveHealthContract(HealthInsuranceContractDTO dto, Long clientId);

    List<InsuranceContractDTO> listContracts();
    List<InsuranceContractDTO> getClientContracts(Long clientId);

    PaymentDTO savePayment(PaymentDTO paymentDTO, Long contractId);
    List<PaymentDTO> getContractPayments(Long contractId);
}
