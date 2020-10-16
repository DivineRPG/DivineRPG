package TeamDivineRPG.divinerpg.client.models.vanilla;

import TeamDivineRPG.divinerpg.entities.vanilla.EntityWhale;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelWhale<T extends EntityWhale> extends SegmentedModel<T> {
    ModelRenderer body;
    ModelRenderer flipperL;
    ModelRenderer flipperR;
    ModelRenderer tailConnector;
    ModelRenderer tail;

    public ModelWhale() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.body = new ModelRenderer(this, 0, 0);
        this.body.addBox(0.0F, 0.0F, 0.0F, 8, 6, 24);
        this.body.setRotationPoint(-5.0F, 18.0F, -9.0F);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.flipperL = new ModelRenderer(this, 0, 42);
        this.flipperL.addBox(0.0F, 0.0F, -3.0F, 6, 2, 6);
        this.flipperL.setRotationPoint(2.0F, 21.0F, 0.0F);
        this.flipperL.setTextureSize(64, 64);
        this.flipperL.mirror = true;
        this.setRotation(this.flipperL, 0.0F, 0.0F, 0.0F);
        this.flipperR = new ModelRenderer(this, 0, 42);
        this.flipperR.addBox(-6.0F, 0.0F, -3.0F, 6, 2, 6);
        this.flipperR.setRotationPoint(-4.0F, 21.0F, 0.0F);
        this.flipperR.setTextureSize(64, 64);
        this.flipperR.mirror = true;
        this.setRotation(this.flipperR, 0.0F, 0.0F, 0.0F);
        this.tailConnector = new ModelRenderer(this, 0, 42);
        this.tailConnector.addBox(-3.0F, 0.0F, 0.0F, 6, 2, 6);
        this.tailConnector.setRotationPoint(-1.0F, 19.0F, 15.0F);
        this.tailConnector.setTextureSize(64, 64);
        this.tailConnector.mirror = true;
        this.setRotation(this.tailConnector, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 58);
        this.tail.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 4);
        this.tail.setRotationPoint(-1.0F, 19.0F, 21.0F);
        this.tail.setTextureSize(64, 64);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(this.body, this.flipperL, this.flipperR, this.tail, this.tailConnector);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}