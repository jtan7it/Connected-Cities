# Connected-Cities
Reading from a file storing city pairs and see if two cities are connected

It is a simple program using Spring Boot & Java (1.8) which determines if two cities are connected. Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.
List of roads is available in a file. The file contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.
It will be deployed as a Spring Boot App and expose one endpoint:
http://localhost:8080/connected?origin=city1&destination=city2
Your program should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.
Any unexpected input should result in a ’no’ response.
For Example:
city.txt content is:
Boston, New York
Philadelphia, Newark
Newark, Boston
Trenton, Albany
http://localhost:8080/connected?origin=Boston&destination=Newark
Should return yes
http://localhost:8080/connected?origin=Boston&destination=Philadelphia
Should return yes
http://localhost:8080/connected?origin=Philadelphia&destination=Albany
Should return no

The logic behind the application is very simple, we first of all read the file that stores the city pairs and use in memory HashMap data structure to make a undirected graph.
Then we start from the orign city and travel the graph to see if we can get to the destination city.

Right now the program is reading from a file I manully wrote for demonstrating purpose, if you want to test out your own city pair file you have to change the line 19 in CityController.java
and put your own file path.

The input cities are not case sensitive
