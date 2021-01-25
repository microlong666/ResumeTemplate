import bean.User;
import org.junit.Test;
import service.DBService;

public class DBServiceTest {

    @Test
    public void userInsert(){
        User user = new User("1",18,"1","1","1","1","1","1","1","1","1");
        DBService.insertUser(user);
    }
}