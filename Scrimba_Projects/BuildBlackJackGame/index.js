function getRandomArbitrary(min,max) {
  let random = Math.floor(Math.random() * (max - min) + min);
  if (random === 1) return 11;
  else if(random > 10) return 10;
  else return random;
}

let cards = [];
let sum = 0;
let hasBlackJack = false;
let isAlive = false;
let msg;

let msgEl = document.getElementById('message-el');
let sumEl = document.getElementById('sum-el');
let cardsEl = document.getElementById('cards-el');

let player = {
  name: "Kendra",
  chips: 100,
}

let playerEl = document.getElementById('player-el');
playerEl.textContent = `${player.name}: \$${player.chips}`;

const startGame = () => {
  isAlive = true;
  let firstCard = getRandomArbitrary(1, 14);
  let secondCard = getRandomArbitrary(1, 14);
  cards = [firstCard, secondCard];
  sum = firstCard + secondCard;
  renderGame();
}

const renderGame = () => {
  cardsEl.textContent = "Cards: "

  for(let card of cards) {
    cardsEl.textContent += card + "  ";
  }

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
  if(isAlive && !hasBlackJack) {
    let card = getRandomArbitrary(1,14);
    sum += card;
    cards.push(card);
    console.log(cards);
    renderGame();
  }
}
