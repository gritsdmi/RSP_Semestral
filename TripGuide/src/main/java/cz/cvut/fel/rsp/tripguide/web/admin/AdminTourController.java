package cz.cvut.fel.rsp.tripguide.web.admin;

import cz.cvut.fel.rsp.tripguide.dto.TourDto;
import cz.cvut.fel.rsp.tripguide.model.Tour;
import cz.cvut.fel.rsp.tripguide.model.TourType;
import cz.cvut.fel.rsp.tripguide.model.TransferType;
import cz.cvut.fel.rsp.tripguide.model.User;
import cz.cvut.fel.rsp.tripguide.service.HotelService;
import cz.cvut.fel.rsp.tripguide.service.TourService;
import cz.cvut.fel.rsp.tripguide.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/admin/tours")
public class AdminTourController {

    private final TourService tourService;
    private final UserService userService;
    private final HotelService hotelService;

    @Autowired
    public AdminTourController(TourService tourService, UserService userService, HotelService hotelService) {
        this.tourService = tourService;
        this.userService = userService;
        this.hotelService = hotelService;
    }

    @GetMapping("/add")
    public String getAddTourPage() {
        return "admin/createtour";
    }

    @ModelAttribute("tour")
    public TourDto tourDto(){
        return new TourDto();
    }

    @PostMapping("/add")
    public String addTour(@ModelAttribute("tour") @Valid TourDto dto){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");

        Tour tour = new Tour();

//        tour.setDateFrom(LocalDateTime.parse(dto.getDateFrom(), formatter));
//        tour.setDatTil(LocalDateTime.parse(dto.getDateTil(), formatter));
        tour.setDepartureFrom(dto.getDepartureFrom());
//        tour.setDepartureTime_start(LocalDateTime.parse(dto.getDepartureTime_start(), formatter));
//        tour.setDepartureTime_end(LocalDateTime.parse(dto.getDepartureTime_end(), formatter));
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
        user.setTour(tourService.findTour(tour));
        model.addAttribute("tourid", tour);
        userService.save(user);
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
}

