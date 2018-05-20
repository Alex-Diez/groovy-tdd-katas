package ua.kata

import spock.lang.Specification

class BowlingGameTest extends Specification {
  private def game

  def setup() {
    game = new BowlingGame()

    game.metaClass.rollMany = { times, pin ->
      (1..times).forEach { delegate.roll(pin) }
    }
    game.metaClass.rollSpare = {
      delegate.roll(4)
      delegate.roll(6)
    }
    game.metaClass.rollStrike = {
      delegate.roll(10)
    }
  }

  def 'gutter game'() {
    when:
    game.rollMany(20, 0)

    then:
    game.score() == 0
  }

  def 'all ones'() {
    when:
    game.rollMany(20, 1)

    then:
    game.score() == 20
  }

  def 'one spare'() {
    when:
    game.rollSpare()
    game.roll(3)
    game.rollMany(17, 0)

    then:
    game.score() == 16
  }

  def 'one strike'() {
    when:
    game.rollStrike()
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    then:
    game.score() == 24
  }

  def 'perfect game'() {
    when:
    game.rollMany(12, 10)

    then:
    game.score() == 300
  }
}
