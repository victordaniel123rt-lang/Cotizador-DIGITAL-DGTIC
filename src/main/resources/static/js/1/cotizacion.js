document.addEventListener("DOMContentLoaded", function () {
    const select = document.getElementById("marcaSelect");

    select.addEventListener("change", function () {
        const input = document.getElementById("otraMarca");

        if (this.value === "otro") {
            input.style.display = "block";
            input.value = "";
        } else {
            input.style.display = "none";
            input.value = this.value;

            if (this.value) {
                document.querySelector("form").submit();
            }
        }
    });
});


document.addEventListener("DOMContentLoaded", function () {
    const select = document.getElementById("marcaSelect2");

    select.addEventListener("change", function () {
        const input = document.getElementById("otraMarca2");

        if (this.value === "otro") {
            input.style.display = "block";
            input.value = "";
        } else {
            input.style.display = "none";
            input.value = this.value;

            if (this.value) {
                document.querySelector("form").submit();
            }
        }
    });
});