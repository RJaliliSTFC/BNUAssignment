import static org.junit.Assert.*;
import org.junit.Test;

public class UserListTest {

    @Test
    public void testAddUser() {
        UserList userList = new UserList();
        User user = new User("John", "password");
        userList.add(user);
        assertTrue(userList.checkExists("John"));
    }

    @Test
    public void testViewUserList() {
        UserList userList = new UserList();
        User user1 = new User("John", "password");
        User user2 = new User("Alice", "password");
        userList.add(user1);
        userList.add(user2);
        assertEquals("test", userList.viewUserList());
    }

    @Test
    public void testDeleteUser() {
        UserList Users = new UserList();
        User user = new User("John", "password");
        Users.add(user);
        Users.deleteUser("John");
        assertFalse(Users.checkExists("John"));
    }

    @Test
    public void testCreateUser() {
        UserList userList = new UserList();
        userList.createUser("John", "password");
        assertTrue(userList.checkExists("John"));
    }

    @Test
    public void testFindUser() {
        UserList userList = new UserList();
        User user = new User("John", "password");
        userList.add(user);
        assertEquals(user, userList.findUser("John"));
    }

    @Test
    public void testCheckExists() {
        UserList userList = new UserList();
        User user = new User("John", "password");
        userList.add(user);
        assertTrue(userList.checkExists("John"));
        assertFalse(userList.checkExists("Alice"));
    }

    // Add more test cases as needed for other methods

}
