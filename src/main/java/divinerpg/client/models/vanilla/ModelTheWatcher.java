package divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTheWatcher<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Tentacle11;
    ModelRenderer Tentacle12;
    ModelRenderer Tentacle21;
    ModelRenderer Tentacle22;
    ModelRenderer Tentacle31;
    ModelRenderer Tentacle32;

    public ModelTheWatcher() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-5.0F, -5.0F, -5.0F, 10, 10, 10);
        this.Head.setPos(0.0F, 16.0F, 0.0F);
        this.Head.setTexSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0F, -((float) Math.PI / 2F), 0.0F);
        this.Jaw = new ModelRenderer(this, 0, 20);
        this.Jaw.addBox(-5.0F, 0.0F, -10.0F, 10, 1, 10);
        this.Jaw.setPos(0.0F, 21.0F, 5.0F);
        this.Jaw.setTexSize(64, 32);
        this.Jaw.mirror = true;
        this.setRotation(this.Jaw, 0.1745329F, 0.0F, 0.0F);
        this.Tentacle11 = new ModelRenderer(this, 40, 0);
        this.Tentacle11.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.Tentacle11.setPos(5.0F, 16.0F, 0.0F);
        this.Tentacle11.setTexSize(64, 32);
        this.Tentacle11.mirror = true;
        this.setRotation(this.Tentacle11, 0.0F, ((float) Math.PI / 2F), 0.0F);
        this.Tentacle12 = new ModelRenderer(this, 40, 6);
        this.Tentacle12.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle12.setPos(9.0F, 16.0F, 0.0F);
        this.Tentacle12.setTexSize(64, 32);
        this.Tentacle12.mirror = true;
        this.setRotation(this.Tentacle12, 0.0F, ((float) Math.PI * 3F / 2F), 0.0F);
        this.Tentacle21 = new ModelRenderer(this, 40, 0);
        this.Tentacle21.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 3);
        this.Tentacle21.setPos(-5.0F, 16.0F, 0.0F);
        this.Tentacle21.setTexSize(64, 32);
        this.Tentacle21.mirror = true;
        this.setRotation(this.Tentacle21, 0.0F, ((float) Math.PI * 3F / 2F), 0.0F);
        this.Tentacle22 = new ModelRenderer(this, 40, 6);
        this.Tentacle22.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle22.setPos(-9.0F, 16.0F, 0.0F);
        this.Tentacle22.setTexSize(64, 32);
        this.Tentacle22.mirror = true;
        this.setRotation(this.Tentacle22, 0.0F, ((float) Math.PI * 3F / 2F), 0.0F);
        this.Tentacle31 = new ModelRenderer(this, 52, 0);
        this.Tentacle31.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2);
        this.Tentacle31.setPos(0.0F, 11.0F, 0.0F);
        this.Tentacle31.setTexSize(64, 32);
        this.Tentacle31.mirror = true;
        this.setRotation(this.Tentacle31, 0.0F, 0.0F, 0.0F);
        this.Tentacle32 = new ModelRenderer(this, 40, 6);
        this.Tentacle32.addBox(-4.0F, -1.0F, -1.0F, 5, 2, 2);
        this.Tentacle32.setPos(0.0F, 7.0F, 0.0F);
        this.Tentacle32.setTexSize(64, 32);
        this.Tentacle32.mirror = true;
        this.setRotation(this.Tentacle32, 0.0F, ((float) Math.PI * 3F / 2F), 0.0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Head, Jaw, Tentacle11, Tentacle12, Tentacle21, Tentacle22, Tentacle31, Tentacle32);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }
}
