package divinerpg.client.renders.entity.vanilla;


import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderMiner extends MobRenderer<EntityMiner, ModelMiner<EntityMiner>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/miner.png");

    public RenderMiner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelMiner<EntityMiner>(), 0.8F);
        this.addLayer(new MinerPickLayer(this));
    }
    public ResourceLocation getTextureLocation(EntityMiner entity) {
        return TEXTURE;
    }
}