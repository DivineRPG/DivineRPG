package divinerpg.client.renders.base;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraftforge.api.distmarker.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

@OnlyIn(Dist.CLIENT)
public class RenderDivineMob<Type extends Mob> extends MobRenderer<Type, EntityModel<Type>> {
    protected final ResourceLocation TEXTURE;
    protected final float scale;
    public RenderDivineMob(Context context, String name, EntityModel<Type> model) {
    	this(context, name, model, 1F);
    }
    public RenderDivineMob(Context context, String name, EntityModel<Type> model, float shadowSize) {
        super(context, model, shadowSize);
        this.scale = 1;
        this.TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }

    public RenderDivineMob(Context context, String name, EntityModel<Type> model, float shadowSize, float scale) {
        super(context, model, shadowSize);
        this.scale = scale;
        this.TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }

    @Override
    protected void scale(Type type, PoseStack stack, float s) {
        stack.scale(this.scale, this.scale, this.scale);
    }

    @Override
    public ResourceLocation getTextureLocation(Type type) {
        return TEXTURE;
    }
}