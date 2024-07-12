package divinerpg.client.renders.base;


import com.mojang.blaze3d.vertex.PoseStack;

import divinerpg.DivineRPG;
import net.minecraft.client.model.BatModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;

import static divinerpg.util.ClientUtils.layerBat;

public class RenderDivineBat<Type extends Mob> extends MobRenderer<Type, HierarchicalModel<Type>>{
	protected final ResourceLocation TEXTURE;
    protected float scale;
    public RenderDivineBat(Context context, String name) {
    	this(context, name, 1F, 1F);
    }
    public RenderDivineBat(Context context, String name, float scale) {
    	this(context, name, scale, scale);
    }
	@SuppressWarnings("unchecked")
	public RenderDivineBat(Context context, String name, float shadowSize, float scale) {
        super(context, (HierarchicalModel<Type>) new BatModel(context.bakeLayer(layerBat)), shadowSize);
        this.scale = scale;
        this.TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/" + name + ".png");
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
