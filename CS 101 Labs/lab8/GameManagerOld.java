//MAKE LINE 228 in.close() as comment!!!!!!
package lab8;

import java.util.Random;
import java.util.Scanner;



enum Direction {NORTH, EAST, SOUTH, WEST}

/**
 * This class implements a manager for a game where the goal for a player is
 * to reach the bottom right corner of an n x n room, starting from the upper
 * left cornder and avoiding any enemies (monster, bug, etc.)
 * 
 * @author Ugur Dogrusoz
 */
public class GameManagerOld 
{
    // static variables/constants

    public static final Random random = new Random(); 
    private static final int NO_OF_ROWS = 5;
    private static final int NO_OF_COLUMNS = 5;
    private static final int TARGET_X = NO_OF_COLUMNS - 1;
    private static final int TARGET_Y = NO_OF_ROWS - 1;
    private static final int INITIAL_PLAYER_HEALTH = 10;
    private static final int MONSTER_DAMAGE_TO_PLAYER = INITIAL_PLAYER_HEALTH;
    private static final int BUG_DAMAGE_TO_PLAYER = 2;

    // instance variables

    private Player player;
    private Enemy monster;
    private Enemy bug;

    /**
     * Constructor for the Game Manager class
     */
    public GameManagerOld() 
    {
        this.setupGame();
    }

    // getters

    /**
     * @return number of columns of the grid representing the game room
     */
    public static int getNoOfColumns() 
    { 
        return GameManagerOld.NO_OF_COLUMNS;
    }

    /**
     * @return number of rows of the grid representing the game room
     */
    public static int getNoOfRows() 
    { 
        return GameManagerOld.NO_OF_ROWS;
    }

    /**
     * @return the player of this game
     */
    public Player getPlayer() 
    {
        return this.player;
    }

    /**
     * @return the monster of this game
     */
    public Enemy getMonster() 
    {
        return this.monster;
    }

    /**
     * @return the bug of this game
     */
    public Enemy getBug() 
    {
        return this.bug;
    }

    // game setup and playing

    /**
     * This method sets up the game by creating the game objects and
     * positioning them in initial positions (player in upper left corner,
     * monster in the lower right corner and bug in the middle of the room).
     */
    public void setupGame() 
    {
        bug = new Enemy('B');
        monster = new Enemy('M');
        player = new Player('P', INITIAL_PLAYER_HEALTH);

        bug.positionAt((int)(TARGET_X/2+1), (int)(TARGET_Y/2+1) );
        monster.positionAt(TARGET_X, TARGET_Y);
        player.positionAt(0, 0);
    }

    /**
     * This method displays the room and the game objects in their current
     * locations.
     */
    public void displayBoard()
    {
        displayRowSeparator();
 
        for(int y=0; y <= TARGET_Y; y++){
            System.out.print("| ");
            for(int x=0; x <= TARGET_X; x++){

                int spaceToPrint = 2;

                if(monster.getX()== x && monster.getY() == y){
                    System.out.print(monster.getIcon());
                    spaceToPrint--;
                }
                if(player.getX()== x && player.getY() == y){
                    System.out.print(player.getIcon());
                    spaceToPrint--;
                }
                if(bug.getX()== x && bug.getY() == y){
                    System.out.print(bug.getIcon());
                    spaceToPrint--;
                }

                while(spaceToPrint>0){
                    System.out.print(" ");
                    spaceToPrint--;
                }
                System.out.print("| ");
            }
            displayRowSeparator();

        }
        int healthCount = player.getHealth();
        String health = "";
        while(healthCount>0){
            health += "*";
            healthCount--;
        }
        System.out.println("Health: " + health);
        System.out.println("w: up, x: down, d: right, a: left, s: no change, q: quit:");

    }

    /*
     * This method is used by displayBoard to print one line of separator between
     * successive rows.
     */
    private void displayRowSeparator()
    {
        System.out.print("\n-");
        for (int c = 0; c < NO_OF_COLUMNS; c++)
        {
            System.out.print("----");
        }        
        System.out.print("\n");
    }

