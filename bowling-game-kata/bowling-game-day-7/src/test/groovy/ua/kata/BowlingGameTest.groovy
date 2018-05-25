package ua.kata

import spock.lang.Ignore
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
    when: 'spare rolled'
    game.rollSpare()

    and: 'some pins rolled in the next roll'
    game.roll(3)
    game.rollMany(17, 0)

    then: 'the next roll after spare added as bonus'
    game.score() == (10 + 3) + 3
  }

  def 'one strike'() {
    when: 'strike rolled'
    game.rollStrike()

    and: 'some pins rolled in the next two rolls'
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    then: 'the next two rolls after strike added as bonus'
    game.score() == (10 + 4 + 3) + 4 + 3
  }

  def 'perfect game'() {
    when: 'all rolls are strikes'
    game.rollMany(12, 10)

    then: 'score is max - 300'
    game.score() == 300
  }
}
