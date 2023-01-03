package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.models.iceika.ModelFrostArcher;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.iceika.EntityFrostArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderFrostArcher extends MobRenderer<EntityFrostArcher, ModelFrostArcher<EntityDivineMonster>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/frost_archer.png");

    public RenderFrostArcher(EntityRendererProvider.Context context) {
        super(context, new ModelFrostArcher<>(context), 0.8F);
        this.addLayer(new FrostArcherBowLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrostArcher entity) {
        return TEXTURE;
    }

}