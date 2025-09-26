package divinerpg.client.renders.entity.twilight;

import divinerpg.client.models.twilight.ModelSunArcher;
import divinerpg.entities.eden.EntitySunArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import static divinerpg.DivineRPG.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderSunArcher extends HumanoidMobRenderer<EntitySunArcher, ModelSunArcher> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/sun_archer.png");
    public RenderSunArcher(EntityRendererProvider.Context context) {
        super(context, new ModelSunArcher(context.bakeLayer(ModelSunArcher.LAYER_LOCATION)), .57F);
    }
    @Override public ResourceLocation getTextureLocation(EntitySunArcher entity) {return TEXTURE;}
}