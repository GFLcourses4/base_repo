package com.example.base_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    @Test
    public void testEquals() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("Test");
        UserDTO userConstructorDTO = new UserDTO(1, "Test");
        System.out.println("Conflict");
        Assertions.assertEquals(userDTO, userConstructorDTO);
    }

}