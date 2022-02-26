// initialize count as 0
let countEl = document.getElementById("count-el");
let count = 0;
totalCount = 0;
let saveEl = document.getElementById("save-el");
let decBtn = document.getElementsByClassName('decrement-btn');

if(countEl.textContent == 0 ) {
  decBtn.disabled =true;
}

let  increment = () => {
  count++
  totalCount += count;
  countEl.textContent = count;
}

let decrement = () => {
  count --; 
  countEl.textContent = count;
};

let save = () => {
  let string = count + " - ";
  saveEl.textContent += string;
  count = 0;
  countEl.textContent = 0;
}

let totalCount = () => {

}

let reset = () => {
  count = 0;
  countEl.textContent = 0;
  saveEl.textContent = "Previous Count: ";
}
