package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelWatcher extends ModelBase
{
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Tentacle11;
    ModelRenderer Tentacle12;
    ModelRenderer Tentacle21;
    ModelRenderer Tentacle22;
    ModelRenderer Tentacle31;
    ModelRenderer Tentacle32;

    public ModelWatcher()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-5.0F, -5.0F, -5.0F, 10, 10, 10);
        this.Head.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, -((float)Math.PI / 2F), 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 20);
        this.Jaw.addBox(-5.0F, 0.0F, -10.0F, 10, 1, 10);
        this.Jaw.setRotationPoint(0.0F, 21.0F, 5.0F);
        this.Jaw.setTextureSize(64, 32);
        this.Jaw.mirror = true;
        this.setRotation(this.Jaw, 0.1745329F, 0.0F, 0.0F);
        this.Tentacle11 = new ModelRenderer(this, 40, 0);
        this.Tentacle11.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.Tentacle11.setRotationPoint(5.0F, 16.0F, 0.0F);
        this.Tentacle11.setTextureSize(64, 32);
        this.Tentacle11.mirror = true;
        this.setRotation(this.Tentacle11, 0.0F, ((float)Math.PI / 2F), 0.0F);
        this.Tentacle12 = new ModelRenderer(this, 40, 6);
        this.Tentacle12.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle12.setRotationPoint(9.0F, 16.0F, 0.0F);
        this.Tentacle12.setTextureSize(64, 32);
        this.Tentacle12.mirror = true;
        this.setRotation(this.Tentacle12, 0.0F, ((float)Math.PI * 3F / 2F), 0.0F);
        this.Tentacle21 = new ModelRenderer(this, 40, 0);
        this.Tentacle21.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.Tentacle21.setRotationPoint(-5.0F, 16.0F, 0.0F);
        this.Tentacle21.setTextureSize(64, 32);
        this.Tentacle21.mirror = true;
        this.setRotation(this.Tentacle21, 0.0F, ((float)Math.PI * 3F / 2F), 0.0F);
        this.Tentacle22 = new ModelRenderer(this, 40, 6);
        this.Tentacle22.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle22.setRotationPoint(-9.0F, 16.0F, 0.0F);
        this.Tentacle22.setTextureSize(64, 32);
        this.Tentacle22.mirror = true;
        this.setRotation(this.Tentacle22, 0.0F, ((float)Math.PI * 3F / 2F), 0.0F);
        this.Tentacle31 = new ModelRenderer(this, 52, 0);
        this.Tentacle31.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2);
        this.Tentacle31.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.Tentacle31.setTextureSize(64, 32);
        this.Tentacle31.mirror = true;
        this.setRotation(this.Tentacle31, 0.0F, 0.0F, 0.0F);
        this.Tentacle32 = new ModelRenderer(this, 40, 6);
        this.Tentacle32.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle32.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.Tentacle32.setTextureSize(64, 32);
        this.Tentacle32.mirror = true;
        this.setRotation(this.Tentacle32, 0.0F, ((float)Math.PI * 3F / 2F), 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.Head.render(var7);
        this.Jaw.render(var7);
        this.Tentacle11.render(var7);
        this.Tentacle12.render(var7);
        this.Tentacle21.render(var7);
        this.Tentacle22.render(var7);
        this.Tentacle31.render(var7);
        this.Tentacle32.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}
