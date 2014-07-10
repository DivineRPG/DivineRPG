package net.divinerpg.api.model;

import java.util.ArrayList;

import net.divinerpg.utils.LogHelper;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public abstract class DivineModel extends ModelBase {

    protected ArrayList<ModelRenderer> parts;
    protected String                   texture;

    public DivineModel(String texture, int textureWidth, int textureHeight) {
        this.texture = texture;
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.parts = new ArrayList<ModelRenderer>();
    }

    public String getTextureName() {
        return texture;
    }

    public void render(float rotation) {
        if (parts == null || parts.isEmpty()) {
            LogHelper.debug("Nothing to rotate in type: " + getClass().getName());
            return;
        }
        for (ModelRenderer model : parts)
            model.render(rotation);
    }

    public void addPart(ModelRenderer model) {
        parts.add(model);
    }
    
    protected void setRotation(ModelRenderer model, float x, float y, float z) {
      model.rotateAngleX = x;
      model.rotateAngleY = y;
      model.rotateAngleZ = z;
    }

}
