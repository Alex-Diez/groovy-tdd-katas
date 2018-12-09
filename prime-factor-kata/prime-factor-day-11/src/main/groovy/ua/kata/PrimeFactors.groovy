package ua.kata

class PrimeFactors {
  List<Integer> generate(int num) {
    List<Integer> factors = []
    int count = 2
    while (count <= num) {
      while (num % count == 0) {
        factors << count
        num /= count
      }
      count += 1
    }
    factors
  }
}
