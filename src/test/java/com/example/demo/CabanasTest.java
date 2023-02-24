package com.example.demo;

import com.example.demo.modelo.Cabana;
import com.example.demo.services.CabanasService;
import com.example.demo.services.NinoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CabanasTest {
    @Autowired
    CabanasService cabanasService;
    @Autowired
    NinoService ninoService;

    @Test
    void test(){
        Optional<List<Cabana>> all = cabanasService.getAll();
        boolean filter = true;
        assert all.isPresent();
        List<Cabana> cabanas = all.get();
        List<Cabana> cabanas1 = cabanas.stream().filter((cabans) -> cabans.isClimatizada() == filter).toList();
        Optional<List<Cabana>> cabanasByClimatizion = cabanasService.getCabanasByClimatizion(filter);
       cabanasByClimatizion.ifPresent((lista)->{
            assertEquals(cabanas1.size(), lista.size());
        });
    }
    @Test
    void testChildrenBetween5And12YearsOld(){
        int younger=5,older=12;
        ninoService.getByEdadBetween(younger,older);
    }
}
