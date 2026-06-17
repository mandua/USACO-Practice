# USACO Solutions
A collection of Java solutions to USACO training problems. Each solution reads input from a .in file and writes output to a .out file, following USACO's standard file I/O format.

## Solutions

### Speeding Ticket (speeding.java)
Compares a road's posted speed limits against the speeds a car actually traveled along each mile, and determines the largest amount by which the car exceeded the limit at any point.

### Friday the Thirteenth (friday.java)
Counts, across a given number of consecutive years starting from 1900, how many times the 13th of a month falls on each day of the week. Accounts for leap years (including century and 400-year leap year rules).

### The Lost Cow (lostcow.java)
Simulates a search pattern where a farmer at a known position looks for a cow at an unknown position along a number line, alternating direction and doubling the search distance each time, and calculates the total distance traveled before finding the cow.


## Notes
- These are solutions to individual training problems, not a unified application — there's no shared entry point or interaction between files.
- Some files include a `BASE_PATH` constant for specifying a custom input/output directory, left as an empty string by default (current directory).
- Written for and tested against USACO's online judge; exact input/output file naming conventions follow USACO's submission requirements.
