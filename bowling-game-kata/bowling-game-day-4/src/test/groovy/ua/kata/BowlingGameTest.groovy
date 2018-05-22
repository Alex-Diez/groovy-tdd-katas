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
    when: 'rolled all zeros'
    game.rollMany(20, 0)

    then: 'game\'s score is 0'
    game.score() == 0
  }

  def 'all ones'() {
    when: 'rolled all ones'
    game.rollMany(20, 1)

    then: 'game\'s score is 20'
    game.score() == 20
  }

  def 'one spare'() {
    when: 'spare is rolled'
    game.rollSpare()
    and: 'three pins rolled in the next roll'
    game.roll(3)
    game.rollMany(17, 0)

    then: 'next roll after spare added as bonus'
    game.score() == 16
  }

  def 'one strike'() {
    when: 'strike is rolled'
    game.rollStrike()
    and: 'seven pins rolled in the next two rolls'
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    then: 'next two rolls after strike added as bonus'
    game.score() == 24
  }

  def 'perfect game'() {
    when: 'all frames are strikes'
    game.rollMany(12, 10)

    then: 'game has max score - 300'
    game.score() == 300
  }
}
