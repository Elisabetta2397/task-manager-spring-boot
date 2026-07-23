document.addEventListener("DOMContentLoaded", () => {

    const welcomeCard = document.getElementById("welcomeCard");

    if (welcomeCard) {

        setTimeout(() => {

            welcomeCard.classList.add("opacity-0");

            setTimeout(() => {

                welcomeCard.remove();

            }, 500);

        }, 4000);

    }

});