package com.example.base_repo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDTOTest {

    public static final String TEST = "Test";
    private UserDTO userConstructorDTO;
    private UserDTO emptyUserDTO;

    @BeforeEach
    public void init() {
        userConstructorDTO = new UserDTO(1, TEST);
        emptyUserDTO = new UserDTO();
    }

    @Test
    public void testEquals() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName(TEST);
        Assertions.assertEquals(userDTO, userConstructorDTO);
    }

    @Test
    public void testNotEquals() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1);
        userDTO.setName("Test1");
        Assertions.assertNotEquals(userDTO, userConstructorDTO);
    }

    @Test
    public void testNotNull() {
        Assertions.assertNotNull(userConstructorDTO);
    }

    @Test
    public void testRequairedField() {
        Assertions.assertNotNull(userConstructorDTO);
        Assertions.assertEquals(1, userConstructorDTO.getId());
        Assertions.assertEquals("Test", userConstructorDTO.getName());
    }

    @Test
    public void testSetId() {
        emptyUserDTO.setId(1);
        emptyUserDTO.setName(TEST);
        Assertions.assertNotNull(emptyUserDTO);
        Assertions.assertEquals(1, emptyUserDTO.getId());
        Assertions.assertEquals(TEST, emptyUserDTO.getName());
    }
    

}