package divinerpg.client.renders.entity.boss;

import divinerpg.DivineRPG;
import divinerpg.client.models.boss.ModelKitra;
import divinerpg.entities.boss.EntityKitra;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import javax.annotation.Nullable;

@OnlyIn(Dist.CLIENT)
public class RenderKitra extends MobRenderer<EntityKitra, ModelKitra> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/entity/kitra.png");
    public RenderKitra(EntityRendererProvider.Context context) {super(context, new ModelKitra(context), 0);}
    //TODO: items and water isn't rendered when looking through (same goes for its statues)
    @Nullable
    @Override protected RenderType getRenderType(EntityKitra entity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityTranslucent(getTextureLocation(entity));
    }
    @Override public ResourceLocation getTextureLocation(EntityKitra entity) {return TEXTURE;}
}