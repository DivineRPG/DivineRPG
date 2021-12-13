package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.apalachia.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEnchantedArcher extends MobRenderer<EntityEnchantedArcher, ModelEnchantedArcher<EntityEnchantedArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_archer.png");

    public RenderEnchantedArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelEnchantedArcher<>(), 0.8F);
        this.addLayer(new EnchantedArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEnchantedArcher entity) {
        return TEXTURE;
    }

}