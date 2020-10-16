package TeamDivineRPG.divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class ModelJackOMan extends BipedModel {

    public ModelJackOMan() {
        super(1);
        this.textureHeight = 128;
        this.textureWidth = 64;

        this.bipedHead = new ModelRenderer(this, 0, 96);
        this.bipedHead.addBox(-8.0F, -16.0F, -8.0F, 16, 16, 16, 2);
        this.bipedHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        //this.bipedCloak = new ModelRenderer(this, 0, 0);
        //this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, 0);
        //this.bipedEars = new ModelRenderer(this, 24, 0);
        //this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, 0);
        this.bipedHeadwear = new ModelRenderer(this, 32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedBody = new ModelRenderer(this, 16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0);
        this.bipedBody.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bipedRightArm = new ModelRenderer(this, 40, 16);
        this.bipedRightArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0);
        this.bipedRightArm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.bipedLeftArm = new ModelRenderer(this, 40, 16);
        this.bipedLeftArm.mirror = true;
        this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0);
        this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.bipedRightLeg = new ModelRenderer(this, 0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0);
        this.bipedRightLeg.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0);
        this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
    }

    protected Iterable<ModelRenderer> getBodyParts() {
        return ImmutableList.of(bipedBody, bipedRightArm, bipedLeftArm, bipedRightLeg, bipedLeftLeg, bipedHeadwear, bipedHead);
    }
}
