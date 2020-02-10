package algotithm.mazeProblem;

import org.junit.Test;

public class MazeTest {
	@Test
	public void test1(){
		Maze maze = new Maze();
		maze.init();
		maze.findPath();
		maze.result_dispaly();
	}
}
