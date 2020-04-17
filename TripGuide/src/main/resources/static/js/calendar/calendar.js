document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
        plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
        },
        defaultDate: '2020-04-17',
        navLinks: true, // can click day/week names to navigate views
        editable: false,
        events: [
            {
                title: 'test',

                start: '2020-04-17',
                end: '2020-04-17',

                startTime: '12:30',
                endTime: '13:30',

                daysOfWeek: [1,2], // [1,2,3,4,5,6,7] on which day of week repeat
                startRecur: '2020-04-17',
                endRecur: '2020-04-28',

                url: 'user',

                color: 'lightblue',
                textColor: 'white'
            }
        ]
    });
    calendar.render();
});