    /**
     * This method moves all game objects along their current directions.
     * Enemies change directions randomly before moving in the following manner:
     * a monster changes direction randomly with 2 in 3 chance; similary a bug
     * changes direction randomly with 1 in 3 chance.
     */
    public void moveObjects()
    {
        boolean monsterChangesDir = false;
        boolean bugChangesDir = false;
        int dieWith3Sides = GameManagerOld.random.nextInt(0,3);
        if(dieWith3Sides == 0 || dieWith3Sides == 1){
            monsterChangesDir = true;
        }
        if(dieWith3Sides == 0){
            bugChangesDir = true;
        }
        
        if(bugChangesDir == true){
            bug.changeDirection();
        }
        if(monsterChangesDir){
            monster.changeDirection();
        }
      
        monster.move();
        bug.move();
        player.move();
    }

    /**
     * This method handles any collisions of game objects appropriately.
     * When an enemy is in the same location as the player, he will lose
     * health by an amount defined as a constant in this class according to
     * the enemy type. Current values mean a collision with a monster will
     * make you lose the game, where a collision with a bug will decrease
     * your health a little.
     */
    public void handleCollisions()
    {
        if(doCoordsMatch (bug.getX(), bug.getY(), player.getX(),  player.getY())){
            player.loseHeath(BUG_DAMAGE_TO_PLAYER);
        }
        if(doCoordsMatch (monster.getX(), monster.getY(), player.getX(),  player.getY())){
            player.loseHeath(MONSTER_DAMAGE_TO_PLAYER);
        }
 
    }

    // utility methods

    /**
     * This method reads user input. The user has the choice to quit or provide
     * a new direction for the player. They also have the option to keep the 
     * current direction.
     * 
     * @return the input character
     */
    public char readDirection()
    {
        Scanner in = new Scanner(System.in);
        char userInput = in.next().charAt(0);
        in.nextLine();
        in.close();
        return userInput;
    }

    /**
     * This method checks whether or not the given two corrdinates match.
     */
    public static boolean doCoordsMatch(int x1, int y1, int x2, int y2)
    {
        if(x1 == x2 && y1 == y2){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method converts a direction provided as an integer into one with
     * the enumeration type Direction.
     * 
     * @param directionInt input integer direction (0, 1, 2, 3)
     * @return returns corresponding enum value (NORTH, SOUTH, EAST, WEST)
     */
    public static Direction intToDirection(int directionInt)
    {
        if (directionInt == 0) 
        {
            return Direction.NORTH;
        }
        else if (directionInt == 1) 
        {
            return Direction.SOUTH;
        }
        else if (directionInt == 2) 
        {
            return Direction.EAST;
        }
        else 
        { // 3
            return Direction.WEST;
        }
    }

    /**
     * This method converts a direction provided as a character into one with
     * the enumeration type Direction.
     * 
     * @param directionChar input character direction ('w', 'x', 'd', 'a')
     * @return returns corresponding enum value (NORTH, SOUTH, EAST, WEST)
     */

    public static Direction charToDirection(char directionChar)
    {
        if (directionChar == 'w') 
        {
            return Direction.NORTH;
        }
        else if (directionChar == 'x') 
        {
            return Direction.SOUTH;
        }
        else if (directionChar == 'd') 
        {
            return Direction.EAST;
        }
        else 
        { // 'a'
            return Direction.WEST;
        }
    }

    /**
     * This method checks whether or not the player reached the target location
     * defined as a constant by this class.
     */
    public boolean isTargetReached()
    {
        if(player.getX() == TARGET_X && player.getY() == TARGET_Y){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * This method checks whether or not the game is over. Game is over in two
     * ways. If the player loses its health (a loss) or the player reaches its target.
     */
    public boolean isGameOver()
    {
        if(player.isHealthy() == false){
            return true;
        }
        if(isTargetReached() == true){
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        GameManagerOld gm = new GameManagerOld();
        Player player = gm.getPlayer();
        char dirChar = 's'; // to get the game loop started

        // initial configuration
        gm.displayBoard();

        // game loop
        while (!gm.isGameOver() && dirChar != 'q') {            
            dirChar = gm.readDirection();
            if (dirChar != 's' && dirChar != 'q')
            {
                player.changeDirection(GameManagerOld.charToDirection(dirChar));
            }

            gm.moveObjects();
            gm.handleCollisions();
            gm.displayBoard();
        }

        // report the result
        if (dirChar == 'q')
        {
            System.out.println("\nCome back and play again!!!");
        }
        else if (gm.player.isHealthy()) 
        {
            System.out.println("\nPlayer wins!!!");
        }
        else 
        {
            System.out.println("\nPlayer loses!!!");
        }
    }
}