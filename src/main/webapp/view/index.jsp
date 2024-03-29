<%-- created by Raj Manu on 15.04.2023 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>cm3</title>
    <link href="https://fonts.cdnfonts.com/css/wonder-boy-in-monster-world" rel="stylesheet">
    <link
            href="https://fonts.googleapis.com/css?family=Gloria+Hallelujah&display=swap"
            rel="stylesheet"
    >
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma-rtl.min.css">
    <style>
        body {
            background: linear-gradient(90deg, rgba(255, 0, 0, 1) 0%, rgba(255, 154, 0, 1) 10%, rgba(208, 222, 33, 1) 20%, rgba(79, 220, 74, 1) 30%, rgba(63, 218, 216, 1) 40%, rgba(47, 201, 226, 1) 50%, rgba(28, 127, 238, 1) 60%, rgba(95, 21, 242, 1) 70%, rgba(186, 12, 248, 1) 80%, rgba(251, 7, 217, 1) 90%, rgba(255, 0, 0, 1) 100%);
            height: 150vh;
        }

        * {
            font-family: 'Gloria Hallelujah', sans-serif !important;
        }

        input[type=radio] {
            accent-color: black;
        }

        .katex {
            font-family: 'Gloria Hallelujah', sans-serif;
            font-size: 26px !important;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.css">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/KaTeX/0.7.1/katex.min.js"></script>
</head>
<body>

<section class="has-text-centered">
    <div class="is-size-1">
        Computational Mathematics Lab #3
    </div>

</section>

<section class="section">
    <div class="columns is-vcentered is-flex is-align-items-center">
        <div class="column is-6">
            <div class="is-size-2 is-fullheight-with-navbar">
                <span>Choose your equation:</span>
                <div class="control">

                    <div class="my-5">
                        <label class="radio">
                            <input type="radio" id="sincosButton" name="equation" checked class="mr-4">
                            <span id="sincosLabel"></span>
                        </label>
                    </div>

                    <div class="mb-5">
                        <label class="radio">
                            <input type="radio" id="epiButton" name="equation" class="mr-4">
                            <span id="epiLabel"></span>
                        </label>
                    </div>

                    <div class="mb-5">
                        <label class="radio">
                            <input type="radio" id="moduleButton" name="equation" class="mr-4">
                            <span id="moduleLabel"></span>
                        </label>
                    </div>

                    <div class="mb-5">
                        <label class="radio">
                            <input type="radio" id="hyperButton" name="equation" class="mr-4">
                            <span id="hyperLabel"></span>
                        </label>
                    </div>

                    <div class="mb-5">
                        <label class="radio">
                            <input type="radio" id="downButton" name="equation" class="mr-4">
                            <span id="downLabel"></span>
                        </label>
                    </div>

                </div>
            </div>
        </div>
        <div class="column is-6">
            <div id="submitHelper" class="notification is-danger has-text-centered"
                 style="display: none; position: absolute">
                <button id="notificationButton" class="delete"></button>
                <span style="background: linear-gradient(90deg, rgba(255,0,0,1) 0%, rgba(255,154,0,1) 10%, rgba(208,222,33,1) 20%, rgba(79,220,74,1) 30%, rgba(63,218,216,1) 40%, rgba(47,201,226,1) 50%, rgba(28,127,238,1) 60%, rgba(95,21,242,1) 70%, rgba(186,12,248,1) 80%, rgba(251,7,217,1) 90%, rgba(255,0,0,1) 100%)">YO DUDE WTF???</span>
                <span style="background: crimson;">1.REAL NUMBER</span>
                <span style="background: black;">2.B > A</span>
                <span style="background: blue;">3.EPS >= 0</span>
                <br>
                <div class="has-text-right mt-1">
                    <img style="transform: scale(-1, 1);" height="150" width="150px"
                         src="https://kaifolog.ru/uploads/posts/2015-09/1443418043_014.jpg">
                    <progress class="progress is-small is-warning" max="100">15%</progress>
                </div>
            </div>
            <div class="is-size-2 is-fullheight-with-navbar">
                <span>Choose your params:</span>
                <div class="field my-5">
                    <div class="field has-addons">
                        <div class="control pr-2">
                            <label class="label ml-2">a = </label>
                        </div>
                        <div class="control">
                            <input id="a" class="input is-small" type="text" placeholder="any real number">
                        </div>
                    </div>
                </div>
                <div class="field mb-5">
                    <div class="field has-addons">
                        <div class="control pr-2">
                            <label class="label ml-2">b = </label>
                        </div>
                        <div class="control">
                            <input id="b" class="input is-small" type="text" placeholder="any real number">
                        </div>
                    </div>
                </div>
                <div class="field mb-5">
                    <div class="field has-addons">
                        <div class="control pr-2">
                            <label class="label ml-2">eps = </label>
                        </div>
                        <div class="control">
                            <input id="eps" class="input is-small" type="text" placeholder="any real number">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<section>
    <div class="columns is-vcentered is-flex is-align-items-center has-text-centered">
        <div class="column is-3">
            <a href="https://www.wolframalpha.com/input?i2d=true&i=Integrate%5Bsin%5C%2840%29cos%5C%2840%29sin%5C%2840%29x%5C%2841%29%5C%2841%29%5C%2841%29%2C%7Bx%2C-6%2C40%7D%5D">
                <img id="catch" height="220px" width="220px" src="https://bestgif.su/_ph/46/2/620089982.gif">
            </a>
            <br>
            <span>Check the first</span>
        </div>
        <div class="column is-6">
            <div class="is-square is-fullheight-with-navbar">
                <div>
                    <div>
                        <span class="is-size-5">Choose your method:</span>
                    </div>
                    <div class="select is-info my-6">
                        <select id="method">
                            <option id="leftRectangle" value="LeftRectangle">Left Rectangle</option>
                            <option id="rightRectangle" value="RightRectangle">Right Rectangle</option>
                            <option id="middleRectangle" value="MiddleRectangle">Middle Rectangle</option>
                            <option id="trapeze" value="Trapeze">Trapeze</option>
                            <option id="simpson" value="Simpson">Simpson</option>
                        </select>
                    </div>
                </div>
                <div class="mb-6">
                    <button id="submitButton" class="button is-danger is-medium is-light">INTEGRATE!!!</button>
                </div>
            </div>
        </div>
        <div class="column is-3">
            <a href="https://www.wolframalpha.com/input?i2d=true&i=Integrate%5B%5C%2840%29Power%5Bpi%2Csin%5C%2840%29-xcos%5C%2840%29x%5C%2841%29%5C%2841%29%5D%2BDivide%5BPower%5Be%2Cpi%5D-100pi%2C300%5D%5C%2841%29%2C%7Bx%2C-6%2C20%7D%5D">
                <img id="pon" height="220px" width="220px"
                     src="https://media.tenor.com/IqWW1a8gE9oAAAAC/%D0%BF%D0%BE%D0%BD-%D0%BA%D0%BE%D1%82.gif">
            </a>
            <br>
            <span>Check the second</span>
        </div>
    </div>

</section>


<section>
    <div class="columns is-vcentered is-align-items-center has-text-centered">
        <div class="column is-3 has-text-centered">
            <a href="https://www.wolframalpha.com/input?i2d=true&i=Integrate%5B%5C%2840%29%7CDivide%5BPower%5Bx%2C5%5D%2C3%5D%7C+-+2Power%5Bx%2C2%5D+-+%7C2x%7C%5C%2841%29%2C%7Bx%2C-10%2C2%7D%5D">
                <img id="shoes" height="220px" width="220px" src="https://apikabu.ru/img/NzMzNW.gif">
            </a>
            <br>
            <span>Check the third</span>
        </div>

        <div class="column is-6 has-text-centered">
            <div class="table-container" style="height: 300px; overflow: auto;">
                <table class="table is-bordered has-text-centered" style="margin: auto">
                    <thead>
                    <tr>
                        <td><abbr id="iterTable" title="Number of iterations"></abbr></td>
                        <td><abbr id="nTable" title="Number of gaps"></abbr></td>
                        <td><abbr id="iTable" title="Integral value"></abbr></td>
                        <td><abbr id="epsTable" title="Measurement error"></abbr></td>
                    </tr>
                    </thead>
                    <tbody id="ansTableBody" class="has-text-centered is-centered is-center">
                    </tbody>
                </table>
            </div>
        </div>

        <div class="column is-3 has-text-centered">
            <a href="https://www.integral-calculator.ru/">
                <img id="dance" height="220px" width="220px"
                     src="https://i.gifer.com/origin/a4/a488a8af497a4043981768348e98da07_w200.gif">
            </a>
            <br>
            <span>Online solver</span>
        </div>
    </div>
</section>
<script src="<c:url value="/js/formatters/integralFormatter.js"/>"></script>
<script src="<c:url value="/js/validators/integralValidator.js"/>"></script>
</body>
</html>
