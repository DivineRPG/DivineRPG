package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import static divinerpg.DivineRPG.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderAridWarrior extends HumanoidMobRenderer<EntityAridWarrior, ModelAridWarrior> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/arid_warrior.png");
    public RenderAridWarrior(EntityRendererProvider.Context  context) {
        super(context, new ModelAridWarrior(context.bakeLayer(ModelAridWarrior.LAYER_LOCATION)), .5F);
    }
    @Override public ResourceLocation getTextureLocation(EntityAridWarrior entity) {return TEXTURE;}
}