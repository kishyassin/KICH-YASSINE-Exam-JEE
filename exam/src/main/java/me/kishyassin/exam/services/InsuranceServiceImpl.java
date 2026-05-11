package me.kishyassin.exam.services;

import lombok.AllArgsConstructor;
import me.kishyassin.exam.dtos.*;
import me.kishyassin.exam.entities.*;
import me.kishyassin.exam.mappers.InsuranceMapper;
import me.kishyassin.exam.repositories.ClientRepository;
import me.kishyassin.exam.repositories.InsuranceContractRepository;
import me.kishyassin.exam.repositories.PaymentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {
    private ClientRepository clientRepository;
    private InsuranceContractRepository contractRepository;
    private PaymentRepository paymentRepository;
    private InsuranceMapper mapper;

    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = mapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return mapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        return clientRepository.findAll().stream()
                .map(mapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));
        return mapper.fromClient(client);
    }

    @Override
    public AutoInsuranceContractDTO saveAutoContract(AutoInsuranceContractDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        AutoInsuranceContract contract = mapper.fromAutoInsuranceContractDTO(dto);
        contract.setClient(client);
        AutoInsuranceContract saved = contractRepository.save(contract);
        return mapper.fromAutoInsuranceContract(saved);
    }

    @Override
    public HomeInsuranceContractDTO saveHomeContract(HomeInsuranceContractDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        HomeInsuranceContract contract = mapper.fromHomeInsuranceContractDTO(dto);
        contract.setClient(client);
        HomeInsuranceContract saved = contractRepository.save(contract);
        return mapper.fromHomeInsuranceContract(saved);
    }

    @Override
    public HealthInsuranceContractDTO saveHealthContract(HealthInsuranceContractDTO dto, Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        HealthInsuranceContract contract = mapper.fromHealthInsuranceContractDTO(dto);
        contract.setClient(client);
        HealthInsuranceContract saved = contractRepository.save(contract);
        return mapper.fromHealthInsuranceContract(saved);
    }

    @Override
    public List<InsuranceContractDTO> listContracts() {
        return contractRepository.findAll().stream()
                .map(c -> {
                    if (c instanceof AutoInsuranceContract) return mapper.fromAutoInsuranceContract((AutoInsuranceContract) c);
                    if (c instanceof HomeInsuranceContract) return mapper.fromHomeInsuranceContract((HomeInsuranceContract) c);
                    if (c instanceof HealthInsuranceContract) return mapper.fromHealthInsuranceContract((HealthInsuranceContract) c);
                    return null;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<InsuranceContractDTO> getClientContracts(Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        return client.getContracts().stream()
                .map(c -> {
                    if (c instanceof AutoInsuranceContract) return mapper.fromAutoInsuranceContract((AutoInsuranceContract) c);
                    if (c instanceof HomeInsuranceContract) return mapper.fromHomeInsuranceContract((HomeInsuranceContract) c);
                    if (c instanceof HealthInsuranceContract) return mapper.fromHealthInsuranceContract((HealthInsuranceContract) c);
                    return null;
                })
                .collect(Collectors.toList());
    }

    @Override
    public PaymentDTO savePayment(PaymentDTO paymentDTO, Long contractId) {
        InsuranceContract contract = contractRepository.findById(contractId).orElseThrow(() -> new RuntimeException("Contract not found"));
        Payment payment = mapper.fromPaymentDTO(paymentDTO);
        payment.setContract(contract);
        Payment saved = paymentRepository.save(payment);
        return mapper.fromPayment(saved);
    }

    @Override
    public List<PaymentDTO> getContractPayments(Long contractId) {
        InsuranceContract contract = contractRepository.findById(contractId).orElseThrow(() -> new RuntimeException("Contract not found"));
        return contract.getPayments().stream()
                .map(mapper::fromPayment)
                .collect(Collectors.toList());
    }
}
