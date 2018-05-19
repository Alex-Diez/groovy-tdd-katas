package ua.kata


class BowlingGame {
  private def rolls = []

  def roll(int pin) {
    rolls.add(pin)
  }

  def score() {
    def score = 0
    def i = 0
    for (int j = 0; j < 10; j++) {
      if (isStrike(i)) {
        score += 10 + strikeBonus(i)
        i += 1
      } else if (isSpare(i)) {
        score += 10 + spareBonus(i)
        i += 2
      } else {
        score += rolls[i] + rolls[i + 1]
        i += 2
      }
    }
    score
  }

  private def isStrike(frameIndex) {
    rolls[frameIndex] == 10
  }

  private def strikeBonus(frameIndex) {
    rolls[frameIndex + 1] + rolls[frameIndex + 2]
  }

  private def isSpare(frameIndex) {
    rolls[frameIndex] + rolls[frameIndex + 1] == 10
  }

  private def spareBonus(frameIndex) {
    rolls[frameIndex + 2]
  }
}
