package divinerpg.client.models.twilight;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelCori<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer Head;
    ModelRenderer Tentacle1;
    ModelRenderer Tentacle2;
    ModelRenderer Tentacle3;
    ModelRenderer Tentacle4;
    ModelRenderer Tentacle5;
    ModelRenderer Tentacle6;
    ModelRenderer Tentacle7;
    ModelRenderer Tentacle8;
    ModelRenderer Tentacle9;
    ModelRenderer Tentacle10;
    ModelRenderer Tentacle11;
    ModelRenderer Tentacle12;
    ModelRenderer Tentacle13;
    ModelRenderer Tentacle14;
    ModelRenderer Tentacle15;
    ModelRenderer Tentacle16;
    ModelRenderer Tentacle17;
    ModelRenderer Tentacle18;
    ModelRenderer Tentacle19;
    ModelRenderer Tentacle20;

    public ModelCori()
    {
        texWidth = 64;
        texHeight = 32;

        Head = new ModelRenderer(this, 0, 0);
        Head.addBox(-5F, -5F, -5F, 10, 10, 10);
        Head.setPos(0F, 11F, 0F);
        Head.setTexSize(64, 32);
        Head.mirror = true;
        setRotation(Head, 0F, -1.570796F, 0F);
        Tentacle1 = new ModelRenderer(this, 40, 0);
        Tentacle1.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle1.setPos(5F, 2F, 5F);
        Tentacle1.setTexSize(64, 32);
        Tentacle1.mirror = true;
        setRotation(Tentacle1, 0F, 1.570796F, 0F);
        Tentacle2 = new ModelRenderer(this, 52, 0);
        Tentacle2.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle2.setPos(0F, 19F, 0F);
        Tentacle2.setTexSize(64, 32);
        Tentacle2.mirror = true;
        setRotation(Tentacle2, 0F, 0F, 0F);
        Tentacle3 = new ModelRenderer(this, 40, 6);
        Tentacle3.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle3.setPos(0F, 20F, 0F);
        Tentacle3.setTexSize(64, 32);
        Tentacle3.mirror = true;
        setRotation(Tentacle3, 0F, 4.712389F, 0F);
        Tentacle4 = new ModelRenderer(this, 11, 0);
        Tentacle4.addBox(-1F, -3F, -1F, 2, 5, 2);
        Tentacle4.setPos(6F, 17F, 5F);
        Tentacle4.setTexSize(64, 32);
        Tentacle4.mirror = true;
        setRotation(Tentacle4, 0F, 0F, 0F);
        Tentacle5 = new ModelRenderer(this, 40, 6);
        Tentacle5.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle5.setPos(0F, 2F, 0F);
        Tentacle5.setTexSize(64, 32);
        Tentacle5.mirror = true;
        setRotation(Tentacle5, 0F, 4.712389F, 0F);
        Tentacle6 = new ModelRenderer(this, 40, 6);
        Tentacle6.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle6.setPos(-9F, 11F, 0F);
        Tentacle6.setTexSize(64, 32);
        Tentacle6.mirror = true;
        setRotation(Tentacle6, 0F, 4.712389F, 0F);
        Tentacle7 = new ModelRenderer(this, 40, 6);
        Tentacle7.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle7.setPos(9F, 11F, 0F);
        Tentacle7.setTexSize(64, 32);
        Tentacle7.mirror = true;
        setRotation(Tentacle7, 0F, 4.712389F, 0F);
        Tentacle8 = new ModelRenderer(this, 40, 0);
        Tentacle8.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle8.setPos(-5F, 2F, 5F);
        Tentacle8.setTexSize(64, 32);
        Tentacle8.mirror = true;
        setRotation(Tentacle8, 0F, 4.712389F, 0F);
        Tentacle9 = new ModelRenderer(this, 40, 6);
        Tentacle9.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle9.setPos(9F, 2F, 5F);
        Tentacle9.setTexSize(64, 32);
        Tentacle9.mirror = true;
        setRotation(Tentacle9, 0F, 4.712389F, 0F);
        Tentacle10 = new ModelRenderer(this, 40, 6);
        Tentacle10.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle10.setPos(9F, 20F, 5F);
        Tentacle10.setTexSize(64, 32);
        Tentacle10.mirror = true;
        setRotation(Tentacle10, 0F, 4.712389F, 0F);
        Tentacle11 = new ModelRenderer(this, 40, 6);
        Tentacle11.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle11.setPos(-9F, 20F, 5F);
        Tentacle11.setTexSize(64, 32);
        Tentacle11.mirror = true;
        setRotation(Tentacle11, 0F, 4.712389F, 0F);
        Tentacle12 = new ModelRenderer(this, 40, 6);
        Tentacle12.addBox(-4F, -1F, -1F, 5, 2, 2);
        Tentacle12.setPos(-9F, 2F, 5F);
        Tentacle12.setTexSize(64, 32);
        Tentacle12.mirror = true;
        setRotation(Tentacle12, 0F, 4.712389F, 0F);
        Tentacle13 = new ModelRenderer(this, 40, 0);
        Tentacle13.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle13.setPos(-5F, 11F, 0F);
        Tentacle13.setTexSize(64, 32);
        Tentacle13.mirror = true;
        setRotation(Tentacle13, 0F, 4.712389F, 0F);
        Tentacle14 = new ModelRenderer(this, 40, 0);
        Tentacle14.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle14.setPos(5F, 11F, 0F);
        Tentacle14.setTexSize(64, 32);
        Tentacle14.mirror = true;
        setRotation(Tentacle14, 0F, 1.570796F, 0F);
        Tentacle15 = new ModelRenderer(this, 40, 0);
        Tentacle15.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle15.setPos(-5F, 20F, 5F);
        Tentacle15.setTexSize(64, 32);
        Tentacle15.mirror = true;
        setRotation(Tentacle15, 0F, 4.712389F, 0F);
        Tentacle16 = new ModelRenderer(this, 40, 0);
        Tentacle16.addBox(-1F, -1F, 0F, 2, 2, 3);
        Tentacle16.setPos(5F, 20F, 5F);
        Tentacle16.setTexSize(64, 32);
        Tentacle16.mirror = true;
        setRotation(Tentacle16, 0F, 1.570796F, 0F);
        Tentacle17 = new ModelRenderer(this, 52, 0);
        Tentacle17.addBox(-1F, -3F, -1F, 2, 3, 2);
        Tentacle17.setPos(0F, 6F, 0F);
        Tentacle17.setTexSize(64, 32);
        Tentacle17.mirror = true;
        setRotation(Tentacle17, 0F, 0F, 0F);
        Tentacle18 = new ModelRenderer(this, 11, 0);
        Tentacle18.addBox(-1F, -3F, -1F, 2, 5, 2);
        Tentacle18.setPos(-6F, 17F, 5F);
        Tentacle18.setTexSize(64, 32);
        Tentacle18.mirror = true;
        setRotation(Tentacle18, 0F, 0F, 0F);
        Tentacle19 = new ModelRenderer(this, 11, 0);
        Tentacle19.addBox(-1F, -3F, -1F, 2, 5, 2);
        Tentacle19.setPos(6F, 6F, 5F);
        Tentacle19.setTexSize(64, 32);
        Tentacle19.mirror = true;
        setRotation(Tentacle19, 0F, 0F, 0F);
        Tentacle20 = new ModelRenderer(this, 11, 0);
        Tentacle20.addBox(-1F, -3F, -1F, 2, 5, 2);
        Tentacle20.setPos(-6F, 6F, 5F);
        Tentacle20.setTexSize(64, 32);
        Tentacle20.mirror = true;
        setRotation(Tentacle20, 0F, 0F, 0F);
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Head, Tentacle1, Tentacle2, Tentacle3, Tentacle4, Tentacle5, Tentacle6, Tentacle7, Tentacle8, Tentacle9, Tentacle10, Tentacle11, Tentacle12, Tentacle13, Tentacle14, Tentacle15, Tentacle16, Tentacle17, Tentacle18, Tentacle19, Tentacle20);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }


}
