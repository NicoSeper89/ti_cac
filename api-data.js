const apiKey = "d34f328414e9da789accefbd4c35acc8";

const weatherContainer = document.getElementById("current-weather");

async function fetchWeather() {
  try {
    const lat = -29.8819399;
    const lon = -61.9451954;

    const apiWeatherUrl = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&units=metric&appid=${apiKey}&lang=es`;

    const response = await fetch(apiWeatherUrl);
    const data = await response.json();

    if (data.cod == "400" || data.cod == "404") {
      throw new Error(data.message);
    }

    createCurrentWeatherCard(data);
  } catch (error) {
    console.log(error);
  }
}

function createCurrentWeatherCard(weatherData) {
  const { main, weather, dt, wind, name } = weatherData;

  const currentTemp = document.createElement("div");
  const { dayName, date } = convertToLocalTime(dt);

  currentTemp.innerHTML = `
      <div class="d-flex flex-column justify-content-between">
        <span class="fs-5">Ahora - ${name}</span>
        <span class="fs-3 fw-bold">${main.temp
          .toString()
          .slice(0, 2)} °C</span>
        <span > ${dayName} ${date} </span>
      </div>
    `;

  const secondarySection = document.createElement("div");

  secondarySection.innerHTML = `
      <div class="d-flex flex-column justify-content-between">
        <span >
         Humedad: ${main.humidity}%
        </span>
        <span >
          Viento: ${wind.speed}
        </span>
      </div>`;

  const separator = document.createElement("div");

  separator.className = "vr h-100 bg-light";
  separator.style = "width: 1px; opacity: 0.6";

  const weatherImage = getImageByWeather(weatherData);

  weatherContainer.appendChild(currentTemp);
  weatherContainer.appendChild(weatherImage);
  weatherContainer.appendChild(separator);
  weatherContainer.appendChild(secondarySection);
}

function getImageByWeather(weatherData) {

  const imgElement = document.createElement("img");

  let imgURL = "source/image/weatherImages/"

  const main = weatherData.weather[0].main.toString();
  const temp = weatherData.main.temp;

  if (main === "Clear") {
    if (temp > 20) {
      weatherContainer.style =
        "background: linear-gradient(to right, #56ccf2, #2f80ed);";
        imgURL += "sun.svg";
    } else {
      weatherContainer.style =
        "background: linear-gradient(to right, #373b44, #4286f4);";
        imgURL += "cold-sun.svg";
    }
  } else if (main === "Clouds") {
    imgURL += "cloud.svg";
  } else if (main === "Rain") {
    imgURL += "rain.svg";
  } else if (main === "Thunderstorm") {
    imgURL += "thunderstorm.svg";
  } else if (main === "Snow") {
    imgURL += "snow.svg";
  } else if (main === "Mist" || main === "Fog") {
    imgURL += "fog.svg";
  } else {
    imgURL += "default.svg";
  }

  imgElement.src = imgURL;

  return imgElement;
}

function convertToLocalTime(dt) {
  const date = new Date(dt * 1000);

  const year = date.getFullYear();
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const day = String(date.getDate()).padStart(2, "0");
  const dayName = [
    "Domingo",
    "Lunes",
    "Martes",
    "Miercoles",
    "Jueves",
    "Viernes",
    "Sabado",
  ][date.getDay()];

  return { dayName, date: `${day}/${month}/${year}` };
}

document.addEventListener("DOMContentLoaded", function () {
  fetchWeather();
});
