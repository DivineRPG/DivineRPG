package divinerpg.client.renders.entity.twilight;

import divinerpg.DivineRPG;
import divinerpg.client.models.twilight.ModelEnchantedWarrior;
import divinerpg.entities.apalachia.EntityEnchantedWarrior;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEnchantedWarrior extends HumanoidMobRenderer<EntityEnchantedWarrior, ModelEnchantedWarrior> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/enchanted_warrior.png");
    public RenderEnchantedWarrior(EntityRendererProvider.Context context) {
        super(context, new ModelEnchantedWarrior(context.bakeLayer(ModelEnchantedWarrior.LAYER_LOCATION)), .5F);
    }
    @Override public ResourceLocation getTextureLocation(EntityEnchantedWarrior entity) {return TEXTURE;}
}