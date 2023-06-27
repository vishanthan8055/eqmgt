package com.dedalus.eqpmgmt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.dedalus.eqpmgmt.controller.EquipementRestController;

@SpringBootTest
class EquipmentMgmtApplicationTests {

	@InjectMocks

    private EquipementRestController erc;

    @BeforeEach

    public void setUp() {

        MockitoAnnotations.openMocks(this);

    }

    @Test

    public void testHello() {

        String result= EquipementRestController.sayhi();

        assertEquals("Hello👋👋",result);   

    }

}
