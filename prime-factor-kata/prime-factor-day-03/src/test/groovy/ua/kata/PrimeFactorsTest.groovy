package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime factors of a prime number contain only the prime number'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(2)

    then: 'factors contain only the prime number'
    factors == [2]
  }

  def 'prime factors of a multiplication of two prime numbers contain only two of them'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'factors contain two of the prime numbers'
    factors == [2, 3]
  }

  def 'prime factors of a multiplication a prime number on itself contain the prime number twice'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(3 * 3)

    then: 'factors contain the prime number two times'
    factors == [3, 3]
  }

  def 'prime factors of three multiplication a prime number on itself contain the prime number three times'() {
    when: 'generate prime factors'
    List<Integer> factors = primeFactors.generate(3 * 3 * 3)

    then: 'factors contain the prime number three times'
    factors == [3, 3, 3]
  }
}
