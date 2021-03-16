package divinerpg.client.models;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.player.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelHat<T extends PlayerEntity> extends SegmentedModel<T> {
    public ModelRenderer top, bottom;
    public final PlayerModel playerModel;

    public ModelHat(PlayerModel playerModel) {
        this.playerModel = playerModel;

        this.top = new ModelRenderer(this, 0, 0).setTexSize(128, 128);
        this.top.addBox(-4, -18, -4, 8, 8, 8, 0.0F);

        this.bottom = new ModelRenderer(this, 32, 0).setTexSize(128, 128);
        bottom.addBox(-6, -10, -6, 12, 2, 12, 0.0F);

        top.addChild(bottom);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (playerModel == null || playerModel.head == null)
            return;

        top.xRot = playerModel.head.xRot;
        top.yRot = playerModel.head.yRot;
        top.zRot = playerModel.head.zRot;
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(top);
    }

}