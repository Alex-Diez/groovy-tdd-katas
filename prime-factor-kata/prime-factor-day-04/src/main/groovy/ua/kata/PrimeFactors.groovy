package ua.kata

class PrimeFactors {

  List<Integer> generate(int num) {
    List<Integer> factors = []
    int prime = 2
    while (prime <= num) {
      while (num % prime == 0) {
        factors << prime
        num /= prime
      }
      prime += 1
    }
    factors
  }
}
