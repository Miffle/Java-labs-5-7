package org.btw.menus_handlers;

import com.google.gson.*;
import org.btw.mediafiles.Media;
import org.btw.mediafiles.Picture;
import org.btw.mediafiles.Video;

import java.lang.reflect.Type;

public class MediaAdapter implements JsonDeserializer<Media> {
    @Override
    public Media deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        String mediaFileType = jsonObject.get("mediaFileType").getAsString();

        return switch (mediaFileType) {
            case "Picture" -> context.deserialize(jsonObject, Picture.class);
            case "Video" -> context.deserialize(jsonObject, Video.class);
            default -> throw new JsonParseException("Unknown media type: " + mediaFileType);
        };
    }
}