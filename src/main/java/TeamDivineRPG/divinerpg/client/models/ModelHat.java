package TeamDivineRPG.divinerpg.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelHat<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer top;
    private final PlayerModel playerModel;

    public ModelHat(PlayerModel playerModel) {
        this.playerModel = playerModel;

        this.top = new ModelRenderer(this, 0, 0).setTextureSize(128, 128);
        this.top.addBox(-4, -18, -4, 8, 8, 8, 0.0F);

        ModelRenderer bottom = new ModelRenderer(this, 32, 0).setTextureSize(128, 128);
        bottom.addBox(-6, -10, -6, 12, 2, 12, 0.0F);

        top.addChild(bottom);
    }

    @Override

    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (playerModel == null || playerModel.bipedHead == null)
            return;

        top.rotateAngleX = playerModel.bipedHead.rotateAngleX;
        top.rotateAngleY = playerModel.bipedHead.rotateAngleY;
        top.rotateAngleZ = playerModel.bipedHead.rotateAngleZ;
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(top);
    }

}