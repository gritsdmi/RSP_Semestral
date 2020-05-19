function noScroll() {
    window.scrollTo(0, 0);
}

function displaylogin() {
    var loginform = document.getElementById("login-form");
    loginform.classList.remove("display-none");
    var x = document.getElementById('blur-10');
    x.setAttribute("class", "blur-10");
    document.getElementById("overlay").classList.remove("display-none");
    window.addEventListener('scroll', noScroll);
}

function closeLogin() {
    var loginform = document.getElementById('login-form');
    loginform.classList.add("display-none");
    var x = document.getElementById('blur-10');
    x.classList.remove('blur-10');
    document.getElementById("overlay").classList.add("display-none");
    window.removeEventListener('scroll', noScroll);
}

document.getElementById('closeButton').addEventListener('click', closeLogin);
let dis_login_class = document.getElementById('display-login')
if (dis_login_class != null) {
    document.getElementById('display-login').addEventListener('click', displaylogin);
}
