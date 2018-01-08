# communities-detection
You have input a file for determine the connection of nodes of people that named by numbers. You can achieve the cluster of communities in output. 

befor execute program must download hadoop and run in your machine (my version was 3.0.0).
create jar file of project and execute on hadoop

su - hadoop
scp master@localhost:/Users/master/communities-detection.jar ~/Desktop
/Users/hadoop/Documents/hadoop-3.0.0/bin/hadoop fs -rm -r output
/Users/hadoop/Documents/hadoop-3.0.0/bin/hadoop jar ~/Desktop/communities-detection.jar graph/Main input output

Assume that hadoop install on hadoop user
in output file you will see the edges with their betweenness of them. betweenness of edge means the count of x, y nodes in graph that the shortest ways for navigation those nodes contains that edge thus edges with higher betweenness should be deleted if we want cluster that graph. in GraphView you will see any edges with higher betweenness of 1000 deleted.

