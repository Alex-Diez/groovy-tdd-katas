package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime factors of a prime number is the prime number'() {
    when: 'prime factors generated'
    List<Integer> factors = primeFactors.generate(2);

    then: 'prime factors contain only the prime number'
    factors == [2]
  }

  def 'prime factors of multiplication of two prime numbers'() {
    when: 'prime factors generated'
    List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'prime factors contain both prime numbers'
    factors == [2, 3]
  }

  def 'prime factors of multiplication prime number on itself'() {
    when: 'prime factors generated'
    List<Integer> factors = primeFactors.generate(3 * 3)

    then: 'prime factors contain prime number two times'
    factors == [3, 3]
  }

  def 'prime factors of 12'() {
    when: 'prime factors generated'
    List<Integer> factors = primeFactors.generate(12)

    then: 'prime factors contain 2, 2, 3'
    factors == [2, 2, 3]
  }
}
