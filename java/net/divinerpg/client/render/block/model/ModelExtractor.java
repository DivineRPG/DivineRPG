package net.divinerpg.client.render.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelExtractor extends ModelBase
{
    //fields
    ModelRenderer P2;
    ModelRenderer S1;
    ModelRenderer S2;
    ModelRenderer S3;
    ModelRenderer S4;
    ModelRenderer r1;
    ModelRenderer r2;
    ModelRenderer r3;
    ModelRenderer r4;
    ModelRenderer r5;
    ModelRenderer r6;
    ModelRenderer r7;
    ModelRenderer r8;
    ModelRenderer r9;
    ModelRenderer r10;
    ModelRenderer S7;
    ModelRenderer S6;
    ModelRenderer S5;
    ModelRenderer S8;
    ModelRenderer P4;
    ModelRenderer P3;

    public ModelExtractor() {
        textureWidth = 64;
        textureHeight = 32;
        P2 = new ModelRenderer(this, 0, 16);
        P2.addBox(0F, 0F, 0F, 14, 2, 14);
        P2.setRotationPoint(-7F, 8F, -7F);
        P2.setTextureSize(64, 32);
        P2.mirror = true;
        setRotation(P2, 0F, 0F, 0F);
        S1 = new ModelRenderer(this, 12, 0);
        S1.addBox(0F, 0F, 0F, 2, 8, 2);
        S1.setRotationPoint(3F, 10F, -5F);
        S1.setTextureSize(64, 32);
        S1.mirror = true;
        setRotation(S1, 0F, 0F, 0F);
        S2 = new ModelRenderer(this, 12, 0);
        S2.addBox(0F, 0F, 0F, 2, 8, 2);
        S2.setRotationPoint(-5F, 10F, 3F);
        S2.setTextureSize(64, 32);
        S2.mirror = true;
        setRotation(S2, 0F, 0F, 0F);
        S3 = new ModelRenderer(this, 12, 0);
        S3.addBox(0F, 0F, 0F, 2, 8, 2);
        S3.setRotationPoint(3F, 10F, 3F);
        S3.setTextureSize(64, 32);
        S3.mirror = true;
        setRotation(S3, 0F, 0F, 0F);
        S4 = new ModelRenderer(this, 12, 0);
        S4.addBox(0F, 0F, 0F, 2, 8, 2);
        S4.setRotationPoint(-5F, 10F, -5F);
        S4.setTextureSize(64, 32);
        S4.mirror = true;
        setRotation(S4, 0F, 0F, 0F);
        r1 = new ModelRenderer(this, 0, 0);
        r1.addBox(0F, 0F, 0F, 1, 4, 1);
        r1.setRotationPoint(1F, 20F, 0F);
        r1.setTextureSize(64, 32);
        r1.mirror = true;
        setRotation(r1, 0F, 0F, 0F);
        r2 = new ModelRenderer(this, 0, 0);
        r2.addBox(0F, 0F, 0F, 1, 4, 1);
        r2.setRotationPoint(-3F, 20F, 4F);
        r2.setTextureSize(64, 32);
        r2.mirror = true;
        setRotation(r2, 0F, 0F, 0F);
        r3 = new ModelRenderer(this, 0, 0);
        r3.addBox(0F, 0F, 0F, 1, 4, 1);
        r3.setRotationPoint(4F, 20F, -6F);
        r3.setTextureSize(64, 32);
        r3.mirror = true;
        setRotation(r3, 0F, 0F, 0F);
        r4 = new ModelRenderer(this, 0, 0);
        r4.addBox(0F, 0F, 0F, 1, 4, 1);
        r4.setRotationPoint(-5F, 20F, -4F);
        r4.setTextureSize(64, 32);
        r4.mirror = true;
        setRotation(r4, 0F, 0F, 0F);
        r5 = new ModelRenderer(this, 0, 0);
        r5.addBox(0F, 0F, 0F, 1, 2, 1);
        r5.setRotationPoint(4F, 20F, -1F);
        r5.setTextureSize(64, 32);
        r5.mirror = true;
        setRotation(r5, 0F, 0F, 0F);
        r6 = new ModelRenderer(this, 0, 0);
        r6.addBox(0F, 0F, 0F, 1, 2, 1);
        r6.setRotationPoint(-5F, 20F, 2F);
        r6.setTextureSize(64, 32);
        r6.mirror = true;
        setRotation(r6, 0F, 0F, 0F);
        r7 = new ModelRenderer(this, 0, 0);
        r7.addBox(0F, 0F, 0F, 1, 2, 1);
        r7.setRotationPoint(-1F, 20F, -5F);
        r7.setTextureSize(64, 32);
        r7.mirror = true;
        setRotation(r7, 0F, 0F, 0F);
        r8 = new ModelRenderer(this, 0, 0);
        r8.addBox(0F, 0F, 0F, 1, 2, 1);
        r8.setRotationPoint(5F, 20F, 5F);
        r8.setTextureSize(64, 32);
        r8.mirror = true;
        setRotation(r8, 0F, 0F, 0F);
        r9 = new ModelRenderer(this, 0, 0);
        r9.addBox(0F, 0F, 0F, 1, 2, 1);
        r9.setRotationPoint(2F, 20F, 3F);
        r9.setTextureSize(64, 32);
        r9.mirror = true;
        setRotation(r9, 0F, 0F, 0F);
        r10 = new ModelRenderer(this, 0, 0);
        r10.addBox(0F, 0F, 0F, 1, 2, 1);
        r10.setRotationPoint(-3F, 20F, -2F);
        r10.setTextureSize(64, 32);
        r10.mirror = true;
        setRotation(r10, 0F, 0F, 0F);
        S7 = new ModelRenderer(this, 12, 0);
        S7.addBox(0F, 0F, 0F, 2, 8, 2);
        S7.setRotationPoint(-4F, 0F, 2F);
        S7.setTextureSize(64, 32);
        S7.mirror = true;
        setRotation(S7, 0F, 0F, 0F);
        S6 = new ModelRenderer(this, 12, 0);
        S6.addBox(0F, 0F, 0F, 2, 8, 2);
        S6.setRotationPoint(2F, 0F, 2F);
        S6.setTextureSize(64, 32);
        S6.mirror = true;
        setRotation(S6, 0F, 0F, 0F);
        S5 = new ModelRenderer(this, 12, 0);
        S5.addBox(0F, 0F, 0F, 2, 8, 2);
        S5.setRotationPoint(2F, 0F, -4F);
        S5.setTextureSize(64, 32);
        S5.mirror = true;
        setRotation(S5, 0F, 0F, 0F);
        S8 = new ModelRenderer(this, 12, 0);
        S8.addBox(0F, 0F, 0F, 2, 8, 2);
        S8.setRotationPoint(-4F, 0F, -4F);
        S8.setTextureSize(64, 32);
        S8.mirror = true;
        setRotation(S8, 0F, 0F, 0F);
        P4 = new ModelRenderer(this, 0, 16);
        P4.addBox(0F, 0F, 0F, 14, 2, 14);
        P4.setRotationPoint(-7F, 18F, -7F);
        P4.setTextureSize(64, 32);
        P4.mirror = true;
        setRotation(P4, 0F, 0F, 0F);
        P3 = new ModelRenderer(this, 0, 16);
        P3.addBox(0F, 0F, 0F, 14, 2, 14);
        P3.setRotationPoint(-7F, -1F, -7F);
        P3.setTextureSize(64, 32);
        P3.mirror = true;
        setRotation(P3, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        P2.render(f5);
        S1.render(f5);
        S2.render(f5);
        S3.render(f5);
        S4.render(f5);
        r1.render(f5);
        r2.render(f5);
        r3.render(f5);
        r4.render(f5);
        r5.render(f5);
        r6.render(f5);
        r7.render(f5);
        r8.render(f5);
        r9.render(f5);
        r10.render(f5);
        S7.render(f5);
        S6.render(f5);
        S5.render(f5);
        S8.render(f5);
        P4.render(f5);
        P3.render(f5);
    }

    public void render(float f5)
    {
        P2.render(f5);
        S1.render(f5);
        S2.render(f5);
        S3.render(f5);
        S4.render(f5);
        r1.render(f5);
        r2.render(f5);
        r3.render(f5);
        r4.render(f5);
        r5.render(f5);
        r6.render(f5);
        r7.render(f5);
        r8.render(f5);
        r9.render(f5);
        r10.render(f5);
        S7.render(f5);
        S6.render(f5);
        S5.render(f5);
        S8.render(f5);
        P4.render(f5);
        P3.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
