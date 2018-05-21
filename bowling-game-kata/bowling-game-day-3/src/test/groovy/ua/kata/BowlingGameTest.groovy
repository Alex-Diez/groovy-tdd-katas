package ua.kata

import spock.lang.Ignore
import spock.lang.Specification

class BowlingGameTest extends Specification {
  def game

  def setup() {
    game = new BowlingGame()
    game.metaClass.rollMany = { times, pin -> (1..times).forEach { delegate.roll(pin) } }
    game.metaClass.rollSpare = { delegate.roll(4); delegate.roll(6) }
    game.metaClass.rollStrike = { delegate.roll(10) }
  }

  def 'gutter game'() {
    when: 'all rolls are zero'
    game.rollMany(20, 0)

    then: 'score is 0'
    game.score() == 0
  }

  def 'all ones'() {
    when: 'all rolls are one'
    game.rollMany(20, 1)

    then: 'score is 20'
    game.score() == 20
  }

  def 'one spare'() {
    when: 'spare rolled'
    game.rollSpare()
    game.roll(3)
    game.rollMany(17, 0)

    then: 'next roll is added as a bonus'
    game.score() == 16
  }

  def 'one strike'() {
    when: 'strike rolled'
    game.rollStrike()
    game.roll(4)
    game.roll(3)
    game.rollMany(16, 0)

    then: 'next two rolls are added as a bonus'
    game.score() == 24
  }

  def 'perfect game'() {
    when: 'all rolls are strikes'
    game.rollMany(12, 10)

    then: 'player gets max score that is 300'
    game.score() == 300
  }
}
