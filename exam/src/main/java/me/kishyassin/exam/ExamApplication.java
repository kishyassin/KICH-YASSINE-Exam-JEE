package me.kishyassin.exam;

import me.kishyassin.exam.entities.*;
import me.kishyassin.exam.repositories.ClientRepository;
import me.kishyassin.exam.repositories.InsuranceContractRepository;
import me.kishyassin.exam.repositories.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Bean
	CommandLineRunner start(ClientRepository clientRepository,
						   InsuranceContractRepository contractRepository,
						   PaymentRepository paymentRepository) {
		return args -> {
			// Create Clients
			Client client1 = Client.builder().nom("Yassin").email("kishyassin@gmail.com").build();
			Client client2 = Client.builder().nom("Amine").email("amine@gmail.com").build();
			clientRepository.save(client1);
			clientRepository.save(client2);

			// Create Auto Contract
			AutoInsuranceContract auto = new AutoInsuranceContract();
			auto.setClient(client1);
			auto.setSubscriptionDate(new Date());
			auto.setStatus(ContractStatus.VALIDE);
			auto.setContributionAmount(5000);
			auto.setDuration(12);
			auto.setCoverageRate(0.8);
			auto.setRegistrationNumber("123-A-56");
			auto.setBrand("Toyota");
			auto.setModel("Yaris");
			contractRepository.save(auto);

			HomeInsuranceContract home = new HomeInsuranceContract();
			home.setClient(client2);
			home.setSubscriptionDate(new Date());
			home.setStatus(ContractStatus.EN_COURS);
			home.setContributionAmount(3000);
			home.setDuration(24);
			home.setCoverageRate(0.9);
			home.setHousingType(HousingType.APPARTEMENT);
			home.setAddress("Casablanca, Maarif");
			home.setArea(85.5);
			contractRepository.save(home);

			Payment p1 = Payment.builder()
					.date(new Date())
					.amount(1000)
					.type(PaymentType.MENSUALITE)
					.contract(auto)
					.build();
			paymentRepository.save(p1);
		};
	}
}
