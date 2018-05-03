package accountServer;

/**
 * @author a.akbashev
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountServer implements AccountServerI {
    private int usersCount;
    private int usersLimit;

    public AccountServer(int usersLimit) {
        this.usersCount = 0;
        this.usersLimit = usersLimit;
    }


    public void addNewUser() {
        usersCount += 1;
    }


    public void removeUser() {
        usersCount -= 1;
    }


    public int getUsersLimit() {
        return usersLimit;
    }


    public void setUsersLimit(int usersLimit) {
        this.usersLimit = usersLimit;
    }


    public int getUsersCount() {
        return usersCount;
    }
}
