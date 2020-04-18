package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.ExcursionDto;
import cz.cvut.fel.rsp.tripguide.dto.TourDto;
import cz.cvut.fel.rsp.tripguide.model.*;
import cz.cvut.fel.rsp.tripguide.service.ExcursionService;
import cz.cvut.fel.rsp.tripguide.service.HotelService;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin/tours")
public class AdminTourController {

    private final TourService tourService;
    private final UserService userService;
    private final HotelService hotelService;
    private final ExcursionService excursionService;

    @Autowired
    public AdminTourController(TourService tourService, UserService userService, HotelService hotelService, ExcursionService excursionService) {
        this.tourService = tourService;
        this.userService = userService;
        this.hotelService = hotelService;
        this.excursionService = excursionService;
    }

    @GetMapping("/add")
    public String getAddTourPage() {
        return "admin/createtour";
    }

    @ModelAttribute("tour")
    public TourDto tourDto(){
        return new TourDto();
    }

    @ModelAttribute("excursion")
    public ExcursionDto excursionDto(){return new ExcursionDto();}

    @PostMapping("/add")
    public String addTour(@ModelAttribute("tour") @Valid TourDto dto){

        Tour tour = new Tour();

        tour.setDateTimeFrom(LocalDateTime.parse(dto.getDateTimeFrom()));
        tour.setDateTimeTil(LocalDateTime.parse(dto.getDateTimeTil()));
        tour.setDepartureFrom(dto.getDepartureFrom());
        tour.setDepartureDateTime(LocalDateTime.parse(dto.getDepartureDateTime()));
        tour.setArrivalDateTime(LocalDateTime.parse(dto.getArrivalDateTime()));
        tour.setDescription(dto.getDescription());
        tour.setDelegate(userService.findUser(dto.getDelegate()));
        tour.setHotel(hotelService.findHotel(dto.getHotel()));

        tour.setTransferType(TransferType.PLANE);
        tour.setTourType(TourType.BEACH);

        tourService.save(tour);
        return "redirect:/admin/home";
    }

    @GetMapping("/{tour}/tourists")
    public ModelAndView getTouristsByTour(Model model, @PathVariable Integer tour){
        ModelAndView mv = new ModelAndView();
        model.addAttribute("tourists", userService.getTouristsByTour(tourService.findTour(tour)));
        model.addAttribute("tourid", tour);
        mv.setViewName("admin/usersbytour");
        return mv;
    }

    @PostMapping("/{tour}/tourists")
    public String addTouristToTour(Model model, @PathVariable Integer tour, @RequestParam String username){
        User user = userService.findUser(username);
        user = userService.addTour(user,tour);
        model.addAttribute("tourid", tour);
        return "redirect:/admin/tours/"+tour+"/tourists";
    }

    @GetMapping
    public String getAllTours(Model model){
        model.addAttribute("tours", tourService.getAllTours());
        return "admin/alltours";
    }

    @GetMapping("/{id}")
    public String getTour(Model model, @PathVariable Integer id){
        model.addAttribute("tour", tourService.findTour(id));
        return "admin/tour";
    }

    @GetMapping("/{id}/excursions")
    public String getExcursionsByTour(Model model, @PathVariable Integer id){
        model.addAttribute("excursions", excursionService.findExcursionsByTour(id));
        model.addAttribute("tour", tourService.findTour(id));
        return "admin/allexcursionsbytour";
    }


    @PostMapping("/{id}/addexc")
    public String addNewExcursionsToTour(@PathVariable Integer id, @ModelAttribute("excursion") @Valid ExcursionDto dto){
        Excursion excursion = new Excursion();
        excursion.setName(dto.getName());
        excursion.setDescription(dto.getDescription());
        excursion.setPrice(Integer.parseInt(dto.getPrice()));
        if(dto.getTransfer().equals("yes")) excursion.setTransferNeeded(true);
        else excursion.setTransferNeeded(false);
        excursion.setDateTimeFrom(LocalDateTime.parse(dto.getDateTimeFrom()));
        excursion.setDateTimeTill(LocalDateTime.parse(dto.getDateTimeTill()));
        excursion.setDepartureDateTime(LocalDateTime.parse(dto.getDepartureDateTime()));
        excursion.setArrivalDateTime(LocalDateTime.parse(dto.getArrivalDateTime()));
        excursionService.addExcursion(excursion, id);
        return "redirect:/admin/tours/"+id+"/excursions";
    }
}

