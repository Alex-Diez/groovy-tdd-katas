package ua.kata

import java.util.stream.Collectors

class FizzBuzz {
  List<String> fizzBuzz(List<Integer> nums) {
    return nums.stream().map({ n -> toFizzBuzz(n) }).collect(Collectors.toList());
  }

  private String toFizzBuzz(int n) {
    String v = ''
    if (n % 3 == 0) v += 'fizz'
    if (n % 5 == 0) v += 'buzz'
    if (v.empty) return n.toString()
    return v
  }
}
