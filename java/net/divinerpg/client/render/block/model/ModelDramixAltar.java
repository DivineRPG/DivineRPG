package net.divinerpg.client.render.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.ForgeHooksClient;

import org.lwjgl.opengl.GL11;


public class ModelDramixAltar extends ModelBase {
    //fields
    ModelRenderer Base;
    ModelRenderer P1;
    ModelRenderer P2;
    ModelRenderer P3;
    ModelRenderer P4;
    ModelRenderer S1;
    ModelRenderer S2;
    ModelRenderer S3;
    ModelRenderer S4;
    
    public ModelDramixAltar() {
        textureWidth = 64;
        textureHeight = 32;
        Base = new ModelRenderer(this, 0, 15);
        Base.addBox(0F, 0F, 0F, 16, 1, 16);
        Base.setRotationPoint(-8F, 10F, -8F);
        Base.setTextureSize(64, 32);
        Base.mirror = true;
        setRotation(Base, 0F, 0F, 0F);
        P1 = new ModelRenderer(this, 0, 0);
        P1.addBox(0F, 0F, 0F, 2, 9, 2);
        P1.setRotationPoint(-8F, 11F, -8F);
        P1.setTextureSize(64, 32);
        P1.mirror = true;
        setRotation(P1, 0F, 0F, 0F);
        P2 = new ModelRenderer(this, 0, 0);
        P2.addBox(0F, 0F, 0F, 2, 9, 2);
        P2.setRotationPoint(6F, 11F, -8F);
        P2.setTextureSize(64, 32);
        P2.mirror = true;
        setRotation(P2, 0F, 0F, 0F);
        P3 = new ModelRenderer(this, 0, 0);
        P3.addBox(0F, 0F, 0F, 2, 9, 2);
        P3.setRotationPoint(6F, 11F, 6F);
        P3.setTextureSize(64, 32);
        P3.mirror = true;
        setRotation(P3, 0F, 0F, 0F);
        P4 = new ModelRenderer(this, 0, 0);
        P4.addBox(0F, 0F, 0F, 2, 9, 2);
        P4.setRotationPoint(-8F, 11F, 6F);
        P4.setTextureSize(64, 32);
        P4.mirror = true;
        setRotation(P4, 0F, 0F, 0F);
        S1 = new ModelRenderer(this, 22, 0);
        S1.addBox(0F, 0F, 0F, 4, 4, 4);
        S1.setRotationPoint(4F, 20F, 4F);
        S1.setTextureSize(64, 32);
        S1.mirror = true;
        setRotation(S1, 0F, 0F, 0F);
        S2 = new ModelRenderer(this, 22, 0);
        S2.addBox(0F, 0F, 0F, 4, 4, 4);
        S2.setRotationPoint(-8F, 20F, 4F);
        S2.setTextureSize(64, 32);
        S2.mirror = true;
        setRotation(S2, 0F, 0F, 0F);
        S3 = new ModelRenderer(this, 22, 0);
        S3.addBox(0F, 0F, 0F, 4, 4, 4);
        S3.setRotationPoint(-8F, 20F, -8F);
        S3.setTextureSize(64, 32);
        S3.mirror = true;
        setRotation(S3, 0F, 0F, 0F);
        S4 = new ModelRenderer(this, 22, 0);
        S4.addBox(0F, 0F, 0F, 4, 4, 4);
        S4.setRotationPoint(4F, 20F, -8F);
        S4.setTextureSize(64, 32);
        S4.mirror = true;
        setRotation(S4, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Base.render(f5);
        P1.render(f5);
        P2.render(f5);
        P3.render(f5);
        P4.render(f5);
        S1.render(f5);
        S2.render(f5);
        S3.render(f5);
        S4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
    public void render(float f5) {
        Base.render(f5);
        P1.render(f5);
        P2.render(f5);
        P3.render(f5);
        P4.render(f5);
        S1.render(f5);
        S2.render(f5);
        S3.render(f5);
        S4.render(f5);
    }
}