#Dynamic Programing 
#Assembly Line Problem
##Author: Aunn Raza | BSCS2B | 01248
##Github: http://www.github.com/syedaunn/assemblyLineAlgorithm

###Reference:  Sec: Dynamic Programing , Introduction to Algorithms (2nd edition)  By C.L.R.S

Assembly Line Problem is an optimization (specifically minimization) problem whose optimal solution can be attained by dynamic programming methodology in linear [O(n)] time while checking each combination can take exponential [O(2n)] time.

Currently, Assembly Line algorithm is implemented in Java for two assembly lines with n number of stations each. Lines are represented in an integer array with line 1 at index 0 and line 2 at index 1.

Solution of Assembly Line problem is obtained by Fastest Way Algorithm which works on the principles of dynamic programming i.e. solving dependent sub-problems, storing the result and reusing the result to solve greater problem. In the end, optionally, path can be constructed through back-tracing the indexes of the stations taken for shortest route.

Currently, Implemented methods includes
•	FastestWayAlgo
•	DisplayPath

##Testing (JUnit Test Cases)
 
Implemented fastest way algorithm was unit tested against different known pseudo inputs and shortest path and its cost was asserted against the actual output. Moreover, Error handling was also tested by providing erroneous arguments i.e. mismatching number of station times, number of stations and transfer times.

