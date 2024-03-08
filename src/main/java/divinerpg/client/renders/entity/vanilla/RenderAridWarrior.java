package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelAridWarrior;
import divinerpg.client.renders.layer.AridWarriorBowLayer;
import divinerpg.entities.vanilla.overworld.EntityAridWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAridWarrior extends MobRenderer<EntityAridWarrior, ModelAridWarrior> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/arid_warrior.png");
    public RenderAridWarrior(EntityRendererProvider.Context  context) {
        super(context, new ModelAridWarrior(context), .5F);
        addLayer(new AridWarriorBowLayer(this));
    }
    @Override public ResourceLocation getTextureLocation(EntityAridWarrior entity) {return TEXTURE;}
}