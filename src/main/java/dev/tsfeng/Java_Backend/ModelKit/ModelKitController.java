package dev.tsfeng.Java_Backend.ModelKit;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/model_kits")
public class ModelKitController {

    private final ModelKitRepository modelKitRepository;

    public ModelKitController(ModelKitRepository modelKitRepository) {
        this.modelKitRepository = modelKitRepository;
    }

    @GetMapping("")
    List<ModelKit> findAll() {
        return  modelKitRepository.findAll();
    }

    @GetMapping("/{id}")
    ModelKit findById(@PathVariable Integer id) {
        Optional<ModelKit> modelKit = modelKitRepository.findById(id);

        if (modelKit.isEmpty()) {
            throw new ModelKitNotFoundException();
        }

        return modelKit.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody ModelKit modelKit) {
        modelKitRepository.create(modelKit);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody ModelKit modelKit, @PathVariable Integer id) {
        modelKitRepository.update(modelKit, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        modelKitRepository.delete(id);
    }
}
