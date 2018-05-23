package ua.kata


class BowlingGame {
  private def rolls = []

  def roll(pin) {
    rolls << pin
  }

  def score() {
    int score = 0
    int roll = 0
    for (int frame = 0; frame < 10; frame++) {
      if (isStrike(roll)) {
        score += 10 + strikeBonus(roll)
        roll += 1
      } else if (isSpare(roll)) {
        score += 10 + spareBonus(roll)
        roll += 2
      } else {
        score += rolls[roll] + rolls[roll + 1]
        roll += 2
      }
    }
    score
  }

  private def isStrike(roll) {
    rolls[roll] == 10
  }

  private def strikeBonus(roll) {
    rolls[roll + 1] + rolls[roll + 2]
  }

  private def isSpare(roll) {
    rolls[roll] + rolls[roll + 1] == 10
  }

  private def spareBonus(roll) {
    rolls[roll + 2]
  }
}
