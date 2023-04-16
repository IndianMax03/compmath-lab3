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
        equation: sincosButton ? "sincos" : epiButton ? "epi" : moduleButton ? "module" : null,
        method: selectedMethod,
    };

    console.log("OK!")

    let ansTableBody = document.getElementById("ansTableBody");

    $.ajax({
        type: "POST",
        url: "equations/solveNormal",
        data: JSON.stringify(data),
        contentType: "application/json",
        dataType: "json",
        success: function (result) {
            if (result.error !== undefined) {
                ansTableBody.innerHTML = result.error;
            } else {
                ansTableBody.innerHTML = result.result;
                // if (result.x === undefined || result['f(x)'] === undefined || result.iterations === undefined) {
                //     answerToUser.value = "Сервер ответил неожиданными данными..."
                //     return;
                // }
                // answerToUser.value = `x = ${result.x}\nf(x) = ${result['f(x)']}\niterations = ${result.iterations}`;
            }
        },
        error: function (xhr, status, error) {
            ansTableBody.innerText = "Упс! Ошибочка. " + error;
        }
    })

});

notificationButton.addEventListener("click", () => {
    submitHelper.style.display = "none";
})
