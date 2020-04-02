package cz.cvut.fel.rsp.tripguide.rest;

import antlr.collections.impl.IntRange;
import cz.cvut.fel.rsp.tripguide.model.Excursion;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.service.ExcursionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

@RestController
@RequestMapping(value = "/excursion")
public class ExcursionController {

    private final ExcursionService excursionService;

    @Autowired
    public ExcursionController(ExcursionService excursionService) {
        this.excursionService = excursionService;
    }


    /* ============ */
    /* GET REQUESTS */
    /* ============ */

    @GetMapping(path = "find/{id}", produces = "application/json")
    public Excursion find(@PathVariable("id") Integer id) {
        return excursionService.findExcursion(id);
    }

    /* ============= */
    /* POST REQUESTS */
    /* ============= */


    @PostMapping(path = "/save", consumes = "application/json", produces = "application/json")
    public Excursion save(@RequestBody Excursion excursion) {
        return excursionService.save(excursion);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public Excursion add(@RequestBody Excursion excursion, @RequestBody Tour tour) {
        return excursionService.addExcursion(excursion, tour);
    }

    @PostMapping(path = "/add/{id}", consumes = "application/json", produces = "application/json")
    public Excursion add(@RequestBody Excursion excursion, @PathVariable("id") Integer id) {
        return excursionService.addExcursion(excursion, id);
    }

    /* ============ */
    /* PUT REQUESTS */
    /* ============ */

    @PutMapping(path = "/add/{excursionId}/{tourId}", produces = "application/json")
    public Excursion add(@PathVariable("excursionId") Integer excursionId, @PathVariable("tourId") Integer tourId) {
        return excursionService.addExcursion(excursionId, tourId);
    }

    @PutMapping(path = "/update/{excursionId}", consumes = "application/json", produces = "application/json")
    public Excursion update(Excursion excursion, @PathVariable("excursionId") Integer id) {
        return excursionService.updateExcursion(excursion, id);
    }

    /* =============== */
    /* DELETE REQUESTS */
    /* =============== */

    @DeleteMapping(path = "/remove", consumes = "application/json")
    public void remove(@RequestBody Excursion excursion) {
        excursionService.remove(excursion);
    }

    @DeleteMapping(path = "/remove/{id}")
    public void remove(@PathVariable("id") Integer id) {
        excursionService.remove(id);
    }
}
