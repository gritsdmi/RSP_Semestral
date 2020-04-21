function noScroll() {
    window.scrollTo(0, 0);
}

function displaylogin() {
    var loginform = document.getElementById("login-form");
    loginform.classList.remove("display-none");

    var x1 = document.getElementById('blur-10');
    if(!x1) {
        var x = document.getElementsByClassName('super_container')[0];
        x.setAttribute("class", "blur-10");
        x.setAttribute('id', 'blur-10');
    } else {
        x1.setAttribute("class", "blur-10");
        x1.setAttribute('id', 'blur-10');
    }


    document.getElementsByClassName("overlay")[0].classList.remove("display-none");

    window.addEventListener('scroll', noScroll);
}

function closeLogin() {
    var loginform = document.getElementById('login-form');
    loginform.classList.add("display-none");
    var x = document.getElementById('blur-10');
    x.classList.remove('blur-10');
    document.getElementsByClassName("overlay")[0].classList.add("display-none");
    window.removeEventListener('scroll', noScroll);
}

document.getElementById('closeButton').addEventListener('click', closeLogin);
document.getElementById('display-login').addEventListener('click', displaylogin);
