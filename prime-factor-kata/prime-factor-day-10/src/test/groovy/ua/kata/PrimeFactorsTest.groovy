package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime factors of a prime number contain only the prime number'() {
    when: 'generated prime factors'
      List<Integer> factors = primeFactors.generate(2)

    then: 'factors contain only the prime number'
      factors == [2]
  }

  def 'prime factors of a multiplication of two prime numbers contain only those prime numbers'() {
    when: 'generated prime factors'
      List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'factors contain only the prime numbers'
      factors == [2, 3]
  }

  def 'prime factors of a multiplication of the same prime number contain only that prime number many times'() {
    when: 'generated prime factors'
      List<Integer> factors = primeFactors.generate(3 * 3 * 3)

    then: 'factors contain only the prime number many times'
      factors == [3, 3, 3]
  }
}
