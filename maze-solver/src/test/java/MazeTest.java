import mazesolver.domain.Maze;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.FileWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class MazeTest {
        @Rule   
        public TemporaryFolder testFolder = new TemporaryFolder();
        Maze maze;
        File asciiFile;
        
        @Before
        public void setUp() throws Exception {
            asciiFile = testFolder.newFile("asciiFile.txt");
            
            try (FileWriter file = new FileWriter(asciiFile.getAbsolutePath())) {
                file.write("@@@@@@@@@\n");
                file.write("@S......@\n");
                file.write("@.@@.@@.@\n");
                file.write("@.@@@@@.@\n");
                file.write("@..F@@..@\n");
                file.write("@@@@@@@@@\n");
            }
            
            
            
            maze = new Maze(9, 6, asciiFile.getAbsolutePath());
        }
        
        @Test
        public void mazeIsCorrectlyReadFromFile() {           
            assertEquals(9, maze.getMaze().length);
            assertEquals(6, maze.getMaze()[0].length);
        }
        
        @Test
        public void startAndEndAreCorrectlyPlacedInArray() {
            assertEquals('S', maze.getMaze()[1][1]);
            assertEquals('F', maze.getMaze()[4][3]);
        }
        
        @Test
        public void correctAmountOfDeadends() {
            maze.findDeadends(); 
            assertEquals(maze.getDeadends().size(), 2);
        
        }

        
        @After
        public void tearDown() {
            asciiFile.delete();
        }
    
}
