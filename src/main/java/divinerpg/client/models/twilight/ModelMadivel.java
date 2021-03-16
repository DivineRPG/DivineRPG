package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelMadivel<T extends Entity> extends SegmentedModel<T> {
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer neckbone;
    ModelRenderer neck;
    ModelRenderer headbone;
    ModelRenderer rightarmbones;
    ModelRenderer leftarmbones;

    public ModelMadivel()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 35, 0);
        head.addBox(-4F, -8F, -4F, 6, 9, 7);
        head.setPos(1F, -13F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, -7F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, -5F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, -5F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 9);
        rightleg.addBox(-2F, 0F, -2F, 4, 19, 4);
        rightleg.setPos(-2F, 5F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 9);
        leftleg.addBox(-2F, 0F, -2F, 4, 19, 4);
        leftleg.setPos(2F, 5F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        neckbone = new ModelRenderer(this, 2, 1);
        neckbone.addBox(-6F, 1F, -1F, 10, 2, 2);
        neckbone.setPos(1F, -13F, 0F);
        neckbone.setTexSize(64, 32);
        neckbone.mirror = true;
        setRotation(neckbone, 0F, 0F, 0F);
        neck = new ModelRenderer(this, 36, 20);
        neck.addBox(0F, 0F, 0F, 4, 5, 4);
        neck.setPos(-2F, -12F, -2F);
        neck.setTexSize(64, 32);
        neck.mirror = true;
        setRotation(neck, 0F, 0F, 0F);
        headbone = new ModelRenderer(this, 2, 1);
        headbone.addBox(-6F, -2F, 0F, 10, 2, 2);
        headbone.setPos(1F, -18F, -1F);
        headbone.setTexSize(64, 32);
        headbone.mirror = true;
        setRotation(headbone, 0F, 0F, 0F);
        rightarmbones = new ModelRenderer(this, 40, 24);
        rightarmbones.addBox(-8F, -2F, -1F, 6, 3, 2);
        rightarmbones.setPos(-5F, -1F, 0F);
        rightarmbones.setTexSize(64, 32);
        rightarmbones.mirror = true;
        setRotation(rightarmbones, 0F, 0F, 0F);
        leftarmbones = new ModelRenderer(this, 40, 24);
        leftarmbones.addBox(2F, 2F, -1F, 6, 3, 2);
        leftarmbones.setPos(5F, -5F, 0F);
        leftarmbones.setTexSize(64, 32);
        leftarmbones.mirror = true;
        setRotation(leftarmbones, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, body, rightarm, leftarm, rightleg, leftleg, neckbone, neck, headbone, rightarmbones, leftarmbones);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.xRot = var2;
        var1.yRot = var3;
        var1.zRot = var4;
    }

    @Override
    public void setupAnim(T ent, float var1, float var2, float var3, float var4, float var5)
    {
        this.head.yRot = var4 / (180F / (float)Math.PI);
        this.head.xRot = var5 / (180F / (float)Math.PI);
        this.rightarm.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.xRot = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.zRot = 0.0F;
        this.leftarm.zRot = 0.0F;
        this.rightleg.xRot = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.xRot = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.yRot = 0.0F;
        this.leftleg.yRot = 0.0F;
    }
}
