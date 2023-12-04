package org.btw.menus_handlers;

import com.google.gson.*;
import org.btw.models.cameras.Camera;
import org.btw.models.cameras.PhoneCamera;
import org.btw.models.cameras.SlrCamera;
import org.btw.models.cameras.WebCamera;

import java.lang.reflect.Type;

public class CameraAdapter implements JsonDeserializer<Camera> {
    @Override
    public Camera deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String className = jsonObject.get("className").getAsString();

        return switch (className) {
            case "WebCamera" -> context.deserialize(jsonObject, WebCamera.class);
            case "SlrCamera" -> context.deserialize(jsonObject, SlrCamera.class);
            case "PhoneCamera" -> context.deserialize(jsonObject, PhoneCamera.class);
            default -> throw new JsonParseException("Unknown camera type: " + className);
        };
    }
}