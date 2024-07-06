
function validateInput(type) {
  const element = document.getElementById(type);

  if (
    element.value.trim() === "" ||
    (type === "email" &&
      !/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/.test(
        element.value.trim()
      ))
  ) {
    element.classList.add("is-invalid");
    element.classList.remove("is-valid");
    return false;
  } else {
    element.classList.add("is-valid");
    element.classList.remove("is-invalid");
    return true;
  }
}

function validateForm() {
  const isValidName = validateInput(`name`);
  const isValidSurname = validateInput(`surname`);
  const isValidEmail = validateInput(`email`);
  const isValidComment = validateInput(`comment`);
  return isValidName && isValidSurname && isValidEmail && isValidComment;
}

document
  .getElementById(`name`)
  .addEventListener(`input`, () => validateInput(`name`));
document
  .getElementById(`surname`)
  .addEventListener(`input`, () => validateInput(`surname`));
document
  .getElementById(`email`)
  .addEventListener(`input`, () => validateInput(`email`));
document
  .getElementById(`comment`)
  .addEventListener(`input`, () => validateInput(`comment`));

document
  .getElementById("contact-form")
  .addEventListener("submit", function (event) {
    if (!validateForm()) {
      event.preventDefault(); 
      event.stopPropagation();
    }
  });

document.querySelector('[type="reset"]').addEventListener("click", function () {
  const inputs = document.querySelectorAll(".form-control");
  inputs.forEach((input) => {
    input.classList.remove("is-valid", "is-invalid");
  });
});

document.querySelectorAll('.scroll-to-middle').forEach(element => {
  element.addEventListener('click', function (e) {
      e.preventDefault();
      
      const targetId = this.getAttribute('href');
      const targetElement = document.querySelector(targetId);
      
      const elementPosition = targetElement.offsetTop + targetElement.offsetHeight - window.innerHeight;
      
      window.scrollTo({
          top: elementPosition,
          behavior: 'auto'
      });
  });
});