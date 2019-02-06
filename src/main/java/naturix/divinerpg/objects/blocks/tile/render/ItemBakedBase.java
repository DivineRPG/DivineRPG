package naturix.divinerpg.objects.blocks.tile.render;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.vecmath.Matrix4f;
import java.util.List;

@SideOnly(Side.CLIENT)
public class ItemBakedBase implements IBakedModel {
    private final IBakedModel internal;

    public ItemBakedBase(IBakedModel internal) {
        this.internal = internal;
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
        return internal.getQuads(state, side, rand);
    }

    @Override
    public boolean isAmbientOcclusion() {
        return internal.isAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return internal.isGui3d();
    }

    @Override
    public boolean isBuiltInRenderer() {
        return true;
    }

    @Override
    @Nonnull
    public TextureAtlasSprite getParticleTexture() {
        return internal.getParticleTexture();
    }

    @Override
    @Nonnull
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.NONE;
    }

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType type) {
        return Pair.of(this, internal.handlePerspective(type).getRight());
    }
}
