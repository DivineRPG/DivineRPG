package net.divinerpg.client.render.entity.arcana.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelRoamer extends ModelBase
{
    //fields
    ModelRenderer Main_Body1;
    ModelRenderer Lower_Body;
    ModelRenderer Arm2;
    ModelRenderer Armtop1;
    ModelRenderer Armtop2;
    ModelRenderer Arm1;
    ModelRenderer Main_Body;
    ModelRenderer Mid_Body;
    ModelRenderer TopBody;
    ModelRenderer Legbottom1;
    ModelRenderer Legtop1;
    ModelRenderer Legbottom2;
    ModelRenderer Legtop2;

    public ModelRoamer()
    {
        textureWidth = 64;
        textureHeight = 32;
        Main_Body1 = new ModelRenderer(this, 0, 0);
        Main_Body1.addBox(0F, 0F, 0F, 10, 6, 10);
        Main_Body1.setRotationPoint(2F, -5F, 2F);
        Main_Body1.setTextureSize(64, 32);
        Main_Body1.mirror = true;
        setRotation(Main_Body1, 0F, ((float)Math.PI / 2F), 0F);
        Lower_Body = new ModelRenderer(this, 39, 20);
        Lower_Body.addBox(0F, 0F, 0F, 6, 6, 6);
        Lower_Body.setRotationPoint(-4F, -5F, 0F);
        Lower_Body.setTextureSize(64, 32);
        Lower_Body.mirror = true;
        setRotation(Lower_Body, 0F, ((float)Math.PI / 2F), 0F);
        Arm2 = new ModelRenderer(this, 14, 18);
        Arm2.addBox(0F, 0F, 0F, 2, 2, 5);
        Arm2.setRotationPoint(5F, 4F, -2F);
        Arm2.setTextureSize(64, 32);
        Arm2.mirror = true;
        setRotation(Arm2, -((float)Math.PI / 2F), ((float)Math.PI / 2F), 0F);
        Armtop1 = new ModelRenderer(this, 0, 18);
        Armtop1.addBox(0F, 0F, 0F, 2, 2, 5);
        Armtop1.setRotationPoint(0F, 2F, -2F);
        Armtop1.setTextureSize(64, 32);
        Armtop1.mirror = true;
        setRotation(Armtop1, 0F, ((float)Math.PI / 2F), 0F);
        Armtop2 = new ModelRenderer(this, 0, 25);
        Armtop2.addBox(0F, 0F, 0F, 2, 2, 5);
        Armtop2.setRotationPoint(-7F, 2F, -2F);
        Armtop2.setTextureSize(64, 32);
        Armtop2.mirror = true;
        setRotation(Armtop2, 0F, ((float)Math.PI / 2F), 0F);
        Arm1 = new ModelRenderer(this, 14, 25);
        Arm1.addBox(0F, 0F, 0F, 2, 2, 5);
        Arm1.setRotationPoint(-5F, 4F, -2F);
        Arm1.setTextureSize(64, 32);
        Arm1.mirror = true;
        setRotation(Arm1, -((float)Math.PI / 2F), ((float)Math.PI / 2F), 0F);
        Main_Body = new ModelRenderer(this, 0, 0);
        Main_Body.addBox(0F, 0F, 0F, 10, 6, 10);
        Main_Body.setRotationPoint(-14F, -5F, 2F);
        Main_Body.setTextureSize(64, 32);
        Main_Body.mirror = true;
        setRotation(Main_Body, 0F, ((float)Math.PI / 2F), 0F);
        Mid_Body = new ModelRenderer(this, 39, 20);
        Mid_Body.addBox(0F, 0F, 0F, 6, 6, 6);
        Mid_Body.setRotationPoint(-4F, 7F, 0F);
        Mid_Body.setTextureSize(64, 32);
        Mid_Body.mirror = true;
        setRotation(Mid_Body, 0F, ((float)Math.PI / 2F), 0F);
        TopBody = new ModelRenderer(this, 39, 20);
        TopBody.addBox(0F, 0F, 0F, 6, 6, 6);
        TopBody.setRotationPoint(-4F, 1F, 0F);
        TopBody.setTextureSize(64, 32);
        TopBody.mirror = true;
        setRotation(TopBody, 0F, ((float)Math.PI / 2F), 0F);
        Legbottom1 = new ModelRenderer(this, 14, 25);
        Legbottom1.addBox(0F, 0F, 0F, 2, 2, 5);
        Legbottom1.setRotationPoint(-5F, 13F, -2F);
        Legbottom1.setTextureSize(64, 32);
        Legbottom1.mirror = true;
        setRotation(Legbottom1, -((float)Math.PI / 2F), ((float)Math.PI / 2F), 0F);
        Legtop1 = new ModelRenderer(this, 0, 25);
        Legtop1.addBox(0F, 0F, 0F, 2, 2, 5);
        Legtop1.setRotationPoint(-7F, 11F, -2F);
        Legtop1.setTextureSize(64, 32);
        Legtop1.mirror = true;
        setRotation(Legtop1, 0F, ((float)Math.PI / 2F), 0F);
        Legbottom2 = new ModelRenderer(this, 14, 18);
        Legbottom2.addBox(0F, 0F, 0F, 2, 2, 5);
        Legbottom2.setRotationPoint(5F, 13F, -2F);
        Legbottom2.setTextureSize(64, 32);
        Legbottom2.mirror = true;
        setRotation(Legbottom2, -((float)Math.PI / 2F), ((float)Math.PI / 2F), 0F);
        Legtop2 = new ModelRenderer(this, 0, 18);
        Legtop2.addBox(0F, 0F, 0F, 2, 2, 5);
        Legtop2.setRotationPoint(0F, 11F, -2F);
        Legtop2.setTextureSize(64, 32);
        Legtop2.mirror = true;
        setRotation(Legtop2, 0F, ((float)Math.PI / 2F), 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        Main_Body1.render(f5);
        Lower_Body.render(f5);
        Arm2.render(f5);
        Armtop1.render(f5);
        Armtop2.render(f5);
        Arm1.render(f5);
        Main_Body.render(f5);
        Mid_Body.render(f5);
        TopBody.render(f5);
        Legbottom1.render(f5);
        Legtop1.render(f5);
        Legbottom2.render(f5);
        Legtop2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity par6)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, par6);
    }
}
