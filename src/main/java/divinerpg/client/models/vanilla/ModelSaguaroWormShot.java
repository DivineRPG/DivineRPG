package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSaguaroWormShot<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer box = (new ModelRenderer(this, 0, 0)).setTextureSize(16, 16);

    public ModelSaguaroWormShot() {
        this.box.addBox(0.0F, 0F, 0F, 1, 1, 1, 0.0F);
        this.box.rotationPointX = 0;
        this.box.rotationPointY = 0;
        this.box.rotationPointZ = 0;
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(box);
    }

}