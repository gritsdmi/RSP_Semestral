var ul = document.getElementById('sorting-ul');

var content0 = document.getElementById('0');
var content1 = document.getElementById('1');
var content2 = document.getElementById('2');

ul.addEventListener('click', function(event) {
    var cur = parseInt(event.target.parentElement.getAttribute('data-option'));
    switch(cur) {
        case 0:
            getContent(cur).classList.remove('display-none');
            removeActive(event.target.parentElement, cur);
            break;
        case 1:
            getContent(cur).classList.remove('display-none');
            removeActive(event.target.parentElement, cur);
            break;
        case 2:
            getContent(cur).classList.remove('display-none');
            removeActive(event.target.parentElement, cur);
            break;
    }
});

function removeActive(element, id) {
    getContent(parseInt(ul.getAttribute('data-current'))).classList.add('display-none');
    ul.childNodes.forEach(function (e) { if(e.classList) {
        e.classList.remove('active');
    }});
    element.classList.add('active');
    ul.setAttribute('data-current', id);
}

function getContent(id) {
    switch(id) {
        case 0:
            return content0;
        case 1:
            return content1;
        case 2:
            return content2;
    }
}