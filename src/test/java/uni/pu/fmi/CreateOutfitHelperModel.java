package uni.pu.fmi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOutfitHelperModel {
    private String name;
    private String description;
    private String photo;
    private Long userId;

    public String validateContentData() {
        if (name == null || name.isEmpty()) {
            return "Името е задължително";
        }
        if (name.length() > 50) {
            return "Името не може да бъде повече от 50 символа";
        }
        if (description == null || description.isEmpty()) {
            return "Описанието е задължително";
        }
        if (photo == null || photo.isEmpty()) {
            return "Снимката е задължителна";
        }
        return "";
    }
}
