package fc;

/**
 * Created by liangl on 2018/11/30.
 */
public class User {
    private volatile Long seed;
    private String userName;

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                User user = new User();
                user.setSeed(100L);
                user.setUserName("张三");
            }
        });
        thread1.start();
        thread1.join();
        User user = new User();
        System.out.println(user.getSeed());

    }

}
