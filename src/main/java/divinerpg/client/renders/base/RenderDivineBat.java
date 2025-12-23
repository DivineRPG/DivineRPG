package divinerpg.client.renders.base;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelJungleBat;
import net.minecraft.client.model.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

public class RenderDivineBat<Type extends Mob> extends MobRenderer<Type, HierarchicalModel<Type>>{
	protected final ResourceLocation TEXTURE;
    protected float scale;
	@SuppressWarnings("unchecked")
	public RenderDivineBat(EntityRendererProvider.Context context, String name, float shadowSize, float scale) {
        super(context, (HierarchicalModel<Type>) new ModelJungleBat(context), shadowSize);
        this.scale = scale;
        TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
    }
    @Override protected void scale(Type type, PoseStack stack, float s) {stack.scale(scale, scale, scale);}
    @Override public ResourceLocation getTextureLocation(Type type) {return TEXTURE;}
}