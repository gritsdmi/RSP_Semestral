function noScroll() {
    window.scrollTo(0, 0);
}

function displaylogin() {
    var loginform = document.getElementById("login-form");
    loginform.classList.remove("display-none");

    var x = document.getElementsByClassName('super_container')[0];
    x.setAttribute("class", "blur-10");
    document.getElementsByClassName("overlay")[0].classList.remove("display-none");

    window.addEventListener('scroll', noScroll);
}