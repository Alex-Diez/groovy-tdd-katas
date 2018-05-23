package ua.kata

import spock.lang.Specification


class BowlingGameTest extends Specification {
  private def game

  def setup() {
    game = new BowlingGame()
    game.metaClass.rollMany = { times, pin -> (1..times).forEach { delegate.roll(pin) } }
    game.metaClass.rollSpare = { delegate.roll(4); delegate.roll(6) }
    game.metaClass.rollStrike = { delegate.roll(10) }
  }

  def 'gutter game'() {
    when: 'all rolls are 0'
    game.rollMany(20, 0)

    then: 'score is 0'
    game.score() == 0
  }

  def 'all ones'() {
    when: 'all rolls are 1'
    game.rollMany(20, 1)

    then: 'score is 20'
    game.score() == 20
  }

  def 'one spare'() {
    when: 'spare is rolled'
    game.rollSpare()

    and: 'rolled some pins'
    game.roll(3)
    game.rollMany(17, 0)

    then: 'the next roll after spare is added as bonus'
    game.score() == 16
  }

  def 'one strike'() {
    when: 'strike is rolled'
    game.roll(10)

    and: 'rolled some pins'
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    then: 'the next frame after strike is added as bonus'
    game.score() == 24
  }

  def 'perfect game'() {
    when: 'all frames are strikes'
    game.rollMany(12, 10)

    then: 'score is max - 300'
    game.score() == 300
  }
}
