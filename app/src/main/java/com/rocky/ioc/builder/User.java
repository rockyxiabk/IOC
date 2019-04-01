package com.rocky.ioc.builder;

/**
 * Description : com.rocky.ioc.builder
 *
 * @author : rocky
 * @Create Time : 2019/3/30 4:52 PM
 * @Modified Time : 2019/3/30 4:52 PM
 */
public class User {
    private final String id;
    private final String name;
    private final String nickname;
    private final long time;
    private final long birthday;
    private String des;

    private User(UserBuilder userBuilder) {
        this.id = userBuilder.id;
        this.name=userBuilder.name;
        this.birthday=userBuilder.birthday;
        this.time=userBuilder.time;
        this.des=userBuilder.des;
        this.nickname=userBuilder.nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", time=" + time +
                ", birthday=" + birthday +
                ", des='" + des + '\'' +
                '}';
    }

    public static class UserBuilder {
        private String id;
        private String name;
        private String nickname;
        private long time;
        private long birthday;
        private String des;

        public UserBuilder(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public UserBuilder setTime(long time) {
            this.time = time;
            return this;
        }

        public UserBuilder setDes(String des) {
            this.des = des;
            return this;
        }

        public UserBuilder setBirthday(long birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserBuilder setNickName(String nickName) {
            this.nickname = nickName;
            return this;
        }

        public User builder() {
            return new User(this);
        }

    }
}
