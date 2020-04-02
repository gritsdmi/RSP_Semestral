package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.model.Incident;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/incident")
public class IncidentController {

    private final IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(path = "find/{id}", produces = "application/json")
    public Incident find(@PathVariable("id") Integer id) {
        return incidentService.findIncident(id);
    }

    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public Incident save(@RequestBody Incident incident) {
        return incidentService.save(incident);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Incident add(@RequestBody Incident incident, @RequestBody User user) {
        return incidentService.addIncident(incident, user);
    }

    @PostMapping(path = "/add/{userId}", consumes = "application/json", produces = "application/json")
    public Incident add(@RequestBody Incident incident, @PathVariable("userId") Integer userId) {
        return incidentService.addIncident(incident, userId);
    }

    @PostMapping(path = "/update/{incidentId}", consumes = "application/json", produces = "application/json")
    public Incident update(@RequestBody Incident incident, @PathVariable("incidentId") Integer incidentId) {
        return incidentService.updateIncident(incident, incidentId);
    }

    /* ============ */
    /* PUT REQUESTS */
    /* ============ */

    @PutMapping(path = "/add/{incidentId}/{userId}", produces = "application/json")
    public Incident add(@PathVariable("incidentId") Integer incidentId, @PathVariable("userId") Integer userId) {
        return incidentService.addIncident(incidentId, userId);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        incidentService.remove(id);
    }

    @DeleteMapping(path = "/remove", consumes = "application/json")
    public void remove(@RequestBody Incident incident) {
        incidentService.remove(incident);
    }
}
