const apiKey = "d34f328414e9da789accefbd4c35acc8";

async function fetchWeather() {
  try {

    const lat = -29.8819399;
    const lon = -61.9451954;
    const cnt = 10;

    const apiWeatherUrl = `https://api.openweathermap.org/data/2.5/forecast?lat=${lat}&lon=${lon}&cnt=${cnt}&appid=${apiKey}&lang=es`;

    const response = await fetch(apiWeatherUrl);
    const data = await response.json();

    if (data.cod == "400" || data.cod == "404") {
     throw new Error(data.message)
    }

    data.list.forEach((hourlyWeatherData) => {
      console.log(hourlyWeatherData);
    });

  } catch (error) {
    console.log(error);
  }
}



document.addEventListener("DOMContentLoaded", function () {
  fetchWeather();
});
