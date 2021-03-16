package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelSaguaroWormShot<T extends Entity> extends SegmentedModel<T> {
    public ModelRenderer box = (new ModelRenderer(this, 0, 0)).setTexSize(16, 16);

    public ModelSaguaroWormShot() {
        this.box.addBox(0.0F, 0F, 0F, 1, 1, 1, 0.0F);
        this.box.xRot = 0;
        this.box.yRot = 0;
        this.box.zRot = 0;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(box);
    }

}