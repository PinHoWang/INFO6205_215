package neu.edu.info6205.team.objects;

import java.util.ArrayList;

public class Robot {

	private int xPos;
    private int yPos;
    private String heading;
    int maxMoves;
    int moves;
    private int sensorVal;
    private final int sensorActions[];
    private Maze m;
    private ArrayList<int[]> way;
    
    public Robot(int[] actions, Maze m, int maxMove) {
    	this.sensorActions = this.calcSensor(actions);
        this.m = m;
        int startPos[] = this.m.getStartPosition();
        this.xPos = startPos[0];
        this.yPos = startPos[1];
        this.sensorVal = -1;
        this.heading = "EAST";
        this.maxMoves = maxMoves;
        this.moves = 0;
        this.way = new ArrayList<int[]>();
        this.way.add(startPos);
    }
    
    public void run() {
        while(true){            
            this.moves++;
            
            // Robot stops moving
            if (this.getNextAction() == 0) {
                return;
            }

            // Reach the goal
            if (this.m.getPositionValue(this.xPos, this.yPos) == 4) {
                return;
            }
            
            // Reach a maximum number of moves
            if (this.moves > this.maxMoves) {
                return;
            }

            // Run action
            this.nextAction();
        }
    }
    
    private int[] calcSensor(int[] sensorActions){
        // How many actions are there?
        int numActions = (int) sensorActions.length / 2;
        int actions[] = new int[numActions];
        
  
        // 0: do nothing, 1: move forward, 2: turn left, 3: turn right
        for (int i = 0; i < numActions; i++){
            // Get sensor action
            int action = 0;
            if (sensorActions[i*2] == 1){
            	action += 2;
            }
            if (sensorActions[(i*2)+1] == 1){
            	action += 1;
            }
            
            // Add to sensor-action map
            sensorActions[i] = action;
        }
      
        return sensorActions;
    }
    
    public void nextAction() {
        // If move forward
        if (this.getNextAction() == 1) {
            int currentX = this.xPos;
            int currentY = this.yPos;
            
            // Move depending on current direction
            if (this.heading == "NORTH") {
                this.yPos += -1;
                if (this.yPos < 0) {
                    this.yPos = 0;
                }
            }
            else if (this.heading == "EAST") {
                this.xPos += 1;
                if (this.xPos > this.m.getMaxX()) {
                    this.xPos = this.m.getMaxX();
                }
            }
            else if (this.heading == "SOUTH") {
                this.yPos += 1;
                if (this.yPos > this.m.getMaxY()) {
                    this.yPos = this.m.getMaxY();
                }
            }
            else if (this.heading == "WEST") {
                this.xPos += -1;
                if (this.xPos < 0) {
                    this.xPos = 0;
                }
            }
            
            // We can't move here
            if (this.m.isWall(this.xPos, this.yPos) == true) {
                this.xPos = currentX;
                this.yPos = currentY;
            } 
            else {
                if(currentX != this.xPos || currentY != this.yPos) {
                    this.way.add(this.getPosition());
                }
            }
        }
        // Move clockwise
        else if(this.getNextAction() == 2) {
            if (this.heading == "NORTH") {
                this.heading = "EAST";
            }
            else if (this.heading == "EAST") {
                this.heading = "SOUTH";
            }
            else if (this.heading == "SOUTH") {
                this.heading = "WEST";
            }
            else if (this.heading == "WEST") {
                this.heading = "NORTH";
            }
        }
        // Move anti-clockwise
        else if(this.getNextAction() == 3) {
            if (this.heading == "NORTH") {
                this.heading = "WEST";
            }
            else if (this.heading == "EAST") {
                this.heading = "NORTH";
            }
            else if (this.heading == "SOUTH") {
                this.heading = "EAST";
            }
            else if (this.heading == "WEST") {
                this.heading = "SOUTH";
            }
        }
        
        // Reset sensor value
        this.sensorVal = -1;
    }
    
    public int getSensorValue(){
        // If sensor value has already been calculated
        if (this.sensorVal > -1) {
            return this.sensorVal;
        }
                
		boolean frontSensor, frontLeftSensor, frontRightSensor, leftSensor, rightSensor, backSensor;
		frontSensor = frontLeftSensor = frontRightSensor = leftSensor = rightSensor = backSensor = false;

        // Find which sensors have been activated
        if (this.getHeading() == "NORTH") {
            frontSensor = this.m.isWall(this.xPos, this.yPos-1);
            frontLeftSensor = this.m.isWall(this.xPos-1, this.yPos-1);
            frontRightSensor = this.m.isWall(this.xPos+1, this.yPos-1);
            leftSensor = this.m.isWall(this.xPos-1, this.yPos);
            rightSensor = this.m.isWall(this.xPos+1, this.yPos);
            backSensor = this.m.isWall(this.xPos, this.yPos+1);
        }
        else if (this.getHeading() == "EAST") {
            frontSensor = this.m.isWall(this.xPos+1, this.yPos);
            frontLeftSensor = this.m.isWall(this.xPos+1, this.yPos-1);
            frontRightSensor = this.m.isWall(this.xPos+1, this.yPos+1);
            leftSensor = this.m.isWall(this.xPos, this.yPos-1);
            rightSensor = this.m.isWall(this.xPos, this.yPos+1);
            backSensor = this.m.isWall(this.xPos-1, this.yPos);
        }
        else if (this.getHeading() == "SOUTH") {
            frontSensor = this.m.isWall(this.xPos, this.yPos+1);
            frontLeftSensor = this.m.isWall(this.xPos+1, this.yPos+1);
            frontRightSensor = this.m.isWall(this.xPos-1, this.yPos+1);
            leftSensor = this.m.isWall(this.xPos+1, this.yPos);
            rightSensor = this.m.isWall(this.xPos-1, this.yPos);
            backSensor = this.m.isWall(this.xPos, this.yPos-1);
        }
        else {
            frontSensor = this.m.isWall(this.xPos-1, this.yPos);
            frontLeftSensor = this.m.isWall(this.xPos-1, this.yPos+1);
            frontRightSensor = this.m.isWall(this.xPos-1, this.yPos-1);
            leftSensor = this.m.isWall(this.xPos, this.yPos+1);
            rightSensor = this.m.isWall(this.xPos, this.yPos-1);
            backSensor = this.m.isWall(this.xPos+1, this.yPos);
        }
                
        // Calculate sensor value
        int sensorVal = 0;
        
        if (frontSensor == true) {
            sensorVal += 1;
        }
        if (frontLeftSensor == true) {
            sensorVal += 2;
        }
        if (frontRightSensor == true) {
            sensorVal += 4;
        }
        if (leftSensor == true) {
            sensorVal += 8;
        }
        if (rightSensor == true) {
            sensorVal += 16;
        }
        if (backSensor == true) {
            sensorVal += 32;
        }

        this.sensorVal = sensorVal;

        return sensorVal;
    }
    
    public int getNextAction() {
        return this.sensorActions[this.getSensorValue()];
    }
    
    public int[] getPosition(){
        return new int[]{this.xPos, this.yPos};
    }
    
    private String getHeading(){
        return this.heading;
    }
    
    public ArrayList<int[]> getWay(){       
        return this.way;
    }
}
