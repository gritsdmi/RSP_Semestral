package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.LocalAttraction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class LocalAttractionServiceTest {

    @Autowired
    public LocalAttractionService localAttractionService;

    @Autowired
    public DestinationService destinationService;

    @Test
    public void addLocalAttractionTest() {
        LocalAttraction localAttraction = Generator.generateLocalAttraction();
        assertNotNull(localAttractionService.save(localAttraction));

        localAttraction = Generator.generateLocalAttraction();
        Destination destination = Generator.generateDestination();
        assertNotNull(localAttractionService.addLocalAttraction(localAttraction, destination));

        localAttraction = Generator.generateLocalAttraction();
        destination = destinationService.save(destination);
        assertNotNull(localAttractionService.addLocalAttraction(localAttraction, destination.getId()));

    }

    @Test
    public void getLocalAttractionTest() {
        LocalAttraction localAttraction = Generator.generateLocalAttraction();
        localAttractionService.save(localAttraction);

        assertEquals(localAttraction, localAttractionService.findLocalAttraction(localAttraction.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeLocalAttractionTest() {
        LocalAttraction localAttraction = Generator.generateLocalAttraction();
        localAttractionService.save(localAttraction);

        localAttractionService.remove(localAttraction);

        localAttractionService.findLocalAttraction(localAttraction.getId());
    }
}
