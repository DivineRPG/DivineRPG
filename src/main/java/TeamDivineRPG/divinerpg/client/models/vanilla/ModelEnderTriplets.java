package TeamDivineRPG.divinerpg.client.models.vanilla;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelEnderTriplets<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer Head;
    ModelRenderer Jaw;
    ModelRenderer Tentacle11;
    ModelRenderer Tentacle12;
    ModelRenderer Tentacle31;
    ModelRenderer Tentacle511;
    ModelRenderer Head1;
    ModelRenderer Jaw1;
    ModelRenderer Tentacle132;
    ModelRenderer Tentacle122;
    ModelRenderer Tentacle121;
    ModelRenderer Tentacle131;
    ModelRenderer Jaw2;
    ModelRenderer Head2;
    ModelRenderer Tentacle211;
    ModelRenderer Tentacle212;
    ModelRenderer Tentacle231;
    ModelRenderer Tentacle232;
    ModelRenderer Tentacle222;
    ModelRenderer Tentacle221;
    ModelRenderer Tentacle332;
    ModelRenderer Tentacle432;
    ModelRenderer Tentacle311;
    ModelRenderer Tentacle411;

    public ModelEnderTriplets() {
        textureWidth = 64;
        textureHeight = 32;
        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-5F, -5F, -5F, 10, 10, 10);
        Head.setRotationPoint(0F, 0F, 0F);
        Head.setTextureSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, -((float) Math.PI / 2F), 0F);
        Jaw = new ModelRenderer(this, 0, 20);
        Jaw.addBox(-5F, 0F, -10F, 10, 1, 10);
        Jaw.setRotationPoint(0F, 5F, 5F);
        Jaw.setTextureSize(64, 32);
        Jaw.mirror = true;
        setRotation(Jaw, 0.1745329F, 0F, 0F);
        Tentacle11 = new ModelRenderer(this, 40, 0);
        Tentacle11.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle11.setRotationPoint(5F, 0F, 0F);
        Tentacle11.setTextureSize(64, 32);
        Tentacle11.mirror = true;
        setRotation(Tentacle11, 0F, ((float) Math.PI / 2F), 0F);
        Tentacle12 = new ModelRenderer(this, 40, 6);
        Tentacle12.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle12.setRotationPoint(9F, 0F, 0F);
        Tentacle12.setTextureSize(64, 32);
        Tentacle12.mirror = true;
        setRotation(Tentacle12, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle31 = new ModelRenderer(this, 52, 0);
        Tentacle31.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle31.setRotationPoint(0F, -5F, 0F);
        Tentacle31.setTextureSize(64, 32);
        Tentacle31.mirror = true;
        setRotation(Tentacle31, 0F, 0F, 0F);
        Tentacle511 = new ModelRenderer(this, 11, 9);
        Tentacle511.addBox(-1F, -1F, 0F, 3, 2, 9);
        Tentacle511.setRotationPoint(-5F, 15F, 4F);
        Tentacle511.setTextureSize(64, 32);
        Tentacle511.mirror = true;
        setRotation(Tentacle511, 0F, ((float) Math.PI / 2F), 0F);
        Head1 = new ModelRenderer(this, 0, 0);
        Head1.addBox(-5F, -5F, -5F, 10, 10, 10);
        Head1.setRotationPoint(-8F, 16F, 0F);
        Head1.setTextureSize(64, 32);
        Head1.mirror = true;
        setRotation(Head1, 0F, -((float) Math.PI / 2F), 0F);
        Jaw1 = new ModelRenderer(this, 0, 20);
        Jaw1.addBox(-5F, 0F, -10F, 10, 1, 10);
        Jaw1.setRotationPoint(-8F, 21F, 5F);
        Jaw1.setTextureSize(64, 32);
        Jaw1.mirror = true;
        setRotation(Jaw1, 0.1745329F, 0F, 0F);
        Tentacle132 = new ModelRenderer(this, 40, 6);
        Tentacle132.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle132.setRotationPoint(8F, 7F, 0F);
        Tentacle132.setTextureSize(64, 32);
        Tentacle132.mirror = true;
        setRotation(Tentacle132, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle122 = new ModelRenderer(this, 40, 6);
        Tentacle122.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle122.setRotationPoint(-9F, 0F, 0F);
        Tentacle122.setTextureSize(64, 32);
        Tentacle122.mirror = true;
        setRotation(Tentacle122, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle121 = new ModelRenderer(this, 40, 0);
        Tentacle121.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle121.setRotationPoint(-5F, 0F, 0F);
        Tentacle121.setTextureSize(64, 32);
        Tentacle121.mirror = true;
        setRotation(Tentacle121, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle131 = new ModelRenderer(this, 52, 0);
        Tentacle131.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle131.setRotationPoint(-8F, 11F, 0F);
        Tentacle131.setTextureSize(64, 32);
        Tentacle131.mirror = true;
        setRotation(Tentacle131, 0F, 0F, 0F);
        Jaw2 = new ModelRenderer(this, 0, 20);
        Jaw2.addBox(-5F, 0F, -10F, 10, 1, 10);
        Jaw2.setRotationPoint(8F, 21F, 5F);
        Jaw2.setTextureSize(64, 32);
        Jaw2.mirror = true;
        setRotation(Jaw2, 0.1745329F, 0F, 0F);
        Head2 = new ModelRenderer(this, 0, 0);
        Head2.addBox(-5F, -5F, -5F, 10, 10, 10);
        Head2.setRotationPoint(8F, 16F, 0F);
        Head2.setTextureSize(64, 32);
        Head2.mirror = true;
        setRotation(Head2, 0F, -((float) Math.PI / 2F), 0F);
        Tentacle211 = new ModelRenderer(this, 40, 0);
        Tentacle211.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle211.setRotationPoint(13F, 16F, 0F);
        Tentacle211.setTextureSize(64, 32);
        Tentacle211.mirror = true;
        setRotation(Tentacle211, 0F, ((float) Math.PI / 2F), 0F);
        Tentacle212 = new ModelRenderer(this, 40, 6);
        Tentacle212.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle212.setRotationPoint(17F, 16F, 0F);
        Tentacle212.setTextureSize(64, 32);
        Tentacle212.mirror = true;
        setRotation(Tentacle212, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle231 = new ModelRenderer(this, 52, 0);
        Tentacle231.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle231.setRotationPoint(8F, 11F, 0F);
        Tentacle231.setTextureSize(64, 32);
        Tentacle231.mirror = true;
        setRotation(Tentacle231, 0F, 0F, 0F);
        Tentacle232 = new ModelRenderer(this, 40, 6);
        Tentacle232.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle232.setRotationPoint(0F, -9F, 0F);
        Tentacle232.setTextureSize(64, 32);
        Tentacle232.mirror = true;
        setRotation(Tentacle232, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle222 = new ModelRenderer(this, 40, 6);
        Tentacle222.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle222.setRotationPoint(-17F, 16F, 0F);
        Tentacle222.setTextureSize(64, 32);
        Tentacle222.mirror = true;
        setRotation(Tentacle222, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle221 = new ModelRenderer(this, 40, 0);
        Tentacle221.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle221.setRotationPoint(-13F, 16F, 0F);
        Tentacle221.setTextureSize(64, 32);
        Tentacle221.mirror = true;
        setRotation(Tentacle221, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle332 = new ModelRenderer(this, 40, 6);
        Tentacle332.addBox(0F, 0F, 0F, 5, 2, 2);
        Tentacle332.setRotationPoint(0F, 0F, 0F);
        Tentacle332.setTextureSize(64, 32);
        Tentacle332.mirror = true;
        setRotation(Tentacle332, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle432 = new ModelRenderer(this, 40, 6);
        Tentacle432.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle432.setRotationPoint(-8F, 7F, 0F);
        Tentacle432.setTextureSize(64, 32);
        Tentacle432.mirror = true;
        setRotation(Tentacle432, 0F, ((float) Math.PI * 3F / 2F), 0F);
        Tentacle311 = new ModelRenderer(this, 11, 10);
        Tentacle311.addBox(-1F, -1F, 0F, 3, 2, 9);
        Tentacle311.setRotationPoint(0F, 6F, 4F);
        Tentacle311.setTextureSize(64, 32);
        Tentacle311.mirror = true;
        setRotation(Tentacle311, -0.8028515F, ((float) Math.PI / 2F), 0F);
        Tentacle411 = new ModelRenderer(this, 11, 10);
        Tentacle411.addBox(-1F, -1F, 0F, 3, 2, 9);
        Tentacle411.setRotationPoint(-6F, 12F, 4F);
        Tentacle411.setTextureSize(64, 32);
        Tentacle411.mirror = true;
        setRotation(Tentacle411, 0.8028515F, ((float) Math.PI / 2F), 0F);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(Head, Jaw, Tentacle11, Tentacle12, Tentacle31, Tentacle511, Head1, Jaw1, Tentacle132, Tentacle122, Tentacle121,
                Tentacle131, Jaw2, Head2, Tentacle211, Tentacle212, Tentacle231, Tentacle232, Tentacle222, Tentacle221, Tentacle332,
                Tentacle432, Tentacle311, Tentacle411);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

}
