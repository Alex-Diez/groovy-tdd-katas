package ua.kata

import spock.lang.Specification

class PrimeFactorsTest extends Specification {
  private PrimeFactors primeFactors

  def setup() {
    primeFactors = new PrimeFactors()
  }

  def 'prime factors of a prime number contain only the prime number'() {
    when: 'generated prime factors for a prime number'
    List<Integer> factors = primeFactors.generate(2)

    then: 'factors contain only the prime number'
    factors == [2]
  }

  def 'prime factors of multiplication of two prime numbers contain those prime numbers'() {
    when: 'generated prime factors of multiplication of two prime numbers'
    List<Integer> factors = primeFactors.generate(2 * 3)

    then: 'factors contain only those prime numbers'
    factors == [2, 3]
  }

  def 'prime factors of multiplication of the same prime number contain the prime number many times'() {
    when: 'generated prime factors of multiplication of prime number'
    List<Integer> factors = primeFactors.generate(3 * 3 * 3)

    then: 'factors contain the prime number many times'
    factors == [3, 3, 3]
  }
}
