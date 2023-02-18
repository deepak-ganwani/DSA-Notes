/*

Space Complexity is not constant in Recursion (because of the recursive calls)
Functions take memory in stack thats why
- Base condition is obtained from the answers we already have
- If u don't have a base condtion it might result to stack-overflow


---Identifying Problems Involving Recursion:---

~ If the problem can be broken into smaller parts
Eg: Finding the n-th Fibonacci Term
    To find the n-th term we have to start with the 3rd term followed by 4th and so on
    Which are in turn obtained through previous results
    Fib(N)=Fib(N-1)+Fib(N-2)
~~~(The formula obtained for any question is called recerrence relation)

-> If the problem is breakable into smaller parts
-> Write the recurring relation, if needed
-> Draw the recursive tree
-> About the tree:
    -> See the flow of functions (How they are getting in stack)
    -> Identify and focus on left tree calls and right tree calls
        (Left tree first followed by the right tree -> Know the working of
        Stack and the flow of operation in the recursion tree)
    -> Draw the tree using pointers for better understanding and use debugger
-> See how the values are returned at each step
-> See where the function call will come out of
-> At the end, you'll come out of the main function


---Types of Recurrence Relations---
1 -> Linear Recurrence Relation (Eg: Fibonnaci Numbers >>> Fib(N)=Fib(N-1)+Fib(N-2))
// Because the space is reduced linearly (Here, by 1)

2 -> Divide and Conquer Relation (Eg: Binary Search >>> F(N) = O(1)(Compare) + F(N/2))
// Because the search space is divided by a factor (Here, by 2)

Divide and conquer is thus faster and more efficient
Like for smaller numbers like 50 in fibonacci series programme would take
a lot of time to run and many small parts of the binary trees are repeated
All the repeated trees are calculated again and again
and there are many such trees being repeated, so it takes a lot of time
Solution to this: Dynamic Programming
(Store answer to smaller trees so that when they are required again time isn't wasted in calculating)
Dynamic Programming + Recursion ->>> Hot Interview Topic


---Important Note: Structure of the function---
(Refer to the RecursiveBinarySearch code for better understanding)
The Variables:
1 -> Arguments
    Some Variables are passed in the function as Arguments
    The argument of the function must contain all those variables 
    Which would be passed on to the next recursive function during the call
    Which would be required for the function to run again depending on the previous value

2 -> Return Type
    Know how u want to return and how you would be using in the main function
    - Always ensure that there is a return statement in the function
    So that the function always lands back to Main Function
    (When the return type isn't void and you tend to call the function again for recursion
    Just return call the function) (Eg: return fib(n-1)+fib(n-2);)

3 -> Body of the function
    The variables in the body of the function must be those variables
    Which might be formed through the arguments or the variables
    Which are specific to the current process (or that call)
    (Basically whose value doesn't depend on the previous process)

 */