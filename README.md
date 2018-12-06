# INFO6205_215

INFO6205 Final Project: Robotic Controllers

Problem:
The problem is to design the robot controller to walk through the maze and arrive the destination in the end without crashing into the wall. The robot can be controlled by six different direction sensors, three on the front, one on the left, one on the right and one on the back. Each route can be one solution and can be scored, our purpose is to find the fittest solution by comparing the scores until it reaches the termination we set.


Execution:
In this project, we use eclipse as our IDE and we put codes into different package separately, including helper, main, controller, objects and test. The main function is in the Main.java in main package, Controller.java is in controller package, all the test cases are in the test package and all the class we create, including abstract class, are in objects package.
To execute, just run the Main.java and it will use the Controller.java (in controller package) to run our whole GA program. It will print the fittest value and fittest chromosome for each generation. In the end, it will print the route of final fittest solution.