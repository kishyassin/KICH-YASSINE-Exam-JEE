package me.kishyassin.exam.mappers;

import me.kishyassin.exam.dtos.*;
import me.kishyassin.exam.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InsuranceMapper {

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }

    public AutoInsuranceContractDTO fromAutoInsuranceContract(AutoInsuranceContract contract) {
        AutoInsuranceContractDTO dto = new AutoInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setType("AUTO");
        return dto;
    }

    public AutoInsuranceContract fromAutoInsuranceContractDTO(AutoInsuranceContractDTO dto) {
        AutoInsuranceContract contract = new AutoInsuranceContract();
        BeanUtils.copyProperties(dto, contract);
        return contract;
    }

    public HomeInsuranceContractDTO fromHomeInsuranceContract(HomeInsuranceContract contract) {
        HomeInsuranceContractDTO dto = new HomeInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setType("HOME");
        return dto;
    }

    public HomeInsuranceContract fromHomeInsuranceContractDTO(HomeInsuranceContractDTO dto) {
        HomeInsuranceContract contract = new HomeInsuranceContract();
        BeanUtils.copyProperties(dto, contract);
        return contract;
    }

    public HealthInsuranceContractDTO fromHealthInsuranceContract(HealthInsuranceContract contract) {
        HealthInsuranceContractDTO dto = new HealthInsuranceContractDTO();
        BeanUtils.copyProperties(contract, dto);
        dto.setType("HEALTH");
        return dto;
    }

    public HealthInsuranceContract fromHealthInsuranceContractDTO(HealthInsuranceContractDTO dto) {
        HealthInsuranceContract contract = new HealthInsuranceContract();
        BeanUtils.copyProperties(dto, contract);
        return contract;
    }

    public PaymentDTO fromPayment(Payment payment) {
        PaymentDTO dto = new PaymentDTO();
        BeanUtils.copyProperties(payment, dto);
        return dto;
    }

    public Payment fromPaymentDTO(PaymentDTO dto) {
        Payment payment = new Payment();
        BeanUtils.copyProperties(dto, payment);
        return payment;
    }
}
