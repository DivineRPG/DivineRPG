package divinerpg.client.renders.entity.iceika;

import divinerpg.DivineRPG;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.iceika.EntityFrostArcher;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderFrostArcher extends MobRenderer<EntityFrostArcher, BipedModel<EntityFrostArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/frost_archer.png");

    public RenderFrostArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new BipedModel<EntityFrostArcher>(1), 0.8F);
        this.addLayer(new FrostArcherBowLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityFrostArcher entity) {
        return TEXTURE;
    }

}