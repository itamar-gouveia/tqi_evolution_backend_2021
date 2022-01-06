package com.tqi.loan.service;

import com.tqi.loan.exception.BadRequestException;
import com.tqi.loan.models.Client;
import com.tqi.loan.repository.ClientRepository;
import com.tqi.loan.requests.ClientPostRequestBody;
import com.tqi.loan.requests.ClientPutRequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

        private final ClientRepository clientRepository;

        public Page<Client> listAll(Pageable pageable){
            return clientRepository.findAll(pageable);
        }

        public Client findById(long id){
            return clientRepository.findById(id)
                    .orElseThrow(()-> new BadRequestException("Client not Found"));
        }


        public Client save(ClientPostRequestBody clientPostRequestBody){
            Client client =  Client.builder()
                    .city(clientPostRequestBody.getName())
                    .cpf(clientPostRequestBody.getCpf())
                    .distric(clientPostRequestBody.getDistric())
                    .email(clientPostRequestBody.getEmail())
                    .income(clientPostRequestBody.getIncome())
                    .name(clientPostRequestBody.getName())
                    .number(clientPostRequestBody.getNumber())
                    .password(clientPostRequestBody.getPassword())
                    .registerDate(clientPostRequestBody.getRegisterDate())
                    .rg(clientPostRequestBody.getRg())
                    .state(clientPostRequestBody.getState())
                    .street(clientPostRequestBody.getStreet())
                    .zipCode(clientPostRequestBody.getZipCode())
                    .build();
            return clientRepository.save(client);

        }

        public void delete(long id){
            clientRepository.delete(findById(id));
        }

        public void update(ClientPutRequestBody clientPutRequestBody){
            Client client =  Client.builder()
                    .id(clientPutRequestBody.getId())
                    .city(clientPutRequestBody.getName())
                    .cpf(clientPutRequestBody.getCpf())
                    .distric(clientPutRequestBody.getDistric())
                    .email(clientPutRequestBody.getEmail())
                    .income(clientPutRequestBody.getIncome())
                    .name(clientPutRequestBody.getName())
                    .number(clientPutRequestBody.getNumber())
                    .password(clientPutRequestBody.getPassword())
                    .registerDate(clientPutRequestBody.getRegisterDate())
                    .rg(clientPutRequestBody.getRg())
                    .state(clientPutRequestBody.getState())
                    .street(clientPutRequestBody.getStreet())
                    .zipCode(clientPutRequestBody.getZipCode())
                    .build();
            clientRepository.save(client);
        }

}
