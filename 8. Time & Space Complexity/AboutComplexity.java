/* (Time: 3;   Space: 69;   Recursive Algorithms: 81;   Calculation: 87)

~~~ Time Complexity: 
    A function that tells us how the time grows as input grows
    We only care about the relationship of the time with the data
    (Time Complexity != Time Taken for the programme to run)


--- Analyzing Time Complexity ---
1 -> Always look for worst case Complexity (We consider bigger/infinite Data)
        This is because on smaller data even though some complexities might 
        be better but the overall time taken would be so small that any
        complexity would be just fine.
2 -> Since we only want the relation, we ignore the constants
        Eg: y=2x; y=4x; y=3x+5
        They have the same Time Complexity of O(N) -> Linear Complexity
3 -> Ignore the less dominating terms
        Eg: If Time Complexity is O(N^3+log(N))
        For a very big data log(N) value is negligible,
        Therefore, time complexity is O(N^3)


--- Best Complexities ---
O(1) (Constant) < O(log(N)) < O(N) < O(N*log(N)) < O(2^N) (Exponential)

Exponential is very very bad
In recurring fibonacci numbers code it takes approximately O(2^N) time complexity
That is why even for input like 30, getting an answer takes a lot of time


--- Big-Oh Notation ---
The upper bound of the graph, the complexity of the algorithm won't excede this
Mathematically: 
                f(N)= O(g(N))    
        lim (N->Infinity) f(N)/g(N) < Infinity


--- Big-Omega Notation --- (Usually not used as Oh notation gives for the worst case)
Opposite of Big-Oh
It is the lower bound (Minimum this time complexity would be required for the graph)
Mathematically: 
                    f(N)= w(g(N))    
        lim (N->Infinity) f(N)/g(N) > 0
        

--- Big-Theta Notation ---
Combination of both
Mathematically: 
                    f(N)= O(g(N)) //Replace O with theta symbol   
        0 < lim (N->Infinity) f(N)/g(N) < Infinity
    
    Eg: Theta (N^2) -> Both upper and Lower Bound = N^2


--- Little-Oh Notation --- (Stronger Statement)
Also gives the upper bound, but is not the strict upper bound
Consider: f(N)=O(g(N))
Big-Oh: f<=g
Lit-Oh: f<g (strictly)
Mathematically:
        lim (N->Infinity) f(N)/g(N) = 0


~Similar for little-Omega Notation
Mathematically:
        lim (N->Infinity) f(N)/g(N) = Infinity


~~~ Space Complexity
Space Complexity = Input Space + Auxillary Space (Temp. space taken by Algo.)
We only talk about Auxillary Space
Eg: Binary Search has Constant space complexity
    Everytime the algorithm runs for different size of arrays we only need 
    3 extra variable viz. start, end, mid
    Therefore it is constant. 
    
    If we create/copy into a new array space complexity won't be constant it would depend 
    on the input array size so O(N) complexity


~~~ Recursive Algorithms
Function Calls are stored in Stack. So the Space Complexity isn't constant.
Space Complexity = O(N) -> Longest Path or Height of the Tree
2 Types of Recursion: 1 -> Linear (Fibonacci Numbers)   2 -> Divide and Conquer (Binary Search)


~~~ Getting the Complexity:
1) Divide & Conquer Recurrence:
        Form: 
                T(x)= a1*T(b1*x+k1(x))+a2*T(b2*x+k2(x))+...+an*T(bn*x+kn(x)) + G(x) for all x>x0 x->constant

                a1,a2,...an -> real numbers
                b1,b2,...bn -> real numbers
                k1(x),k2(x),...kn(x) -> Some functions of x

        1 -> Masters Theorem (Not the best way (You'll learn this in the B.Tech course))
                (It is not that efficient as you have to think of all the multiple cases)

        2 -> Plug and Chug (Not the best way (You'll learn this in the B.Tech course))
                Basically, you'll be given the formula say F(N)=F(N/2)+K, get the formula for F(N/2) and so on and solve

        3 -> Akra Bazzi Formula (BEST WAY TO CALCULATE)
                T(x)= Theta{ x^p + x^p * Intergral(1 to x)[G(u)/u^(p+1)) du] }

                a1*(b1^p)+a2*(b2^p)+...+an*(bn^p)=1

        Steps:
                T(N) would be given with the recurrence relation
                Get a1, b1, etc. 
                Get the value of P
                Substitute
                Get the function of theta

                If you can't find the value of P?
                You would land up in a case where k<P<k+1
                Then:
                        If k+1 < power of G(x) then 
                        Ans=O(G(x))

2) Linear Recurrence:
        Form: (Homogeneous cause there is no G(x), all the terms are F(x))
                F(x)= a1*F(x-1)+a2*F(x-2)+...+an*F(x-n)

                a1,a2,...an -> real numbers
                n -> order of recurrence (fixed)
        
        Steps:
                In the given recurrence relation put F(x) as t^n for some constant t
                Eg:     Lets say, F(N)=F(N-1)+F(N-2) (Fibonacci Numbers)
                        t^n=t^(n-1)+t^(n-2)
                        Solve the equation (Here, Divide throughout by t^(n-2) -> quadratic equation)
                        Get the value(s) of t
                
                Rewrite the equation with the roots(values) of t (consider k roots)
                        F(N)=c1*t1+c2*t2+...ck*tk
                        c1, c2,...ck -> constants
                        {
                                In case of common roots:
                                If t is common root repeated r times
                                then: t^n, n*(t^n), (n^2)*(t^n), (n^3)*(t^n),...(n^(r-1)*(t^n) are all the other roots
                        }

                Number of roots you've = Number of Answers you already know
                        In case of Fibonacci, we know F(0)=0 & F(1)=1
                Thus, get the values of constants 
                Put in the equation and get the function
                Ignore the less dominating terms and constants
                Get the time complexity
        
3) Non-Homogeneous Recurrence Relation:
        Form:
                F(n)= a1*F(n-1)+a2*F(n-2)+...+ad*F(n-d) + G(x)
                a1,a2,...ad -> real numbers
                d -> order of recurrence (fixed)

        Steps:
                Replace G(x) by 0 and solve by previous approach
                Get the Homogeneous solution F1(x)
                Put G(x) on one send (RHS and rest all terms on LHS) and find the particular solution F2(x)
                Guess something that is similar to G(x)
                        Eg: If G(x) = 3^x, guess a polynomial of degree 2
                        Guess: F(x)=c*(3^x)
                        Solve and get c and get the particular solution
                Add both the solution (Homo+general)
                f(x)=f1(x)+f2(x)
                Get the constants of homogeneous solutions by putting the known values

                How to guess a solution?
                If G(x) is exponential, guess of same type
                        Eg: G(x)=2^n + 3^n
                        Guess: F(x)=a*(2^n) + b*(3^n)
                If G(x) is polynomial guess of degree 2
                        Eg: G(x)=x^2 - 1
                        Guess: F(x)=a*(x^2)+b*x+c
                In case of a combination, merge both
                        Eg: G(x)=2^x + x
                        Guess: F(x)=a*(2^x) + b*x + c
                
        Lets say that you guessed F(x)= a*(2^x) and it fails
        Next guess should be F(x)=(ax+b)*(2^x) and if this fails increase the degree of the mulitplying term again

*/