package ua.kata

import spock.lang.Specification

class FizzBuzzTest extends Specification {
  private FizzBuzz fizzBuzz

  def setup() {
    fizzBuzz = new FizzBuzz()
  }

  def 'fizz buzz an empty list'() {
    when: 'fizz buzz a list'
    List<String> result = fizzBuzz.fizzBuzz([])

    then: 'result list is empty'
    result == []
  }

  def 'fizz buzz a list with a number that is not divisible by 3 nor 5'() {
    when: 'fizz buzz a list'
    List<String> result = fizzBuzz.fizzBuzz([1])

    then: 'result list contains stringified number'
    result == ['1']
  }

  def 'fizz buzz a list with a number that is divisible by 3'() {
    when: 'fizz buzz a list'
    List<String> result = fizzBuzz.fizzBuzz([3])

    then: 'result list contains "fizz"'
    result == ['fizz']
  }

  def 'fizz buzz a list with a number that is divisible by 5'() {
    when: 'fizz buzz a list'
    List<String> result = fizzBuzz.fizzBuzz([5])

    then: 'result list contains "buzz"'
    result == ['buzz']
  }

  def 'fizz buzz a list with a number that is divisible by 3 and 5'() {
    when: 'fizz buzz a list'
    List<String> result = fizzBuzz.fizzBuzz([3 * 5])

    then: 'result list contains "fizzbuzz"'
    result == ['fizzbuzz']
  }
}
