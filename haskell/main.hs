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
maximum' :: (Ord a) => [a] -> a
maximum' [] = error "uh oh"
maximum' [x] =  x
maximum' (x:xs) 
    | x > maxTail = x
    |otherwise = maxTail
    where maxTail = maximum' xs

replicate' :: Int -> Int -> [Int]
replicate' _ 0 = []
replicate' x y 
    |y > 0 = x : replicate' x (y-1)
    |otherwise= error "uh oh"

take' :: Int -> [a] -> [a]
take' 0 _ = []
take' y (x:xs)  
    | y<0 = error "uh oh"
    | otherwise = x:take' (y-1) xs
take' _ [] = []

reverse' :: [a] -> [a]
reverse' [] = []
reverse'  [x] = [x]
reverse' (x:xs) = (reverse' xs)++x:[]

zip' :: [b]-> [a] -> [(b,a)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y):zip' xs ys

remove' :: Int -> [a] -> [a]
remove' _ [] = []
remove'  y (x:xs) 
    | y==0= xs
    |otherwise = x: remove' (y-1) xs

quicksort:: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    let a=quicksort [ y| y<-xs, y<x]
        b=quicksort [ y| y<-xs, y>x]
    in a++[x]++b
