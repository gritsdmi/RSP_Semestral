package cz.cvut.fel.rsp.tripguide.util;

import cz.cvut.fel.rsp.tripguide.dto.EventDto;
import cz.cvut.fel.rsp.tripguide.dto.ExtendedProps;
import cz.cvut.fel.rsp.tripguide.model.Event;
import cz.cvut.fel.rsp.tripguide.model.Excursion;
import cz.cvut.fel.rsp.tripguide.model.Hotel;
import cz.cvut.fel.rsp.tripguide.model.Tour;

import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("ALL")
public class CalendarEventConvertor {
    //TOUR
    private final String tourFromToColor = "rgba(220, 20, 60, 0.5)";
    private final String tourFromToTextColor = "white";

    private final String tourDepartureColor = "rgba(154, 205, 50, 0.7)";
    private final String tourDepartureTextColor ="white";

    private final String tourArrivalColor = "rgba(154, 205, 50, 0.7)";
    private final String tourArrivalTextColor ="white";

    //EXCURTION
    private final String eventFromToColor = "rgba(255, 99, 71, 0.5)";
    private final String eventFromToTextColor ="white";

    private final String eventDepartureColor = "rgba(233, 150, 122, 0.8)";
    private final String eventDepartureTextColor ="white";

    private final String eventArrivalColor = "rgba(233, 150, 122, 0.8)";
    private final String eventArrivalTextColor ="white";

    //HOTEL
    private final String hotelBreakfastColor = "rgba(123, 104, 238, 0.7)";
    private final String hotelBreakfastTextColor ="white";

    private final String hotelDinnerColor = "rgba(123, 104, 238, 0.7)";
    private final String hotelDinnerTextColor ="white";

    //EVENT
    private final String eventColor = "lightred";
    private final String eventTextColor = "white";




    public Set<EventDto> convert(Tour tour) {
        Set<EventDto> events = new HashSet<>();
        EventDto event = new EventDto();

        event.setId(tour.getId());
        event.setOverlap(true);

        event.setColor(tourFromToColor);
        event.setTextColor(tourFromToTextColor);

        event.setTitle(tour.getCity() + " " + tour.getCountry() + " tour");
        event.setStart(tour.getDateTimeFrom().toString());
        event.setEnd(tour.getDateTimeTil().toString());

        ExtendedProps extendedProps = new ExtendedProps();
        extendedProps.setDescription(tour.getDescription());
        event.setExtendedProps(extendedProps);

        //url
        event.setUrl("/tourist/destinations/"+tour.getHotel().getDestination().getId()+"/tours/"+tour.getId());
        events.add(event);

        event = new EventDto();

        event.setId(tour.getId());
        //FRONT END
        event.setColor(tourDepartureColor);
        event.setTextColor(tourDepartureTextColor);
        //FRON END

        event.setTitle(tour.getCity()+" "+tour.getCountry() + " departure");
        event.setStart(tour.getDepartureDateTime().toString());

        //url
        event.setUrl("/tourist/destinations/"+tour.getHotel().getDestination().getId()+"/tours/"+tour.getId());
        events.add(event);

        event = new EventDto();

        event.setId(tour.getId());
        //FRONT END
        event.setColor(tourArrivalColor);
        event.setTextColor(tourArrivalTextColor);
        //FRON END

        event.setTitle(tour.getCity()+" "+tour.getCountry() + " arrival");
        event.setStart(tour.getArrivalDateTime().toString());
        //url
        event.setUrl("/tourist/destinations/"+tour.getHotel().getDestination().getId()+"/tours/"+tour.getId());
        events.add(event);

        return events;
    }

