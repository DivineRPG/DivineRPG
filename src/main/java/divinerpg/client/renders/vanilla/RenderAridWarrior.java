package divinerpg.client.renders.vanilla;


import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.AridWarriorBowLayer;
import divinerpg.entities.vanilla.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAridWarrior extends MobRenderer<EntityAridWarrior, ModelAridWarrior<EntityAridWarrior>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/arid_warrior.png");

    public RenderAridWarrior(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelAridWarrior<>(), 0.8F);
        this.addLayer(new AridWarriorBowLayer(this));
    }

    public ResourceLocation getEntityTexture(EntityAridWarrior entity) {
        return TEXTURE;
    }
}