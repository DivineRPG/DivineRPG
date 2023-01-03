package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.apalachia.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraftforge.api.distmarker.*;

import net.minecraft.resources.ResourceLocation;

@OnlyIn(Dist.CLIENT)
public class RenderEnchantedArcher extends MobRenderer<EntityEnchantedArcher, ModelEnchantedArcher<EntityEnchantedArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_archer.png");

    public RenderEnchantedArcher(EntityRendererProvider.Context context) {
        super(context, new ModelEnchantedArcher<>(context), 0.8F);
        this.addLayer(new EnchantedArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEnchantedArcher entity) {
        return TEXTURE;
    }

}