const apiKey = "d34f328414e9da789accefbd4c35acc8";

const weatherContainer = document.getElementById("current-weather");
const extendedWeatherItems = document.getElementById(
  "extended-weather-container"
);

const lat = -29.8819399;
const lon = -61.9451954;
const cnt = 5;
const cityInputtedByUser = "Rosario";

async function fetchCurrentWeather() {
  try {
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
        <span class="fs-3 fw-bold">${main.temp.toString().slice(0, 2)} °C</span>
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

  const { imgElement, style } = getImageByWeather(weatherData);

  weatherContainer.style.background = style;

  weatherContainer.appendChild(currentTemp);
  weatherContainer.appendChild(imgElement);
  weatherContainer.appendChild(secondarySection);

  console.log(weatherContainer);
}

async function fetchExtendedForecast() {
  try {
    const apiCityUrl = `http://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&units=metric&cnt=${cnt}&appid=${apiKey}&lang=es`;

    const response = await fetch(apiCityUrl);
    const data = await response.json();

    if (data.cod == "400" || data.cod == "404") {
      throw new Error(data.message);
    }

    data.list.forEach((hourlyWeatherData, i) => {
      const card = createExtendedWeatherCard(hourlyWeatherData);
      extendedWeatherItems.appendChild(card);
    });
  } catch (error) {
    console.log(error);
  }
}

function createExtendedWeatherCard(weatherData) {
  const { main, weather, dt, wind, name } = weatherData;

  const temp = document.createElement("div");

  const { dayName, date } = convertToLocalTime(dt);
  const { imgElement, style } = getImageByWeather(weatherData);

  temp.className = `extended-weather-items rounded-1 row m-0`;
  temp.style = `background: ${style}; height: 5rem`;

  imgElement.style.scale = 0.8

  temp.innerHTML = `
    <div class="col d-flex flex-wrap gap-2 align-items-center">
      <span class="fs-6 fw-bold">${main.temp.toString().slice(0, 2)} °C</span>
      <span > ${dayName} ${date} </span>
    </div>
    <div class="col-5 d-flex gap-4 align-items-center">
        <span >
         Humedad: ${main.humidity}%
        </span>
        <span >
          Viento: ${wind.speed}
        </span>
    </div>
    <div class="col-1 d-flex align-items-center">
    ${imgElement.outerHTML}
    </div>
  `;

  return temp;
}

function getImageByWeather(weatherData) {
  const imgElement = document.createElement("img");

  let imgURL = "source/image/weatherImages/";
  let style = "linear-gradient(to right, #56ccf2, #2f80ed)";

  const main = weatherData.weather[0].main.toString();
  const temp = weatherData.main.temp;

  if (main === "Clear") {
    if (temp > 20) {
      style = "linear-gradient(to right, #56ccf2, #2f80ed)";
      imgURL += "sun.svg";
    } else {
      style = "linear-gradient(to right, #373b44, #4286f4)";
      imgURL += "cold-sun.svg";
    }
  } else if (main === "Clouds") {
    style = "linear-gradient(to right, #bdc3c7, #2c3e50)";
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

  return { imgElement, style };
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
  fetchCurrentWeather();
  fetchExtendedForecast();
});
