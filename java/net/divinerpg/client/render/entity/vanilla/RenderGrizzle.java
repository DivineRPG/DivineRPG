package net.divinerpg.client.render.entity.vanilla;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.client.render.RenderDivineMob;
import net.divinerpg.client.render.entity.vanilla.model.ModelGrizzle;
import net.divinerpg.entities.vanilla.EntityGrizzle;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGrizzle extends RenderDivineMob {

    public RenderGrizzle() {
        super(new ModelGrizzle(), 0.5f, null);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        this.mainModel = new ModelGrizzle();
        return ((EntityGrizzle)entity).getColor() == 1 ? EntityResourceLocation.brownGrizzle : EntityResourceLocation.whiteGrizzle;
    }

}
