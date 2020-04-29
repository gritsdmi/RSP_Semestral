package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.Generator;
import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Incident;
import cz.cvut.fel.rsp.tripguide.model.User;
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
public class IncidentServiceTest {

    @Autowired
    public IncidentService incidentService;

    @Autowired
    public UserService userService;

    @Test
    public void addIncidentTest() {
        Incident incident = Generator.generateIncident();
        assertNotNull(incidentService.save(incident));

        User user = userService.save(Generator.generateUser());
        incident = Generator.generateIncident();
        assertNotNull(incidentService.addIncident(incident, user));

        incident = Generator.generateIncident();
        user = userService.save(Generator.generateUser());
        assertNotNull(incidentService.addIncident(incident, user.getId()));

        incident = incidentService.save(Generator.generateIncident());
        user = userService.save(Generator.generateUser());

        assertNotNull(incidentService.addIncident(incident.getId(), user.getId()));

    }

    @Test
    public void getIncidentTest() {
        Incident incident = Generator.generateIncident();
        incidentService.save(incident);

        assertEquals(incident, incidentService.findIncident(incident.getId()));
    }

    @Test(expected = NotFoundException.class)
    public void removeIncidentTest() {
        Incident incident = Generator.generateIncident();
        incidentService.save(incident);

        incidentService.remove(incident);

        incidentService.findIncident(incident.getId());
    }
}
