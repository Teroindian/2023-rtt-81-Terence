const body = document.querySelector("body")
const dark = document.querySelector("#dark-mode")
const light = document.querySelector("#light-mode")

function darkMode() {
    body.style.backgroundColor = "black";
    body.style.color = "white";
  }
  
  function lightMode() {
    body.style.backgroundColor = "white";
    body.style.color = "black";
  }
  
  light.addEventListener("click", lightMode);
  dark.addEventListener("click", darkMode);