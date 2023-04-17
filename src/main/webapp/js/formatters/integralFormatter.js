//  created by Raj Manu on 15.04.2023

const sincosLabel = document.getElementById('sincosLabel');
const epiLabel = document.getElementById('epiLabel');
const moduleLabel = document.getElementById('moduleLabel');
const hyperLabel = document.getElementById('hyperLabel');
const downLabel = document.getElementById('downLabel');

const iterTable = document.getElementById('iterTable');
const nTable = document.getElementById('nTable');
const iTable = document.getElementById('iTable');
const epsTable = document.getElementById('epsTable');

katex.render(
    "\\int_a^b sin(cos(sin(x)))dx",
    sincosLabel
)

katex.render(
    "\\int_a^b  [ \\pi^{sin(-xcosx)} + \\frac{e^{\\pi}-100\\pi}{300} ]dx",
    epiLabel
)

katex.render(
    "\\int_a^b  [ |\\frac{x^5}{3}| - 2x^2 - |2x| ]dx",
    moduleLabel
)

katex.render(
    "\\int_a^b \\frac{dx}{x}",
    hyperLabel
)

katex.render(
    "\\int_a^b \\frac{dx}{-x^2+4x-4}",
    downLabel
)

katex.render(
    "n_i",
    nTable
)

katex.render(
    "I_i",
    iTable
)

katex.render(
    "eps_i",
    epsTable
)

katex.render(
    "i",
    iterTable
)
