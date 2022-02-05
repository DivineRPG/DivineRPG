package divinerpg.client.renders.entity.projectile;

import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class RenderDivineArrow extends ArrowRenderer<EntityDivineArrow> {


    public RenderDivineArrow(EntityRendererManager manager) {
        super(manager);
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDivineArrow arrow) {
            return arrow.getTexture();
    }
}
