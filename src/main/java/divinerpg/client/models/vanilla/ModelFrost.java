package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelFrost<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer frostBody;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer horn3;
    ModelRenderer horn4;
    ModelRenderer shard1;
    ModelRenderer shard2;
    ModelRenderer shard3;
    ModelRenderer shard4;

    public ModelFrost() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.frostBody = new ModelRenderer(this, 0, 11);
        this.frostBody.addBox(0.0F, 0.0F, 0.0F, 8, 8, 2);
        this.frostBody.setPos(-4.0F, 10.0F, -2.0F);
        this.frostBody.setTexSize(64, 32);
        this.frostBody.mirror = true;
        this.setRotation(this.frostBody, 0.0F, 0.0F, 0.0F);
        this.horn1 = new ModelRenderer(this, 0, 0);
        this.horn1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        this.horn1.setPos(-9.0F, 5.0F, -2.0F);
        this.horn1.setTexSize(64, 32);
        this.horn1.mirror = true;
        this.setRotation(this.horn1, 0.0F, 0.0F, ((float) Math.PI / 4F));
        this.horn2 = new ModelRenderer(this, 0, 0);
        this.horn2.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        this.horn2.setPos(-9.0F, 22.0F, -2.0F);
        this.horn2.setTexSize(64, 32);
        this.horn2.mirror = true;
        this.setRotation(this.horn2, 0.0F, 0.0F, -((float) Math.PI / 4F));
        this.horn3 = new ModelRenderer(this, 0, 0);
        this.horn3.addBox(0.0F, 0.0F, 0.0F, 7, 1, 2);
        this.horn3.setPos(4.0F, 17.0F, -2.0F);
        this.horn3.setTexSize(64, 32);
        this.horn3.mirror = true;
        this.setRotation(this.horn3, 0.0F, 0.0F, ((float) Math.PI / 4F));
        this.horn4 = new ModelRenderer(this, 0, 0);
        this.horn4.addBox(0.0F, 0.0F, 0.0F, 8, 1, 2);
        this.horn4.setPos(3.0F, 11.0F, -2.0F);
        this.horn4.setTexSize(64, 32);
        this.horn4.mirror = true;
        this.setRotation(this.horn4, 0.0F, 0.0F, -((float) Math.PI / 4F));
        this.shard1 = new ModelRenderer(this, 0, 0);
        this.shard1.addBox(0.0F, 0.0F, 0.0F, 14, 1, 2);
        this.shard1.setPos(-7.0F, 7.0F, -2.0F);
        this.shard1.setTexSize(64, 32);
        this.shard1.mirror = true;
        this.setRotation(this.shard1, 0.0F, 0.0F, 0.0F);
        this.shard2 = new ModelRenderer(this, 0, 0);
        this.shard2.addBox(0.0F, 0.0F, 0.0F, 14, 1, 2);
        this.shard2.setPos(-7.0F, 20.53333F, -2.0F);
        this.shard2.setTexSize(64, 32);
        this.shard2.mirror = true;
        this.setRotation(this.shard2, 0.0F, 0.0F, 0.0F);
        this.shard3 = new ModelRenderer(this, 0, 0);
        this.shard3.addBox(0.0F, 0.0F, 0.0F, 14, 1, 2);
        this.shard3.setPos(-7.0F, 7.0F, -2.0F);
        this.shard3.setTexSize(64, 32);
        this.shard3.mirror = true;
        this.setRotation(this.shard3, 0.0F, 0.0F, ((float) Math.PI / 2F));
        this.shard4 = new ModelRenderer(this, 0, 0);
        this.shard4.addBox(0.0F, 0.0F, 0.0F, 14, 1, 2);
        this.shard4.setPos(8.0F, 7.0F, -2.0F);
        this.shard4.setTexSize(64, 32);
        this.shard4.mirror = true;
        this.setRotation(this.shard4, 0.0F, 0.0F, ((float) Math.PI / 2F));
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(frostBody, horn1, horn2, horn3, horn4, shard1, shard2, shard3, shard4);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }
}
