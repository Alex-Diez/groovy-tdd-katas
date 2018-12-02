package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime factors of a prime number contains only the prime number'() {
    when: 'generate prime factors'
      List<Integer> factors = primeFactors.generate(2)

    then: 'factors contains only the prime number'
      factors == [2]
  }

  def 'prime factors of multiplication of two prime numbers contain only those prime numbers'() {
    when: 'generate prime factors from multiplication of prime numbers'
      List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'factors contain only those prime numbers'
      factors == [2, 3]
  }

  def 'prime factors of multiplication of the same prime number on itself contain only the prime number'() {
    when: 'generate prime factors from prime number multiplication on itself'
      List<Integer> factors = primeFactors.generate(3 * 3 * 3)

    then: 'factors contain prime number'
      factors == [3, 3, 3]
  }
}
