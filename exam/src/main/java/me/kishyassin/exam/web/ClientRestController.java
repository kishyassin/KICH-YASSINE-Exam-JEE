package me.kishyassin.exam.web;

import lombok.AllArgsConstructor;
import me.kishyassin.exam.dtos.ClientDTO;
import me.kishyassin.exam.services.InsuranceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@AllArgsConstructor
@CrossOrigin("*")
public class ClientRestController {
    private InsuranceService insuranceService;

    @GetMapping
    public List<ClientDTO> clients() {
        return insuranceService.listClients();
    }

    @GetMapping("/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return insuranceService.getClient(id);
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO clientDTO) {
        return insuranceService.saveClient(clientDTO);
    }
}
