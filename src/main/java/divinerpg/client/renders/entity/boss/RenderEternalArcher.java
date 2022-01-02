package divinerpg.client.renders.entity.boss;


import com.mojang.blaze3d.matrix.*;
import divinerpg.*;
import divinerpg.client.models.boss.*;
import divinerpg.client.renders.layer.*;
import divinerpg.entities.boss.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderEternalArcher extends MobRenderer<EntityEternalArcher, ModelEternalArcher<EntityEternalArcher>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/eternal_archer.png");

    public RenderEternalArcher(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelEternalArcher<>(), 0.8F);
        addLayer(new EternalArcherLayer(this));
    }

    @Override
    public ResourceLocation getTextureLocation(EntityEternalArcher entity) {
        return TEXTURE;
    }

    @Override
    protected void scale(EntityEternalArcher p_225620_1_, MatrixStack p_225620_2_, float p_225620_3_) {
        p_225620_2_.scale(2.5F, 2.5F, 2.5F);
    }
}