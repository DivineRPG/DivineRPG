package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelEnchantedArcher;
import divinerpg.client.renders.layer.EnchantedArcherLayer;
import divinerpg.entities.apalachia.EntityEnchantedArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

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