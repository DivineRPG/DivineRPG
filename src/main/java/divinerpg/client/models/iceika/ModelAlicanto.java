package divinerpg.client.models.iceika;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;
@OnlyIn(Dist.CLIENT)
public class ModelAlicanto<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer spikebottom1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer spikebottom2;
    ModelRenderer headext1;
    ModelRenderer tail;
    ModelRenderer horngate1;
    ModelRenderer hornbottom1;
    ModelRenderer hornend;
    ModelRenderer horngate2;
    ModelRenderer horn;
    ModelRenderer hornbottom2;
    ModelRenderer hornbtm1;
    ModelRenderer hornbtm2;
    ModelRenderer headjoint;
    ModelRenderer headcap1;
    ModelRenderer headext2;
    ModelRenderer headcap2;
    ModelRenderer spikebottom3;
    ModelRenderer spike15;
    ModelRenderer spike14;
    ModelRenderer spike1;
    ModelRenderer spike6;
    ModelRenderer spike7;
    ModelRenderer wing1;
    ModelRenderer wing1slide1;
    ModelRenderer wing2;
    ModelRenderer wing1slide2;
    ModelRenderer wing1slide3;
    ModelRenderer wing2slide2;
    ModelRenderer wing2slide1;
    ModelRenderer wing2slide3;

    public ModelAlicanto()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 12);
        head.setPos(0F, 6F, -10F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 19, 0);
        body.addBox(-6F, -10F, -7F, 12, 22, 10);
        body.setPos(0F, 11F, 2F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.8644027F, 0F, 0F);
        wing1 = new ModelRenderer(this, 0, 0);
        wing1.addBox(-14F, 0F, -5F, 20, 1, 10);
        wing1.setPos(-11F, 12F, 0F);
        wing1.setTexSize(64, 32);
        wing1.mirror = true;
        setRotation(wing1, -0.7330383F, 0F, 0F);
        wing1slide1 = new ModelRenderer(this, 26, 4);
        wing1slide1.addBox(-12F, -1F, -6F, 2, 3, 12);
        wing1slide1.setPos(-5F, 12F, 0F);
        wing1slide1.setTexSize(64, 32);
        wing1slide1.mirror = true;
        setRotation(wing1slide1, -0.7330383F, 0F, 0F);
        spikebottom1 = new ModelRenderer(this, 13, 21);
        spikebottom1.addBox(0F, 0F, 0F, 2, 10, 2);
        spikebottom1.setPos(3F, 7F, 13F);
        spikebottom1.setTexSize(64, 32);
        spikebottom1.mirror = true;
        setRotation(spikebottom1, -0.2602503F, 0F, 0F);
        spike2 = new ModelRenderer(this, 13, 21);
        spike2.addBox(0F, 0F, 0F, 2, 10, 1);
        spike2.setPos(3F, -4F, 0F);
        spike2.setTexSize(64, 32);
        spike2.mirror = true;
        setRotation(spike2, -0.2602503F, 0F, 0F);
        spike3 = new ModelRenderer(this, 13, 21);
        spike3.addBox(0F, 0F, 0F, 2, 10, 1);
        spike3.setPos(3F, -1F, 5F);
        spike3.setTexSize(64, 32);
        spike3.mirror = true;
        setRotation(spike3, -0.2602503F, 0F, 0F);
        spike4 = new ModelRenderer(this, 40, 15);
        spike4.addBox(0F, -3F, 0F, 2, 13, 1);
        spike4.setPos(-1F, -4F, 0F);
        spike4.setTexSize(64, 32);
        spike4.mirror = true;
        setRotation(spike4, -0.2602503F, 0F, 0F);
        spike5 = new ModelRenderer(this, 40, 15);
        spike5.addBox(0F, -3F, 0F, 2, 13, 1);
        spike5.setPos(-1F, -1F, 5F);
        spike5.setTexSize(64, 32);
        spike5.mirror = true;
        setRotation(spike5, -0.2602503F, 0F, 0F);
        spikebottom2 = new ModelRenderer(this, 40, 15);
        spikebottom2.addBox(0F, -3F, 0F, 2, 13, 2);
        spikebottom2.setPos(-1F, 7F, 13F);
        spikebottom2.setTexSize(64, 32);
        spikebottom2.mirror = true;
        setRotation(spikebottom2, -0.2602503F, 0F, 0F);
        headext1 = new ModelRenderer(this, 23, 14);
        headext1.addBox(0F, 0F, -1F, 2, 2, 2);
        headext1.setPos(-6F, 4F, -10F);
        headext1.setTexSize(64, 32);
        headext1.mirror = true;
        setRotation(headext1, 0F, 0F, 0F);
        tail = new ModelRenderer(this, 23, 14);
        tail.addBox(0F, 0F, 0F, 2, 4, 14);
        tail.setPos(-1F, 18F, 8F);
        tail.setTexSize(64, 32);
        tail.mirror = true;
        setRotation(tail, 0F, 0F, 0F);
        horngate1 = new ModelRenderer(this, 23, 14);
        horngate1.addBox(0F, 0F, 0F, 4, 6, 2);
        horngate1.setPos(-2F, -6F, -15F);
        horngate1.setTexSize(64, 32);
        horngate1.mirror = true;
        setRotation(horngate1, 0F, 0F, 0F);
        hornbottom1 = new ModelRenderer(this, 23, 14);
        hornbottom1.addBox(-15F, 0F, -1F, 4, 4, 4);
        hornbottom1.setPos(6F, 11F, -21F);
        hornbottom1.setTexSize(64, 32);
        hornbottom1.mirror = true;
        setRotation(hornbottom1, 0.6108652F, 0F, 0F);
        hornend = new ModelRenderer(this, 23, 14);
        hornend.addBox(0F, 0F, 0F, 4, 6, 5);
        hornend.setPos(-2F, -6F, -24F);
        hornend.setTexSize(64, 32);
        hornend.mirror = true;
        setRotation(hornend, 0F, 0F, 0F);
        horngate2 = new ModelRenderer(this, 23, 14);
        horngate2.addBox(0F, 0F, 0F, 4, 6, 2);
        horngate2.setPos(-2F, -6F, -18F);
        horngate2.setTexSize(64, 32);
        horngate2.mirror = true;
        setRotation(horngate2, 0F, 0F, 0F);
        horn = new ModelRenderer(this, 23, 14);
        horn.addBox(0F, 0F, 0F, 2, 4, 14);
        horn.setPos(-1F, -5F, -23F);
        horn.setTexSize(64, 32);
        horn.mirror = true;
        setRotation(horn, 0F, 0F, 0F);
        hornbottom2 = new ModelRenderer(this, 23, 14);
        hornbottom2.addBox(-1F, 0F, -1F, 4, 4, 4);
        hornbottom2.setPos(6F, 11F, -21F);
        hornbottom2.setTexSize(64, 32);
        hornbottom2.mirror = true;
        setRotation(hornbottom2, 0.6108652F, 0F, 0F);
        hornbtm1 = new ModelRenderer(this, 23, 14);
        hornbtm1.addBox(-14F, 0F, 2F, 2, 2, 12);
        hornbtm1.setPos(6F, 12F, -21F);
        hornbtm1.setTexSize(64, 32);
        hornbtm1.mirror = true;
        setRotation(hornbtm1, 0.6108652F, 0F, 0F);
        hornbtm2 = new ModelRenderer(this, 23, 14);
        hornbtm2.addBox(0F, 0F, 2F, 2, 2, 12);
        hornbtm2.setPos(6F, 12F, -21F);
        hornbtm2.setTexSize(64, 32);
        hornbtm2.mirror = true;
        setRotation(hornbtm2, 0.6108652F, 0F, 0F);
        headjoint = new ModelRenderer(this, 23, 14);
        headjoint.addBox(0F, 0F, 0F, 2, 4, 4);
        headjoint.setPos(-1F, -1F, -13F);
        headjoint.setTexSize(64, 32);
        headjoint.mirror = true;
        setRotation(headjoint, 0F, 0F, 0F);
        headcap1 = new ModelRenderer(this, 23, 14);
        headcap1.addBox(3F, 0F, -1F, 4, 4, 4);
        headcap1.setPos(-12F, 3F, -11F);
        headcap1.setTexSize(64, 32);
        headcap1.mirror = true;
        setRotation(headcap1, 0F, 0F, 0F);
        headext2 = new ModelRenderer(this, 23, 14);
        headext2.addBox(0F, 0F, -1F, 2, 2, 2);
        headext2.setPos(4F, 4F, -10F);
        headext2.setTexSize(64, 32);
        headext2.mirror = true;
        setRotation(headext2, 0F, 0F, 0F);
        headcap2 = new ModelRenderer(this, 23, 14);
        headcap2.addBox(3F, 0F, -1F, 4, 4, 4);
        headcap2.setPos(2F, 3F, -11F);
        headcap2.setTexSize(64, 32);
        headcap2.mirror = true;
        setRotation(headcap2, 0F, 0F, 0F);
        spikebottom3 = new ModelRenderer(this, 13, 21);
        spikebottom3.addBox(0F, 0F, 0F, 2, 10, 2);
        spikebottom3.setPos(-5F, 7F, 13F);
        spikebottom3.setTexSize(64, 32);
        spikebottom3.mirror = true;
        setRotation(spikebottom3, -0.2602503F, 0F, 0F);
        spike15 = new ModelRenderer(this, 13, 21);
        spike15.addBox(0F, 0F, 0F, 2, 10, 1);
        spike15.setPos(-5F, -1F, 5F);
        spike15.setTexSize(64, 32);
        spike15.mirror = true;
        setRotation(spike15, -0.2602503F, 0F, 0F);
        spike14 = new ModelRenderer(this, 13, 21);
        spike14.addBox(0F, 0F, 0F, 2, 10, 1);
        spike14.setPos(-5F, -4F, 0F);
        spike14.setTexSize(64, 32);
        spike14.mirror = true;
        setRotation(spike14, -0.2602503F, 0F, 0F);
        spike1 = new ModelRenderer(this, 13, 21);
        spike1.addBox(0F, 0F, 0F, 2, 10, 1);
        spike1.setPos(3F, 4F, 10F);
        spike1.setTexSize(64, 32);
        spike1.mirror = true;
        setRotation(spike1, -0.2602503F, 0F, 0F);
        spike6 = new ModelRenderer(this, 40, 15);
        spike6.addBox(0F, -3F, 0F, 2, 13, 1);
        spike6.setPos(-1F, 4F, 10F);
        spike6.setTexSize(64, 32);
        spike6.mirror = true;
        setRotation(spike6, -0.2602503F, 0F, 0F);
        spike7 = new ModelRenderer(this, 13, 21);
        spike7.addBox(0F, 0F, 0F, 2, 10, 1);
        spike7.setPos(-5F, 4F, 10F);
        spike7.setTexSize(64, 32);
        spike7.mirror = true;
        setRotation(spike7, -0.2602503F, 0F, 0F);
        wing2 = new ModelRenderer(this, 0, 0);
        wing2.addBox(0F, 0F, -5F, 20, 1, 10);
        wing2.setPos(6F, 12F, 0F);
        wing2.setTexSize(64, 32);
        wing2.mirror = true;
        setRotation(wing2, -0.7330383F, 0F, 0F);
        wing1slide2 = new ModelRenderer(this, 26, 4);
        wing1slide2.addBox(-22F, -1F, -6F, 2, 3, 12);
        wing1slide2.setPos(-5F, 12F, 0F);
        wing1slide2.setTexSize(64, 32);
        wing1slide2.mirror = true;
        setRotation(wing1slide2, -0.7330383F, 0F, 0F);
        wing1slide3 = new ModelRenderer(this, 26, 4);
        wing1slide3.addBox(-2F, -1F, -6F, 2, 3, 12);
        wing1slide3.setPos(-5F, 12F, 0F);
        wing1slide3.setTexSize(64, 32);
        wing1slide3.mirror = true;
        setRotation(wing1slide3, -0.7330383F, 0F, 0F);
        wing2slide2 = new ModelRenderer(this, 26, 4);
        wing2slide2.addBox(10F, -1F, -6F, 2, 3, 12);
        wing2slide2.setPos(6F, 12F, 0F);
        wing2slide2.setTexSize(64, 32);
        wing2slide2.mirror = true;
        setRotation(wing2slide2, -0.7330383F, 0F, 0F);
        wing2slide1 = new ModelRenderer(this, 26, 4);
        wing2slide1.addBox(0F, -1F, -6F, 2, 3, 12);
        wing2slide1.setPos(6F, 12F, 0F);
        wing2slide1.setTexSize(64, 32);
        wing2slide1.mirror = true;
        setRotation(wing2slide1, -0.7330383F, 0F, 0F);
        wing2slide3 = new ModelRenderer(this, 26, 4);
        wing2slide3.addBox(20F, -1F, -6F, 2, 3, 12);
        wing2slide3.setPos(6F, 12F, 0F);
        wing2slide3.setTexSize(64, 32);
        wing2slide3.mirror = true;
        setRotation(wing2slide3, -0.7330383F, 0F, 0F);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = ((float)(entityIn.getId() * 3) + ageInTicks) * 0.13F;

        wing1.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
        wing1slide1.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
        wing1slide2.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);
        wing1slide3.zRot = MathHelper.cos(f) * 16.0F * ((float)Math.PI / 180F);

        wing2.zRot = -wing1.zRot;
        wing2slide1.zRot = -wing1.zRot;
        wing2slide2.zRot = -wing1.zRot;
        wing2slide3.zRot = -wing1.zRot;
    }


    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, wing1, wing1slide1, spikebottom1, spike2, spike3, spike4, spike5, spikebottom2, headext1, tail, horngate1, hornbottom1, hornend, horngate2, horn, hornbottom2, hornbtm1,
    hornbtm2, headjoint, headcap1, headext2, headcap2, spikebottom3, spike15, spike14, spike1, spike6, spike7, wing2, wing1slide2, wing1slide3, wing2slide2, wing2slide1, wing2slide3);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    public void setRotationAngles(float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.wing1slide1.yRot = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
        this.wing1slide2.yRot = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
        this.wing1slide3.yRot = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
        this.wing1.yRot = MathHelper.cos(par4 * 1.3F) * (float)Math.PI * 0.25F;
        this.wing2.yRot = -this.wing1.yRot;
        this.wing2slide1.yRot = -this.wing1.yRot;
        this.wing2slide2.yRot = -this.wing1.yRot;
        this.wing2slide3.yRot = -this.wing1.yRot;
    }

}
