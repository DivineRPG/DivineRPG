package net.divinerpg.client.render.entity.iceika.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFractite extends ModelBase
{
    //fields
    ModelRenderer frostBody;
    ModelRenderer shard1;
    ModelRenderer shard2;
    ModelRenderer shard7;
    ModelRenderer shard8;
    ModelRenderer shard4;
    ModelRenderer shard3;
    ModelRenderer shard5;
    ModelRenderer shard6;

    public ModelFractite()
    {
        textureWidth = 64;
        textureHeight = 32;

        frostBody = new ModelRenderer(this, 0, 11);
        frostBody.addBox(0F, 0F, 0F, 8, 8, 6);
        frostBody.setRotationPoint(-4F, 5F, -4F);
        frostBody.setTextureSize(64, 32);
        frostBody.mirror = true;
        setRotation(frostBody, 0F, 0F, 0F);
        shard1 = new ModelRenderer(this, 0, 0);
        shard1.addBox(8F, 0F, 0F, 9, 1, 2);
        shard1.setRotationPoint(1F, 8F, -2F);
        shard1.setTextureSize(64, 32);
        shard1.mirror = true;
        setRotation(shard1, 0F, 0F, -0.7853982F);
        shard2 = new ModelRenderer(this, 0, 0);
        shard2.addBox(-19F, 0F, 0F, 9, 1, 2);
        shard2.setRotationPoint(0F, 9F, -2F);
        shard2.setTextureSize(64, 32);
        shard2.mirror = true;
        setRotation(shard2, 0F, 0F, -0.7853982F);
        shard7 = new ModelRenderer(this, 0, 0);
        shard7.addBox(10F, 0F, 0F, 10, 1, 2);
        shard7.setRotationPoint(0F, 9F, -2F);
        shard7.setTextureSize(64, 32);
        shard7.mirror = true;
        setRotation(shard7, 0F, 0F, 0.7853982F);
        shard8 = new ModelRenderer(this, 0, 0);
        shard8.addBox(-19F, 0F, 0F, 10, 1, 2);
        shard8.setRotationPoint(-1F, 9F, -2F);
        shard8.setTextureSize(64, 32);
        shard8.mirror = true;
        setRotation(shard8, 0F, 0F, 0.7853982F);
        shard4 = new ModelRenderer(this, 0, 0);
        shard4.addBox(-6F, -8F, 0F, 15, 1, 2);
        shard4.setRotationPoint(0F, 8F, -2F);
        shard4.setTextureSize(64, 32);
        shard4.mirror = true;
        setRotation(shard4, 0F, 0F, 1.570796F);
        shard3 = new ModelRenderer(this, 0, 0);
        shard3.addBox(-7F, 7F, 0F, 15, 1, 2);
        shard3.setRotationPoint(0F, 9F, -2F);
        shard3.setTextureSize(64, 32);
        shard3.mirror = true;
        setRotation(shard3, 0F, 0F, 1.570796F);
        shard5 = new ModelRenderer(this, 0, 0);
        shard5.addBox(-8F, -7F, 0F, 14, 1, 2);
        shard5.setRotationPoint(1F, 9F, -2F);
        shard5.setTextureSize(64, 32);
        shard5.mirror = true;
        setRotation(shard5, 0F, 0F, 0F);
        shard6 = new ModelRenderer(this, 0, 0);
        shard6.addBox(-7F, 7F, 0F, 14, 1, 2);
        shard6.setRotationPoint(0F, 9F, -2F);
        shard6.setTextureSize(64, 32);
        shard6.mirror = true;
        setRotation(shard6, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        frostBody.render(f5);
        shard1.render(f5);
        shard2.render(f5);
        shard7.render(f5);
        shard8.render(f5);
        shard4.render(f5);
        shard3.render(f5);
        shard5.render(f5);
        shard6.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float par2, float par3, float par4, float par5, float par6, float par7, Entity entity)
    {
        this.shard1.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard2.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard3.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard4.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard5.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard6.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard7.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;
        this.shard8.rotateAngleX = MathHelper.cos(par4 * 0.1F) * (float)Math.PI;

    }

}
