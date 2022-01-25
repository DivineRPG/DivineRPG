package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderDivineArrow extends ArrowRenderer<EntityDivineArrow> {


    public RenderDivineArrow(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDivineArrow arrow) {
        if(arrow.getArrowType() != null) {
            return arrow.getTexture();
        }else
            return new ResourceLocation("minecraft:textures/entity/projectiles/arrow.png");
    }
}
