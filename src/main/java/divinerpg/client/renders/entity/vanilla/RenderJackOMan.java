package divinerpg.client.renders.entity.vanilla;


import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderJackOMan extends MobRenderer<EntityJackOMan, ModelJackOMan<EntityJackOMan>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/jack_o_man.png");

    public RenderJackOMan(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelJackOMan(), 0.8F);
        this.addLayer(new JackOManHeadLayer(this));
        this.addLayer(new JackOManScytheLayer(this));
    }
    public ResourceLocation getTextureLocation(EntityJackOMan entity) {
        return TEXTURE;
    }
}