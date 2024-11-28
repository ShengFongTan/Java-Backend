package dev.tsfeng.Java_Backend.ModelKit;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelKitNotFoundException extends RuntimeException {
    public ModelKitNotFoundException() {
        super("Model kit not found");
    }
}
