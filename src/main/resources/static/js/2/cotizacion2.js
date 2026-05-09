document.addEventListener("DOMContentLoaded", function () {
    const select = document.getElementById("marcaSelect3");
    select.addEventListener("change", mostrarInput3);
});

function mostrarInput3() {
    const select = document.getElementById("marcaSelect3");
    const input = document.getElementById("otraMarca3");

    if (select.value === "otro") {
        input.style.display = "block";
        input.value = "";
    } else {
        input.style.display = "none";
        input.value = select.value;
    }
}