import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Doug
 */
public class ContainerTest {
    private Container container;
    
    @Before
    public void initialize() {
        container = new Container();
    }
    
    @Test
    public void initialAdd() {
        container.add(50);
        assertEquals("50/100", container.toString());
    }
    
    @Test
    public void removeMoreThanAdded() {
        container.add(50);
        container.remove(60);
        assertEquals("0/100", container.toString());
    }
    
    @Test
    public void addGreaterThanCapacity() {
        container.add(50);
        container.remove(60);
        container.add(200);
        assertEquals("100/100", container.toString());
    }
    
    
}
