
function getRandomArbitrary(min,max) {
  //max exclusive for this function.
  return Math.floor(Math.random() * (max - min) + min);
}

let firstCard = getRandomArbitrary(2,12);
let secondCard = getRandomArbitrary(2,12);
let cards = [firstCard, secondCard]
let sum = firstCard + secondCard;
let hasBlackJack = false;
let isAlive = true;
let msg;

let msgEl = document.getElementById('message-el');
let sumEl = document.getElementById('sum-el');
let cardsEl = document.getElementById('cards-el');

const startGame = () => renderGame();

const renderGame = () => {
  cardsEl.textContent = `Cards: ${firstCard}  ${secondCard}`;
  sumEl.textContent = "Sum: " + sum;

  if (sum <= 20) {
    msg ="Do you want to draw a new card?";

  } else if (sum === 21) {
    msg = "You got BlackJack!";
    hasBlackJack = true;
  } else {
    msg = "You are done! Game Over!";
    isAlive = false;
  }
  msgEl.textContent = msg;

}

let newCard =() => {
  let card = getRandomArbitrary(2,12);
  sum += card;
  startGame();
}
