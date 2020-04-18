document.addEventListener('DOMContentLoaded', function() {

    var calendarEl = document.getElementById('calendar');
    var userId = document.getElementById('userId');

    var today = new Date();
    var dd = String(today.getDate()).padStart(2, '0');
    var mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = today.getFullYear();
    today = yyyy + '-' + mm + '-' + dd;

    fetch("/api/events/"+userId.value).then(function (response) {
        if (response.status !== 200) {
            return;
        }
        response.json().then(function(data) {
            initCalendar(data);
        });
    }).catch(function(err) {
    });

    function initCalendar(events) {
        var calendar = new FullCalendar.Calendar(calendarEl, {
            plugins: [ 'interaction', 'dayGrid', 'timeGrid', 'list' ],
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'dayGridMonth,timeGridWeek,timeGridDay,listMonth'
            },
            defaultDate: today,
            navLinks: true,
            editable: false,
            events: events
        });
        calendar.render();
    }






});
