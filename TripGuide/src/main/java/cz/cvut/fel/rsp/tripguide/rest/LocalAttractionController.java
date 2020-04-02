package cz.cvut.fel.rsp.tripguide.rest;

import cz.cvut.fel.rsp.tripguide.model.LocalAttraction;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.service.LocalAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/attraction")
public class LocalAttractionController {

    private final LocalAttractionService localAttractionService;

    @Autowired
    public LocalAttractionController(LocalAttractionService localAttractionService) {
        this.localAttractionService = localAttractionService;
    }

    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(path = "find/{id}", produces = "application/json")
    public LocalAttraction find(@PathVariable("id") Integer id) {
        return localAttractionService.findLocalAttraction(id);
    }

    /* ============= */
    /* POST REQUESTS */
    /* ============= */

    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public LocalAttraction save(@RequestBody LocalAttraction localAttraction) {
        return localAttractionService.save(localAttraction);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public LocalAttraction add(@RequestBody LocalAttraction localAttraction, @RequestBody Tour tour) {
        return localAttractionService.addLocalAttraction(localAttraction, tour);
    }

    @PostMapping(path = "/add/{tourId}", consumes = "application/json", produces = "application/json")
    public LocalAttraction add(@RequestBody LocalAttraction localAttraction, @PathVariable(name = "tourId") Integer tourId) {
        return localAttractionService.addLocalAttraction(localAttraction, tourId);
    }

    /* ============ */
    /* PUT REQUESTS */
    /* ============ */

    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    public LocalAttraction update(@RequestBody LocalAttraction localAttraction, @RequestParam(name = "attractionId") Integer id) {
        return localAttractionService.updateLocalAttraction(localAttraction, id);
    }

    @PutMapping(path = "/add/{attractionId}/{tourId}", produces = "application/json")
    public LocalAttraction add(@PathVariable("attractionId") Integer attractionId, @PathVariable("tourId") Integer tourId) {
        return localAttractionService.addLocalAttraction(attractionId, tourId);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(path = "/remove", consumes = "application/json")
    public void remove(@RequestBody LocalAttraction localAttraction) {
        localAttractionService.remove(localAttraction);
    }

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        localAttractionService.remove(id);
    }
}
