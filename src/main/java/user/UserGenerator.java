package user;

import user.models.CreateUserRequest;

import java.util.Random;

import static utils.Utils.randomString;

public class UserGenerator {
    private static final Random random = new Random();

    public static CreateUserRequest randomUser() {
        return new CreateUserRequest()
                .withEmail(randomString(5) + random.nextInt(10000000) + "@yandex.ru")
                .withPassword(randomString(7))
                .withName(randomString(6));
    }
}