    public Set<EventDto> convert(Excursion e) {
        Set<EventDto> events = new HashSet<>();
        //add exc from to event
        EventDto event = new EventDto();

        event.setId(e.getId());
        event.setOverlap(true);

        ExtendedProps extendedProps = new ExtendedProps();
        extendedProps.setDescription(e.getDescription());
        event.setExtendedProps(extendedProps);

        //FRONT END
        event.setColor(eventFromToColor);
        event.setTextColor(eventFromToTextColor);
        //FRON END
        event.setTitle(e.getName() + " excursion");
        event.setStart(e.getDateTimeFrom().toString());
        event.setEnd(e.getDateTimeTill().toString());

        //TODO url
        events.add(event);

        //add departure event
        event = new EventDto();

        event.setId(e.getId());
        //FRONT END
        event.setColor(eventDepartureColor);
        event.setTextColor(eventDepartureTextColor);
        //FRON END

        event.setTitle(e.getName() + " departure");
        event.setStart(e.getDepartureDateTime().toString());

        //TODO url
        events.add(event);
        //add arrival event
        event = new EventDto();

        event.setId(e.getId());
        //FRONT END
        event.setColor(eventArrivalColor);
        event.setTextColor(eventArrivalTextColor);
        //FRON END

        event.setTitle(e.getName() + " arrival");
        event.setStart(e.getArrivalDateTime().toString());

        //TODO add url
        events.add(event);

        return events;
    }

    public Set<EventDto> convert(Hotel hotel) {
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
        Set<EventDto> events = new HashSet<>();

        // add breakfast
        EventDto event = new EventDto();

        event.setId(hotel.getId());
        //FRONT END
        event.setColor(hotelBreakfastColor);
        event.setTextColor(hotelBreakfastTextColor);
        //FRON END

        event.setId(hotel.getId());

        event.setTitle(hotel.getName()+" breakfast");

        event.setDaysOfWeek(new int[]{0,1,2,3,4,5,6});

        event.setStartRecur(hotel.getTour().getDateTimeFrom().format(formatterDate));
        event.setEndRecur(hotel.getTour().getDateTimeTil().plusDays(1).format(formatterDate));

        event.setStartTime(hotel.getBreakfastTime_from().toString());
        event.setEndTime(hotel.getBreakfastTime_to().toString());

        //url
        event.setUrl("/tourist/destinations/"+hotel.getDestination().getId()+"/tours/"+hotel.getTour().getId());
        events.add(event);
        // add dinner
        event = new EventDto();

        event.setId(hotel.getId());
        //FRONT END
        event.setColor(hotelDinnerColor);
        event.setTextColor(hotelDinnerTextColor);
        //FRON END

        event.setId(hotel.getId());

        event.setTitle(hotel.getName()+" dinner");

        event.setDaysOfWeek(new int[]{0,1,2,3,4,5,6});

        event.setStartRecur(hotel.getTour().getDateTimeFrom().format(formatterDate));
        event.setEndRecur(hotel.getTour().getDateTimeTil().plusDays(1).format(formatterDate));

        event.setStartTime(hotel.getDinnerTime_from().toString());
        event.setEndTime(hotel.getDinnerTime_to().toString());

        //url
        event.setUrl("/tourist/destinations/"+hotel.getDestination().getId()+"/tours/"+hotel.getTour().getId());
        events.add(event);

        return events;
    }

    public EventDto convert(Event e) {
        EventDto event = new EventDto();

        event.setId(e.getId());

        //FRONT END
        event.setColor(eventColor);
        event.setTextColor(eventTextColor);
        //FRONT END

        if(e.getTitle() != null && !e.getTitle().isEmpty()) {
            event.setTitle(e.getTitle());
        }

        if(e.getStart() != null && !e.getStart().toString().isEmpty()) {
            event.setStart(e.getStart().toString());
        }

        if(e.getEnd() != null && !e.getEnd().toString().isEmpty()) {
            event.setEnd(e.getEnd().toString());
        }

        if(e.getDaysOfWeek() != null && e.getDaysOfWeek().length != 0) {
            event.setDaysOfWeek(e.getDaysOfWeek());
        }

        if(e.getStartRecur() != null && !e.getStartRecur().toString().isEmpty()) {
            event.setStartRecur(e.getStartRecur().toString());
        }

        if(e.getEndRecur() != null && !e.getEndRecur().toString().isEmpty()) {
            event.setEndRecur(e.getEndRecur().toString());
        }

        if(e.getStartTime() != null && !e.getStartTime().toString().isEmpty()) {
            event.setStartTime(e.getStartTime().toString());
        }

        if(e.getEndTime() != null && !e.getEndTime().toString().isEmpty()) {
            event.setEndTime(e.getEndTime().toString());
        }
        //TODO url
        return event;
    }
}
