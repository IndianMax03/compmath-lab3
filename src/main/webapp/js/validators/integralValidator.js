//  created by Raj Manu on 16.04.2023

const submitButton = document.getElementById("submitButton");
const notificationButton = document.getElementById("notificationButton");
const submitHelper = document.getElementById("submitHelper");


submitButton.addEventListener("click", (evt) => {

    evt.preventDefault();

    let aStr = $('#a').val().replaceAll(" ", "");
    let bStr = $('#b').val().replaceAll(" ", "");
    let epsStr = $('#eps').val().replaceAll(" ", "");

    let sincosButton = document.getElementById("sincosButton").checked;
    let epiButton = document.getElementById("epiButton").checked;
    let moduleButton = document.getElementById("moduleButton").checked;
    let hyperButton = document.getElementById("hyperButton").checked;
    let downButton = document.getElementById("downButton").checked;
    let selectedMethod = document.querySelector("#method").value;

    let a = aStr !== "" ? Number(aStr.replaceAll(",", ".")) : NaN;
    let b = bStr !== "" ? Number(bStr.replaceAll(",", ".")) : NaN;
    let eps = epsStr !== "" ? Number(epsStr.replaceAll(",", ".")) : NaN;

    let isValid = true;

    if (isNaN(a) || isNaN(b) || isNaN(eps)) {
        isValid = false;
    }

    if (isValid) {
        if (!(a < b) || eps < 0) {
            isValid = false;
        }
    }

    if (!isValid) {
        submitHelper.style.display = "block";
        return;
    } else {
        submitHelper.style.display = "none";
    }

    // Отправка на сервер с учетом выбранного графика.

    let data = {
        a: aStr.replaceAll(",", "."),
        b: bStr.replaceAll(",", "."),
        eps: epsStr.replaceAll(",", "."),
        equation: sincosButton ? "sincos" : epiButton ? "epi" : moduleButton ? "module" : hyperButton ? "hyper" : downButton ? "down" : null,
        method: selectedMethod,
    };

    let ansTableBody = document.getElementById("ansTableBody");
    ansTableBody.innerHTML = ""
    ansTableBody.innerHTML = "<tr><td colspan='4'><h1>Let's wait...</h1><br><progress class=\"progress is-small is-info\" max=\"10\">15%</progress></td></tr>";
    ansTableBody.style.color = "blue"
    $.ajax({
        type: "POST",
        url: "equations/solveNormal",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (result) {
            if (result.error !== undefined) {
                ansTableBody.style.color = "red"
                ansTableBody.innerHTML = `<tr><td colSpan='4'><h1>Error: ${result.error}</h1></td></tr>`
            } else {
                let n = Array.from(result['n']);
                let I = Array.from(result['I']);
                let eps = Array.from(result['eps'])
                let success = result['success']

                if (n === undefined || I === undefined || eps === undefined || success === undefined) {
                    ansTableBody.innerHTML = `<tr><td colspan='4'><h1>Server is dead inside</h1></td></tr>`;
                    return;
                }

                ansTableBody.innerHTML = "";

                for (let i = 0; i < n.length; i++) {
                    ansTableBody.innerHTML += `<tr><td>${i}</td><td>${n[i]}</td><td>${I[i]}</td><td>${eps[i]}</td></tr>`
                }

                ansTableBody.style.color = success === "true" ? "green" : "red"

            }
        },
        error: function (xhr, status, error) {
            ansTableBody.style.color = "red";
            ansTableBody.innerText = "Try again... " + error;
        }
    })

});

notificationButton.addEventListener("click", () => {
    submitHelper.style.display = "none";
})
