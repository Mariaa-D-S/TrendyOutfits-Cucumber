package uni.pu.fmi;
import lombok.Getter;
import lombok.Setter;
import uni.pu.fmi.models.Outfit;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class SearchOutfitHelperModel {
    private String name;
    private String description;
    private String photo;
    private Long userId;
    private List<Outfit> outfitList;
    private String searchKeyword = "";

    public String errorMessage(String searchKeyword) {
        Pattern pattern = Pattern.compile("[@_!#$%^&*()<>?/|}{~:]");
        Matcher matcher = pattern.matcher(searchKeyword);

        if (matcher.find()) {
            return "Не може да използвате знаци при търсене";
        }
        if (searchKeyword.length() >= 50) {
            return "Не може да въведете повече от 50 символа";
        }
        return "";
    }

}
