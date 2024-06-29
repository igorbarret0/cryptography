package com.challenge.cryptography.service;

import com.challenge.cryptography.dtos.UserRequest;
import com.challenge.cryptography.dtos.UserResponse;
import com.challenge.cryptography.entity.User;
import com.challenge.cryptography.repository.UserRepository;
import org.springframework.stereotype.Service;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
public class UserService {

    private UserRepository userRepository;
    private CryptoService cryptoService;

    public UserService(UserRepository userRepository, CryptoService cryptoService) {
        this.userRepository = userRepository;
        this.cryptoService = cryptoService;
    }

    public UserResponse saveUser(UserRequest request) {

        String decodedUserDocument = cryptoService.decodeInfo(request.userDocument());
        String decodedCreditCardToken = cryptoService.decodeInfo(request.creditCardToken());

        UserRequest userRequest = new UserRequest(decodedUserDocument, decodedCreditCardToken, request.value());
        User user = userRequest.toEntity(userRequest);

        userRepository.save(user);

        return userRequest.toResponse(user.getId(), user.getValue());

    }

    public UserResponse updateUser(User updatedUser) {

       User user = userRepository.findById(updatedUser.getId())
               .orElseThrow(() -> new IllegalArgumentException("User not found"));

       if (updatedUser.getUserDocument() != null) {
           user.setUserDocument(cryptoService.decodeInfo(updatedUser.getUserDocument()));
       }

       if (updatedUser.getCreditCardToken() != null) {
           user.setCreditCardToken(cryptoService.decodeInfo(updatedUser.getCreditCardToken()));
       }

       if (updatedUser.getValue() != null) {
           user.setValue(updatedUser.getValue());
       }

       userRepository.save(user);

       return UserRequest.toResponse(user.getId(), user.getValue());


    }

    public UserResponse findById(Long id) {

        User userFound = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserRequest.toResponse(userFound.getId(), userFound.getValue());
    }

    public void deleteUser(Long id) {

       User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

       userRepository.delete(user);

    }

}
