package ua.kata

import spock.lang.Specification

class BowlingGameTest extends Specification {
  def game

  def setup() {
    game = new BowlingGame()
  }

  private def rollMany(int times, int pin) {
    (1..times).forEach { game.roll(pin) }
  }

  private def rollSpare() {
    game.roll(4)
    game.roll(6)
  }

  def "gutter game"() {
    when:
    rollMany(20, 0)

    then:
    game.score() == 0
  }

  def "all ones"() {
    when:
    rollMany(20, 1)

    then:
    game.score() == 20
  }

  def "one spare"() {
    when:
    rollSpare()
    game.roll(3)
    rollMany(17, 0)

    then:
    game.score() == 16
  }

  def "one strike"() {
    when:
    game.roll(10)
    game.roll(4)
    game.roll(3)
    rollMany(16, 0)

    then:
    game.score() == 24
  }

  def "prefect game"() {
    when:
    rollMany(12, 10)

    then:
    game.score() == 300
  }
}
