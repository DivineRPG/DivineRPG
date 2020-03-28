package divinerpg.objects.entities.assets.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelHat extends ModelBase {
    public ModelRenderer top;
    private ModelPlayer playerModel;

    public ModelHat(ModelPlayer playerModel) {
        this.playerModel = playerModel;

        this.top = new ModelRenderer(this, 0, 0).setTextureSize(128, 128);
        this.top.addBox(-4, -18, -4, 8, 8, 8, 0.0F);

        ModelRenderer bottom = new ModelRenderer(this, 32, 0).setTextureSize(128, 128);
        bottom.addBox(-6, -10, -6, 12, 2, 12, 0.0F);

        top.addChild(bottom);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        top.render(scale);
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        if (playerModel == null || playerModel.bipedHead == null)
            return;

        top.rotateAngleX = playerModel.bipedHead.rotateAngleX;
        top.rotateAngleY = playerModel.bipedHead.rotateAngleY;
        top.rotateAngleZ = playerModel.bipedHead.rotateAngleZ;
    }
}