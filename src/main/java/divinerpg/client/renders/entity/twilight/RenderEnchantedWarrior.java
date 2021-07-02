package divinerpg.client.renders.entity.twilight;

import divinerpg.*;
import divinerpg.client.models.twilight.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.apalachia.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEnchantedWarrior extends MobRenderer<EntityEnchantedWarrior, ModelEnchantedWarrior<EntityEnchantedWarrior>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_warrior.png");

    public RenderEnchantedWarrior(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelEnchantedWarrior<>(), 0.8F);
        this.addLayer(new EnchantedWarriorLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEnchantedWarrior entity) {
        return TEXTURE;
    }

}