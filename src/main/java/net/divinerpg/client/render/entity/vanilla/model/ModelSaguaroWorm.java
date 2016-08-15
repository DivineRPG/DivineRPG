package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelSaguaroWorm extends ModelBase {
    ModelRenderer connector2;
    ModelRenderer middle;
    ModelRenderer base;
    ModelRenderer connector1;
    ModelRenderer head;

    public ModelSaguaroWorm() {
        textureWidth = 64;
        textureHeight = 64;

        connector2 = new ModelRenderer(this, 0, 32);
        connector2.addBox(0F, 0F, 0F, 10, 16, 10);
        connector2.setRotationPoint(-5F, -24F, -21F);
        connector2.setTextureSize(64, 64);
        connector2.mirror = true;
        setRotation(connector2, 0.5759587F, 0F, 0F);
        middle = new ModelRenderer(this, 0, 0);
        middle.addBox(0F, 0F, 0F, 16, 16, 16);
        middle.setRotationPoint(-8F, -13F, -16F);
        middle.setTextureSize(64, 64);
        middle.mirror = true;
        setRotation(middle, 0.4363323F, 0F, 0F);
        base = new ModelRenderer(this, 0, 0);
        base.addBox(0F, 0F, 0F, 16, 16, 16);
        base.setRotationPoint(-8F, 8F, -8F);
        base.setTextureSize(64, 64);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        connector1 = new ModelRenderer(this, 0, 32);
        connector1.addBox(0F, 0F, 0F, 10, 16, 10);
        connector1.setRotationPoint(-5F, -3F, -9F);
        connector1.setTextureSize(64, 64);
        connector1.mirror = true;
        setRotation(connector1, 0.3316126F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-8F, -16F, -8F, 16, 16, 16);
        head.setRotationPoint(0F, -24F, -14F);
        head.setTextureSize(64, 64);
        head.mirror = true;
        setRotation(head, 1.047198F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        connector2.render(f5);
        middle.render(f5);
        base.render(f5);
        connector1.render(f5);
        head.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
    }

}
