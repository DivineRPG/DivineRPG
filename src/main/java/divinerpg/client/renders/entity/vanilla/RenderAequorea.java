package divinerpg.client.renders.entity.vanilla;


import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.vanilla.overworld.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderAequorea extends MobRenderer<EntityAequorea, ModelAequorea<EntityAequorea>> {

    public RenderAequorea(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new ModelAequorea<>(), 0.8F);
    }

    public ResourceLocation getTextureLocation(EntityAequorea entity) {
        ResourceLocation texture;
        switch(entity.getColour()) {
            case 1:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_blue.png");
                break;
            case 2:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_green.png");
                break;
            case 3:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_pink.png");
                break;
            case 4:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_purple.png");
                break;
            case 5:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_red.png");
                break;
            default:
                texture = new ResourceLocation(DivineRPG.MODID, "textures/entity/aequorea_yellow.png");
        }
        return texture;
    }
}