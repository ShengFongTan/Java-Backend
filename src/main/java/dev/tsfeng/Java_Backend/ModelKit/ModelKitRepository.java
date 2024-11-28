package dev.tsfeng.Java_Backend.ModelKit;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ModelKitRepository {
    private List<ModelKit> modelKits = new ArrayList<>();

    List<ModelKit> findAll() {
        return modelKits;
    }

    Optional<ModelKit> findById(Integer id) {
        return modelKits.stream()
                .filter(modelKit -> modelKit.id() == id)
                .findFirst();
    }

    void create(ModelKit modelKit) {
        modelKits.add(modelKit);
    }

    void update(ModelKit modelKit, Integer id) {
        Optional<ModelKit> existingModelKit = findById(id);
        if(existingModelKit.isPresent()) {
            modelKits.set(modelKits.indexOf(existingModelKit.get()), modelKit);
        }
    }

    void delete(Integer id) {
        modelKits.removeIf(modelKit -> modelKit.id().equals(id));
    }

    @PostConstruct
    private void init() {
        modelKits.add(
                new ModelKit(
                        1,
                        "F-35",
                        Manufacturer.Tamiya
                )
        );

        modelKits.add(
                new ModelKit(
                        2,
                        "F-18",
                        Manufacturer.MENG
                )
        );
    }
}
