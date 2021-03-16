package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import divinerpg.entities.vanilla.nether.EntityHellBat;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ModelHellBat extends SegmentedModel<EntityHellBat> {
    private final ModelRenderer batHead;
    private final ModelRenderer batBody;
    private final ModelRenderer batRightWing;
    private final ModelRenderer batLeftWing;
    private final ModelRenderer batOuterRightWing;
    private final ModelRenderer batOuterLeftWing;

    public ModelHellBat() {
        this.texWidth = 64;
        this.texHeight = 64;
        this.batHead = new ModelRenderer(this, 0, 0);
        this.batHead.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F);
        ModelRenderer modelrenderer = new ModelRenderer(this, 24, 0);
        modelrenderer.addBox(-4.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F);
        this.batHead.addChild(modelrenderer);
        ModelRenderer modelrenderer1 = new ModelRenderer(this, 24, 0);
        modelrenderer1.mirror = true;
        modelrenderer1.addBox(1.0F, -6.0F, -2.0F, 3.0F, 4.0F, 1.0F);
        this.batHead.addChild(modelrenderer1);
        this.batBody = new ModelRenderer(this, 0, 16);
        this.batBody.addBox(-3.0F, 4.0F, -3.0F, 6.0F, 12.0F, 6.0F);
        this.batBody.texOffs(0, 34).addBox(-5.0F, 16.0F, 0.0F, 10.0F, 6.0F, 1.0F);
        this.batRightWing = new ModelRenderer(this, 42, 0);
        this.batRightWing.addBox(-12.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F);
        this.batOuterRightWing = new ModelRenderer(this, 24, 16);
        this.batOuterRightWing.setPos(-12.0F, 1.0F, 1.5F);
        this.batOuterRightWing.addBox(-8.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F);
        this.batLeftWing = new ModelRenderer(this, 42, 0);
        this.batLeftWing.mirror = true;
        this.batLeftWing.addBox(2.0F, 1.0F, 1.5F, 10.0F, 16.0F, 1.0F);
        this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
        this.batOuterLeftWing.mirror = true;
        this.batOuterLeftWing.setPos(12.0F, 1.0F, 1.5F);
        this.batOuterLeftWing.addBox(0.0F, 1.0F, 0.0F, 8.0F, 12.0F, 1.0F);
        this.batBody.addChild(this.batRightWing);
        this.batBody.addChild(this.batLeftWing);
        this.batRightWing.addChild(this.batOuterRightWing);
        this.batLeftWing.addChild(this.batOuterLeftWing);
    }
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(this.batHead, this.batBody);
    }

    public void setupAnim(EntityHellBat entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn.isResting()) {
            this.batHead.xRot = headPitch * ((float)Math.PI / 180F);
            this.batHead.yRot = (float)Math.PI - netHeadYaw * ((float)Math.PI / 180F);
            this.batHead.zRot = (float)Math.PI;
            this.batHead.setPos(0.0F, -2.0F, 0.0F);
            this.batRightWing.setPos(-3.0F, 0.0F, 3.0F);
            this.batLeftWing.setPos(3.0F, 0.0F, 3.0F);
            this.batBody.xRot = (float)Math.PI;
            this.batRightWing.xRot = -0.15707964F;
            this.batRightWing.yRot = -1.2566371F;
            this.batOuterRightWing.yRot = -1.7278761F;
            this.batLeftWing.xRot = this.batRightWing.xRot;
            this.batLeftWing.yRot = -this.batRightWing.yRot;
            this.batOuterLeftWing.yRot = -this.batOuterRightWing.yRot;
        } else {
            this.batHead.xRot = headPitch * ((float)Math.PI / 180F);
            this.batHead.yRot = netHeadYaw * ((float)Math.PI / 180F);
            this.batHead.zRot = 0.0F;
            this.batHead.setPos(0.0F, 0.0F, 0.0F);
            this.batRightWing.setPos(0.0F, 0.0F, 0.0F);
            this.batLeftWing.setPos(0.0F, 0.0F, 0.0F);
            this.batBody.xRot = ((float)Math.PI / 4F) + MathHelper.cos(ageInTicks * 0.1F) * 0.15F;
            this.batBody.yRot = 0.0F;
            this.batRightWing.yRot = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
            this.batLeftWing.yRot = -this.batRightWing.yRot;
            this.batOuterRightWing.yRot = this.batRightWing.yRot * 0.5F;
            this.batOuterLeftWing.yRot = -this.batRightWing.yRot * 0.5F;
        }

    }
}