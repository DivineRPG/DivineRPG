package divinerpg.client.renders.entity.vanilla;


import divinerpg.DivineRPG;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.EntityShark;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderShark extends MobRenderer<EntityShark, ModelShark<EntityShark>> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/entity/shark.png");

    public RenderShark(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelShark<>(), 0.8F);
    }

    public ResourceLocation getEntityTexture(EntityShark entity) {
        return TEXTURE;
    }
}