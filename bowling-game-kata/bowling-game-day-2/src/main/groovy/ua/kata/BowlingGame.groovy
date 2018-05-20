package ua.kata


class BowlingGame {
  private def rolls = []

  def roll(pin) {
    rolls << pin
  }

  def score() {
    int score = 0
    int roll = 0
    for (int frame = 0; frame < 10; frame += 1) {
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

  private def isStrike(int frameIndex) {
    rolls[frameIndex] == 10
  }

  private def strikeBonus(int frameIndex) {
    rolls[frameIndex + 1] + rolls[frameIndex + 2]
  }

  private def isSpare(int frameIndex) {
    rolls[frameIndex] + rolls[frameIndex + 1] == 10
  }

  private def spareBonus(int frameIndex) {
    rolls[frameIndex + 2]
  }
}
