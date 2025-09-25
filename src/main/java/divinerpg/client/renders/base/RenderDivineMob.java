package divinerpg.client.renders.base;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineMob<T extends Mob> extends MobRenderer<T, EntityModel<T>> {
    protected final ResourceLocation TEXTURE;
    protected final float scale;
    public RenderDivineMob(EntityRendererProvider.Context context, String name, EntityModel<T> model) {this(context, name, model, 1);}
    public RenderDivineMob(EntityRendererProvider.Context context, String name, EntityModel<T> model, float shadowSize) {
        super(context, model, shadowSize);
        scale = 1;
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }
    public RenderDivineMob(EntityRendererProvider.Context context, String name, EntityModel<T> model, float shadowSize, float scale) {
        super(context, model, shadowSize);
        this.scale = scale;
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }
    //TODO: to make heads of baby mobs not scaling down
    @Override protected void scale(T type, PoseStack stack, float s) {
    	if(type.isBaby()) stack.scale(scale / 2, scale / 2, scale / 2);
    	else stack.scale(scale, scale, scale);
    }
    @Override public ResourceLocation getTextureLocation(T type) {return TEXTURE;}
}