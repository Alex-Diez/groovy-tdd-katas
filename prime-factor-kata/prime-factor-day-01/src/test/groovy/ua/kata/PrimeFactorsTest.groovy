package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime number is prime factor of itself'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(2)

    then: 'factors has only the prime number'
    factors == [2]
  }

  def 'doubled prime number has two prime factors of itself'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'factors has prime number and 2'
    factors == [2, 3]
  }

  def 'multiplication of prime number on itself'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(3 * 3)

    then: 'factors has same prime number two times'
    factors == [3, 3]
  }

  def 'prime factor of 12'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(12)

    then: 'factors has 2, 2, 3'
    factors == [2, 2, 3]
  }
}
