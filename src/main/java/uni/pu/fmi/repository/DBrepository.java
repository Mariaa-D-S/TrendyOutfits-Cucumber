package uni.pu.fmi.repository;

import lombok.Getter;
import uni.pu.fmi.models.Outfit;
import uni.pu.fmi.models.User;

import java.util.ArrayList;
import java.util.List;

public class DBrepository {

    @Getter
    private static List<Outfit> outfitList = new ArrayList<>();
    @Getter
    private static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User(1L, "Maria", "Ivanova", "maria.iv@example.com", "password123", "10.01.1990"));
        userList.add(new User(2L, "Petar", "Georgiev", "petar.georgiev@example.com", "password456", "20.06.1999"));

        outfitList.add(new Outfit(1L, "Casual Outfit", "A nice casual outfit", "photo1.jpg", 1L));
        outfitList.add(new Outfit(2L, "Черна рокля с пайети", "Perfect for official events", "photo2.jpg", 2L));
        outfitList.add(new Outfit(3L, "Sport Outfit", "Great for sports activities", "photo3.jpg", 1L));
    }
}
