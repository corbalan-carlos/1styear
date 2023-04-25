{-- a:: (Int,Int) -> String
 case y of   (0,0) -> "FizzBuzz"
                  (_,0) -> "Buzz"
                  (0,_) -> "Fizz"
                  (_,_) -> show y
--}
fizzBuzz:: [String]
fizzBuzz= [(\ y-> case y of (0,0) -> "FizzBuzz"
                            (_,0) -> "Buzz"
                            (0,_) -> "Fizz"
                            (_,_) ->  show x) (mod x 3, mod x 5) |x<-[1..100]] 
