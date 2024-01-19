package divinerpg.client.renders.entity.vanilla;

import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.ModelRainbour;
import divinerpg.entities.vanilla.overworld.EntityRainbour;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderRainbour extends MobRenderer<EntityRainbour, ModelRainbour> {
    private final ResourceLocation
            rainbourLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/rainbour.png"),
            angryRainbourLoc = new ResourceLocation(DivineRPG.MODID, "textures/entity/angry_rainbour.png");
    public RenderRainbour(Context context) {
        super(context, new ModelRainbour(context), 0.5F);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRainbour entity) {
        return entity.isAggressive() ? angryRainbourLoc : rainbourLoc;
    }
}