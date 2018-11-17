package ua.kata

class FizzBuzz {
  List<String> fizzBuzz(List<Integer> numbers) {
    numbers.collect({
      n ->
        String s = ''
        if (n % 3 == 0) s += 'fizz'
        if (n % 5 == 0) s += 'buzz'

        if (s.empty) n.toString()
        else s
    })
  }
}
