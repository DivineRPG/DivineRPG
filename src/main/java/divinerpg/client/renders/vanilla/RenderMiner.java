package divinerpg.client.renders.vanilla;


import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.vanilla.overworld.EntityMiner;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderMiner extends MobRenderer<EntityMiner, ModelMiner<EntityMiner>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/miner.png");

    public RenderMiner(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelMiner<EntityMiner>(), 0.8F);
        this.addLayer(new MinerPickLayer(this));
    }
    protected void preRenderCallback(EntityMiner entity, MatrixStack matrixStackIn, float partialTickTime) {
    }
    public ResourceLocation getEntityTexture(EntityMiner entity) {
        return TEXTURE;
    }
}