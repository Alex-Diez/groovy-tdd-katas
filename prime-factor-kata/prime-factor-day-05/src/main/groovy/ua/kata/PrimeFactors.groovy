package ua.kata

class PrimeFactors {
  List<Integer> generate(int num) {
    List<Integer> factors = []
    int counter = 2
    while (counter <= num) {
      while (num % counter == 0) {
        factors << counter
        num /= counter
      }
      counter += 1
    }
    factors
  }
}
