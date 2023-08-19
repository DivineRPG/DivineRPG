package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelEnchantedWarrior;
import divinerpg.client.renders.layer.EnchantedWarriorLayer;
import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEnchantedWarrior extends MobRenderer<EntityEnchantedWarrior, ModelEnchantedWarrior<EntityEnchantedWarrior>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_warrior.png");

    public RenderEnchantedWarrior(EntityRendererProvider.Context context) {
        super(context, new ModelEnchantedWarrior<>(context), 0.5F);
        this.addLayer(new EnchantedWarriorLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEnchantedWarrior entity) {
        return TEXTURE;
    }

}