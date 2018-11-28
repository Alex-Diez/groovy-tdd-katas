package ua.kata

class PrimeFactors {
  List<Integer> generate(int i) {
    List<Integer> factors = []
    int prime = 2
    while (prime < i) {
      while (i % prime == 0) {
        factors += prime
        i /= prime
      }
      prime += 1
    }
    if (i > 1) {
      factors += i
    }
    factors
  }
}
