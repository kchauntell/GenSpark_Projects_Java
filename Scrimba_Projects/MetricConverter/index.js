let onSubmit = () => {
  let numberEntered = document.getElementById('number');
  let conversion = document.getElementById('conversion');

  let length = document.getElementById('meterFeet');
  length.textContent = metersFeet();

  let volume = document.getElementById('literGallon');
  volume.textContent = gallonLiter();

  let mass = document.getElementById('kgPounds');
  mass.textContent = kgPounds();

  conversion.textContent = numberEntered.value;
}

let metersFeet = () => {
  let numberEntered = document.getElementById('number').value;
  let meters = 0.3048;

  let meterToFeet = (numberEntered / meters).toFixed(3);
  let feetToMeter = (numberEntered * meters).toFixed(3);

  return `${numberEntered} meters = ${meterToFeet} feet | ${numberEntered} feet = ${feetToMeter} meters`;
}

let gallonLiter = () => {
  let numberEntered = document.getElementById('number').value;
  let liter = 3.78541;

  let gallonToLiter = (numberEntered * liter).toFixed(3);
  let literToGallon = (numberEntered / liter).toFixed(3);

  return `${numberEntered} liters = ${literToGallon} gallons | ${numberEntered} gallons = ${gallonToLiter} liters`;
}

let kgPounds = () => {
  let numberEntered = document.getElementById('number').value;
  let kilogram = 0.453592;

  let poundToKilogram = (numberEntered * kilogram).toFixed(3);
  let kilogramToPound = (numberEntered / kilogram).toFixed(3);

  return `${numberEntered} kilograms = ${kilogramToPound} pounds | ${numberEntered} pounds = ${poundToKilogram} kilograms`;
}
