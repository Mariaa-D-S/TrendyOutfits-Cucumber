package uni.pu.fmi.service;

import uni.pu.fmi.models.Outfit;
import uni.pu.fmi.repository.DBrepository;
import java.util.List;
import java.util.stream.Collectors;

public class OutfitService {
    public List<Outfit>load(){
        return DBrepository.getOutfitList();
    }

    public List<Outfit> searchOutfits(String keyword) {
        List<Outfit> outfits = DBrepository.getOutfitList();
        return outfits.stream()
                .filter(outfit -> outfit.getName().contains(keyword) || outfit.getDescription().contains(keyword))
                .collect(Collectors.toList());
    }

    public void createOutfit(String name, String description, String photo, Long userId) {
        List<Outfit> outfits = DBrepository.getOutfitList();
        Outfit newOutfit = new Outfit((long) (outfits.size() + 1), name, description, photo, userId);
        outfits.add(newOutfit);
    }
}
