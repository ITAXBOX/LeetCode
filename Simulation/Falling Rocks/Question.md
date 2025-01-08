Given a cave structure as a matrix with dots "." representing empty spaces, "#" representing walls and a "+" sign representing a source.

On each iteration, a rock is thrown from the source into the cave.

Rocks always fall if possible.
=> If the tile immediately below is blocked (by rock or wall), the rock attempts to instead move diagonally down to the left.
=> If the down left tile is also blocked, the rock attempts to instead move diagonally down to the right.
=> Rocks keeps moving as long as it is able to do so, at each step trying to move down, then down-left, then down-right.
=> If all three possible destinations are blocked, the rock and no longer moves, at which point the next rock is created back at the source.

Your task is to create a program that reads the matrix from the standard input and determine the number of rocks that is needed until rocks start falling outside the bounds of the matrix.

Sample Input/Output:

Please check the attached document for a sample test case with explanation.

Constraints: There will always be a valid answer.
1 <= rows <= 100
1 <= cols <= 100
