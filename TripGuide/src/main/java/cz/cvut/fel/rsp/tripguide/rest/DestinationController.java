package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.model.Destination;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/destination", produces = MediaType.APPLICATION_JSON_VALUE)
public class DestinationController {

    private final DestinationService destinationService;

    @Autowired
    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(path = "/find/{id}", produces = "application/json")
    public Destination find(@PathVariable("id") String id) {
        System.err.println(id);
        Integer nid = Integer.parseInt(id);
        return destinationService.findDestination(nid);
    }

    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Destination add(@RequestBody Destination destination, @RequestBody Hotel hotel) {
        return destinationService.addDestination(destination, hotel);
    }

    /*im not sure if it's works*/
    @PostMapping(path = "/add/{hotelId}", consumes = "application/json", produces = "application/json")
    public Destination add(@RequestBody Destination destination, @PathVariable("hotelId") Integer hotelId) {
        return destinationService.addDestination(destination, hotelId);
    }

    /* ============ */
    /* PUT REQUESTS */
    /* ============ */

    @PutMapping(path = "/add/{destId}/{hotelId}", produces = "application/json")
    public Destination add(@PathVariable("destId") Integer destinationId, @PathVariable("hotelId") Integer hotelId) {
        return destinationService.addDestination(destinationId, hotelId);
    }

    /*im not sure id it's works*/
    @PutMapping(path = "/update/{destId}", consumes = "application/json", produces = "application/json")
    public Destination updateDestination(@RequestBody Destination destination, @PathVariable("destId") Integer destinationId) {
        return destinationService.updateDestination(destination, destinationId);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        destinationService.remove(id);
    }

    @DeleteMapping(path = "/remove")
    public void remove(@RequestBody Destination destination) {
        destinationService.remove(destination);
    }


}
