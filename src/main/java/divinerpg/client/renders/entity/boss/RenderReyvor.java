package divinerpg.client.renders.entity.boss;


import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderReyvor extends MobRenderer<EntityReyvor, ModelDensos<EntityReyvor>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/reyvor.png");

    public RenderReyvor(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelDensos<EntityReyvor>(), 0.8F);
        addLayer(new ReyvorBowLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityReyvor entity) {
        return TEXTURE;
    }



}