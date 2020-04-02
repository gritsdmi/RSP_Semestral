package cz.cvut.fel.rsp.tripguide.service;

import cz.cvut.fel.rsp.tripguide.exception.NotFoundException;
import cz.cvut.fel.rsp.tripguide.model.Incident;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IncidentService {
    private final IncidentRepository incidentRepository;

    private final UserService userService;

    @Autowired
    public IncidentService(IncidentRepository incidentRepository, UserService userService) {
        this.incidentRepository = incidentRepository;
        this.userService = userService;
    }

    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    public Incident findIncident(Integer id) {
        Optional<Incident> incident = incidentRepository.findById(id);
        if(!incident.isPresent()) {
            throw new NotFoundException("Incident not found! ID: " + id);
        }
        return incident.get();
    }

    public void remove(Incident incident) {
        this.incidentRepository.delete(incident);
    }

    public void remove(Integer id) {
        this.incidentRepository.deleteById(id);
    }

    public Incident addIncident(Incident incident, User user) {
        incident.setTourist(user);
        incident = save(incident);
        return incident;
    }

    public Incident addIncident(Incident incident, Integer userId) {
        User user = userService.findUser(userId);
        incident.setTourist(user);
        incident = incidentRepository.save(incident);
        return incident;
    }

    public Incident addIncident(Integer incidentId, Integer userId) {
        Incident incident = findIncident(incidentId);
        User user = userService.findUser(userId);
        incident.setTourist(user);
        incident = save(incident);
        return incident;
    }

    public Incident updateIncident(Incident incident, Integer incidentId) {
        Incident incidentToUpdate = findIncident(incidentId);
        if(incident.getDescription() != null && !incident.getDescription().isEmpty()) {
            incidentToUpdate.setDescription(incident.getDescription());
        }
        if(incident.getTourist() != null) {
            incidentToUpdate.setTourist(incident.getTourist());
        }
        incidentToUpdate = save(incidentToUpdate);
        return incidentToUpdate;
    }

}
