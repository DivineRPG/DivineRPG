package divinerpg.client.renders.entity.vanilla;

import divinerpg.client.models.vanilla.ModelRainbour;
import divinerpg.entities.vanilla.overworld.EntityRainbour;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.OnlyIn;

import static divinerpg.DivineRPG.MODID;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class RenderRainbour extends MobRenderer<EntityRainbour, ModelRainbour> {
    private final ResourceLocation
            RAINBOUR = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/rainbour.png"),
            RAINBOUR_ANGRY = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/rainbour_angry.png");
    public RenderRainbour(EntityRendererProvider.Context context) {super(context, new ModelRainbour(context), .5F);}
    @Override public ResourceLocation getTextureLocation(EntityRainbour entity) {return entity.isAggressive() ? RAINBOUR_ANGRY : RAINBOUR;}
}